package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.BrandDAOWebInterface;
import com.pickliq.entities.Brand;

@Service("brandServiceWeb")
public class BrandServiceWeb {
	@Autowired
	 BrandDAOWebInterface brandDaoWeb;
	
	@Transactional
   public Iterable<Brand> listAllBrands() {
       return brandDaoWeb.findAll();
   }

}
