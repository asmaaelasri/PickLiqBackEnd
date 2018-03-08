package com.pickliq.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickliq.entities.AlcoholInfos;
import com.pickliq.webservice.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	 CategoryService categoryService;
	
	@RequestMapping(value = "/getCategoryAlcohol/{name}/", method = RequestMethod.GET, headers = "Accept=application/json")
	 public List<AlcoholInfos> getCategoryAlcohol(@PathVariable("name") String name) {
	  	  return categoryService.getCategoryAlcohol(name);
	 }
	
	
	
}
