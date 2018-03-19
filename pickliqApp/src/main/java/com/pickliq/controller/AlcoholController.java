package com.pickliq.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickliq.entities.About;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholInfos;
import com.pickliq.entities.Dryday;
import com.pickliq.webservice.AlcoholService;

@RestController
public class AlcoholController {

	@Autowired
	 AlcoholService alcoholService;
	
	@RequestMapping(value = "/getAlcohol/{alcoholId}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public Alcohol getAlcool(@PathVariable("alcoholId") Integer id) {
	  	  return alcoholService.getAlcohol(id);
	 }
	
	@RequestMapping(value = "/getAlcoholByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List<AlcoholInfos> getAlcool(@PathVariable("name") String name) {
	  	  return alcoholService.getAlcoholByName(name);
	 }
	
	@RequestMapping(value = "/getAllAlcohols", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Alcohol> getAlcohols() {
		return alcoholService.getAlcohols();
	}
	
	@RequestMapping(value = "/getAbout", method = RequestMethod.GET, headers = "Accept=application/json")
	public About getAbout() {
		return alcoholService.getAbout();
	}
	
	@RequestMapping(value = "/getDrydays", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Dryday> getDrydays() {
		return alcoholService.getDrydays();
	}
}
