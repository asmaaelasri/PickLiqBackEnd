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

import com.pickliq.entities.Availability;
import com.pickliq.entities.Availability.AvailabilityPk;
import com.pickliq.webservice.AlcoholServiceWeb;
import com.pickliq.webservice.AlcoholrangeServiceWeb;
import com.pickliq.webservice.AvailabilityServiceWeb;
import com.pickliq.webservice.PlaceServiceWeb;




@Controller
public class AvailabilityControllerWeb {
	
	@Autowired
	AvailabilityServiceWeb availabilityServiceWeb;
	
	@Autowired
	AlcoholServiceWeb alcoholServiceWeb;
	
	@Autowired
	PlaceServiceWeb placeServiceWeb;
	
	@Autowired
	AlcoholrangeServiceWeb alcoholrangeServiceWeb;

	@RequestMapping(value = "/addavailability")
	public String addavailability(Model model) {		
		model.addAttribute("availability", new Availability());
		model.addAttribute("places", placeServiceWeb.listAllPlaces());
		model.addAttribute("alcoholranges", alcoholrangeServiceWeb.listAllAlcoholranges());
		model.addAttribute("alcohols", alcoholServiceWeb.listAllAlcohols());
		return "add-availability";
	}
	
	@RequestMapping(value = "/addAvailability", method = RequestMethod.POST)
	public String AddAvailability(Availability availability) {
		availability.setAvailabilityPk(new AvailabilityPk(availability.getPlace().getPlaceId(),availability.getAlcohol().getAlcoholId(),availability.getAlcoholrange().getRangeId()));
		System.out.println(availability.getPlace().getName()+" "+availability.getPlace().getName());
		availabilityServiceWeb.saveAvailability(availability);
		return "redirect:/listavailability";
	}
	
	@RequestMapping(value = "/list-availability")
	public String listavailability(Model model) {
		return "list-availability";
	}
	
	@RequestMapping(value = "/listavailability", method = RequestMethod.GET)
	public String list(Model model) {	
		model.addAttribute("availabilities", availabilityServiceWeb.listAllAvailabilities());
		return "list-availability";
	}
	
	@RequestMapping("availability/delete/{alcoholId}/{placeId}/{rangeId}")
    public String delete(@PathVariable Integer alcoholId,@PathVariable Integer placeId,@PathVariable Integer rangeId){
		Availability av = new Availability();
		Iterator<Availability> it = availabilityServiceWeb.listAllAvailabilities().iterator();
		while (it.hasNext()) {
			Availability availability = it.next();
			AvailabilityPk pk = availability.getAvailabilityPk();
			if(pk.getAlcoholId()==alcoholId && pk.getAlcoholrangeId()==rangeId && pk.getPlaceId()==placeId) {
				av = availability;
			}
		}		
        availabilityServiceWeb.deleteAvailability(av.getAvailabilityPk());
        return "redirect:/listavailability";
    }

	
}
