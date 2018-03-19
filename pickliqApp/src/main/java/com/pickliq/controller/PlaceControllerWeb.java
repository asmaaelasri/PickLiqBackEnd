package com.pickliq.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.pickliq.entities.Availability;
import com.pickliq.entities.Place;
import com.pickliq.entities.Availability.AvailabilityPk;
import com.pickliq.webservice.AvailabilityServiceWeb;
import com.pickliq.webservice.PlaceServiceWeb;

@Controller
public class PlaceControllerWeb {
	@Autowired
	 PlaceServiceWeb placeServiceWeb;
	
	@Autowired
	AvailabilityServiceWeb availabilityServiceWeb;
	
	
	@RequestMapping(value = "/addplace")
	public String addplace(Model model) {
        model.addAttribute("place", new Place());
		return "add-place";
	}
	
	@RequestMapping(value = "/addPlace", method = RequestMethod.POST)
	public String AddPlace(Place place) {
		placeServiceWeb.savePlace(place);
        return "redirect:/listplace";
	}
	
	@RequestMapping(value = "/list-place")
    public String listplace(Model model){
        return "list-place";
    }
	
	
	@RequestMapping(value = "/listplace", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("places", placeServiceWeb.listAllPlaces());
        return "list-place";
    }
	
//	@RequestMapping("place/edit/{placeId}")
//    public String edit(@PathVariable Integer placeId, Model model){
//        model.addAttribute("place", placeServiceWeb.getPlaceById(placeId));
//        return "add-place";
//    }
	
	@RequestMapping("place/delete/{placeId}")
    public String delete(@PathVariable Integer placeId){
		Iterator<Availability> it = availabilityServiceWeb.listAllAvailabilities().iterator();
		while (it.hasNext()) {
			Availability availability = it.next();
			AvailabilityPk pk = availability.getAvailabilityPk();
			if(pk.getPlaceId()==placeId) {
				availabilityServiceWeb.deleteAvailability(pk);
			}
		}	
        placeServiceWeb.deletePlace(placeId);
        return "redirect:/listplace";
    }

	@RequestMapping("/place/edit/{placeId}")
    public String edit(@PathVariable Integer placeId,WebRequest webRequest){
		Place p=placeServiceWeb.getPlaceById(placeId);
        
        
        System.out.println("*****************************************");  
        System.out.println(p.getName());
        System.out.println("*****************************************");
        return "redirect:/listplace";
    }


}
