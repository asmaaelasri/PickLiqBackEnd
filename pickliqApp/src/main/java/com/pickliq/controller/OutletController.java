package com.pickliq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pickliq.entities.Outlet;
import com.pickliq.webservice.OutletService;


@RestController
public class OutletController {
	
	@Autowired
	OutletService outletService;


	@RequestMapping(value = "/getAllOutlets", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Outlet> getOutlets() {
		return outletService.getOutlets();
	}

}
