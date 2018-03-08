package com.pickliq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickliq.entities.Place;
import com.pickliq.webservice.PlaceService;
import com.pickliq.webservice.PlaceServiceWeb;

@RestController
public class PlaceController {

	@Autowired
	PlaceServiceWeb placeServiceWeb;

	@Autowired
	PlaceService placeService;

	@RequestMapping(value = "/getAllPlaces", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Place> getPlaces() {
		return placeService.getPlaces();
	}



	@RequestMapping(value = "/place/edit/{name}/{address}/{latitude}/{longitude}/{placeId}",headers = "Accept=application/json") 
	public void edit(@PathVariable Integer placeId, @PathVariable String name, @PathVariable String address,
			@PathVariable double latitude, @PathVariable double longitude) {
		placeServiceWeb.update(name, address, latitude, longitude, placeId);

	}

}
