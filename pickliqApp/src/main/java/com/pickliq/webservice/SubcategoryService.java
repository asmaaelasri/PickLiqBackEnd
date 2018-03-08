package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.SubcategoryDAO;
import com.pickliq.entities.Subcategory;

@Service("subcategoryService")
public class SubcategoryService {
	@Autowired
	 SubcategoryDAO subcategoryDao;

	@Transactional
	public Subcategory getSubcategory(String name) {
		return subcategoryDao.getSubcategory(name);
	}

}
