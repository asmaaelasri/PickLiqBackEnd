package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.CategoryDAOWebInterface;
import com.pickliq.entities.Category;

@Service("categoryServiceWeb")
public class CategoryServiceWeb {
	@Autowired
	 CategoryDAOWebInterface categoryDaoWeb;
	
	@Transactional
    public Iterable<Category> listAllCategories() {
        return categoryDaoWeb.findAll();
    }

}
