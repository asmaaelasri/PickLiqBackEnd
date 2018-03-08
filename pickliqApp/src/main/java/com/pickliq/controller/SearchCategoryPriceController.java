package com.pickliq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickliq.entities.AlcoholInfos;
import com.pickliq.webservice.SearchCategoryPriceService;

@RestController
public class SearchCategoryPriceController {
	
	@Autowired
	SearchCategoryPriceService searchcategorypriceService;
	
	@RequestMapping(value = "/search/{price}/{category}",headers = "Accept=application/json") 
	public List<AlcoholInfos> search(@PathVariable Integer price, @PathVariable String category) {
		return searchcategorypriceService.search(category,price);

	}
	
	@RequestMapping(value = "/search/{price}",headers = "Accept=application/json") 
	public List<AlcoholInfos> search(@PathVariable Integer price) {
		return searchcategorypriceService.searchprice(price);

	}


}
