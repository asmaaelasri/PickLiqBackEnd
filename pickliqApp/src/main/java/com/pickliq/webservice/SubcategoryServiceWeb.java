package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.SubcategoryDAOWebInterface;
import com.pickliq.entities.Subcategory;

@Service("subcategoryServiceWeb")
public class SubcategoryServiceWeb {
	
	@Autowired
	 SubcategoryDAOWebInterface subcategoryDaoWeb;
	
	@Transactional
   public Iterable<Subcategory> listAllSubcategories() {
       return subcategoryDaoWeb.findAll();
   }

}
