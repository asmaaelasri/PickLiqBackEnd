package com.pickliq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickliq.entities.Subcategory;
import com.pickliq.webservice.SubcategoryService;

@RestController
public class SubcategoryController {
	
	@Autowired
	 SubcategoryService subcategoryService;
	
	@RequestMapping(value = "/getSubcategory/{name}/", method = RequestMethod.GET, headers = "Accept=application/json")
	 public Subcategory getSubcategory(@PathVariable("name") String name) {
	  	  return subcategoryService.getSubcategory(name);
	 }
	

}
