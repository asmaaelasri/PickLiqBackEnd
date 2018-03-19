package com.pickliq.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholCatSubcat;
import com.pickliq.entities.AlcoholandAlcoholcatsubcat;
import com.pickliq.entities.AlcoholandRanges;
import com.pickliq.entities.Availability;
import com.pickliq.entities.AlcoholandRanges.Pkk;
import com.pickliq.entities.Availability.AvailabilityPk;
import com.pickliq.entities.AlcoholCatSubcat.Pk;
import com.pickliq.webservice.AlcoholCatSubcatServiceWeb;
import com.pickliq.webservice.AlcoholServiceWeb;
import com.pickliq.webservice.AlcoholandRangesServiceWeb;
import com.pickliq.webservice.AlcoholrangeServiceWeb;
import com.pickliq.webservice.AvailabilityServiceWeb;
import com.pickliq.webservice.BrandServiceWeb;
import com.pickliq.webservice.PlaceServiceWeb;

@Controller
public class AlcoholControllerWeb {
	@Autowired
	AlcoholServiceWeb alcoholServiceWeb;
	@Autowired
	AlcoholandRangesServiceWeb alcoholandrangesServiceWeb;
	@Autowired
	BrandServiceWeb brandServiceWeb;
	@Autowired
	AlcoholrangeServiceWeb alcoholrangeServiceWeb;
	@Autowired
	AlcoholCatSubcatServiceWeb alcoholcatsubcatServiceWeb;
	@Autowired
	PlaceServiceWeb placeServiceWeb;
	
	@Autowired
	AvailabilityServiceWeb availabilityServiceWeb;
	

	@RequestMapping(value = "/addalcohol")
	public String addalcohol(Model model) {		
		model.addAttribute("alcohol", new Alcohol());
		model.addAttribute("alcoholcatsubcat", new AlcoholCatSubcat());
		model.addAttribute("alcoholandranges", new AlcoholandRanges());
		model.addAttribute("places", placeServiceWeb.listAllPlaces());
		model.addAttribute("brands", brandServiceWeb.listAllBrands());
		model.addAttribute("alcoholranges", alcoholrangeServiceWeb.listAllAlcoholranges());
		return "add-alcohol";
	}

	@RequestMapping(value = "/addAlcohol", method = RequestMethod.POST)
	public String AddAlcohol(Alcohol alcohol, AlcoholCatSubcat alcoholcatsubcat, AlcoholandRanges alcoholandranges) {
		alcoholServiceWeb.saveAlcohol(alcohol);
//		System.out.println("alcohol"+alcohol.getAlcoholId());
//		System.out.println("hahoua kayn lobjet"+alcoholandranges);
//		System.out.println("hahoua kayn range"+alcoholandranges.getAlcoholrange().getRangeId());
//		System.out.println("hahoua kayn price"+alcoholandranges.getPrice());
		
		alcoholandranges.setAlcohol(alcohol);
		alcoholandranges.setPkk(new Pkk(alcohol.getAlcoholId(),alcoholandranges.getAlcoholrange().getRangeId()));
		System.out.println("hahoua kayn pk"+alcoholandranges.getPkk());     
		alcoholandrangesServiceWeb.saveAlcoholandranges(alcoholandranges);
		alcoholcatsubcat.setAlcohol(alcohol);
		alcoholcatsubcat.setPk(new Pk(alcoholcatsubcat.getCategory().getCategoryId(),
				alcoholcatsubcat.getSubcategory().getSubCategoryId(), alcohol.getAlcoholId()));
		alcoholcatsubcatServiceWeb.saveAlcoholcatsubcat(alcoholcatsubcat);
		return "redirect:/add-alcohol-step2/"+alcohol.getAlcoholId();
	}

	@RequestMapping(value = "/add-alcohol-step2/{alcoholId}")
	public String alcoholstep2(@PathVariable Integer alcoholId,Model model) {
		System.out.println("hahwa Id 1: " +alcoholId);
		model.addAttribute("alcoholandranges", new AlcoholandRanges());
		model.addAttribute("alcoholranges", alcoholrangeServiceWeb.listAllAlcoholranges());
		model.addAttribute("alcoholId",alcoholId);
		return "add-alcohol-step2";
	}


	
	@RequestMapping(value = "/addAlcoholStep2/{alcoholId}")
	public String addalcoholsecondstep(@PathVariable Integer alcoholId,Model model , AlcoholandRanges alcoholandranges) {
		System.out.println("hahwa alcoholrange: " +alcoholandranges.getPrice());
		System.out.println("hahwa Id 2: " +alcoholId);
		alcoholandranges.setAlcohol(alcoholServiceWeb.getAlcoholById(alcoholId));
		alcoholandranges.setPkk(new Pkk(alcoholId,alcoholandranges.getAlcoholrange().getRangeId()));
		alcoholandrangesServiceWeb.saveAlcoholandranges(alcoholandranges);
		return "redirect:/add-alcohol-step2/"+alcoholId;
	}

	
	@RequestMapping(value = "/list-alcohol")
	public String listalcohol(Model model) {
		return "list-alcohol";
	}

	@RequestMapping(value = "/listalcohol", method = RequestMethod.GET)
	public String list(Model model) {
		//model.addAttribute("alcohols", alcoholServiceWeb.listAllAlcohols());
		List<AlcoholandAlcoholcatsubcat> list = new ArrayList<AlcoholandAlcoholcatsubcat>();
		Iterator<Alcohol> it = alcoholServiceWeb.listAllAlcohols().iterator();
		System.out.println(alcoholServiceWeb.listAllAlcohols());
		while (it.hasNext()) {
			Alcohol alc = it.next();
			//System.out.println("hahwaaaaaaaaaa : "+alc.getAlcoholId());	
		    List<AlcoholCatSubcat> alccatsubcat = (List<AlcoholCatSubcat>) alcoholcatsubcatServiceWeb.findByAlcohol(alc);
		    List<AlcoholandRanges> alcandranges = (List<AlcoholandRanges>) alcoholandrangesServiceWeb.findByAlcohol(alc);
		    //System.out.println(alcoholcatsubcatServiceWeb.findByAlcohol(alc));
			list.add(new AlcoholandAlcoholcatsubcat(alc,alccatsubcat.get(0),alcandranges));
		}		
		model.addAttribute("alcohols", list);
		return "list-alcohol";
	}
	
	@RequestMapping("alcohol/delete/{alcoholId}")
    public String delete(@PathVariable Integer alcoholId){
       // System.out.println("Name"+alcoholServiceWeb.getAlcoholById(alcoholId).getName());        
		alcoholcatsubcatServiceWeb.deleteAlcoholCatSubcat(alcoholServiceWeb.getAlcoholById(alcoholId));
        alcoholandrangesServiceWeb.deleteAlcoholandRanges(alcoholServiceWeb.getAlcoholById(alcoholId));
        alcoholServiceWeb.deleteAlcohol(alcoholId);
        Iterator<Availability> it = availabilityServiceWeb.listAllAvailabilities().iterator();
		while (it.hasNext()) {
			Availability availability = it.next();
			AvailabilityPk pk = availability.getAvailabilityPk();
			if(pk.getAlcoholId()==alcoholId) {
				availabilityServiceWeb.deleteAvailability(pk);
			}
		}	
        return "redirect:/listalcohol";
    }


}
