package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.CategoryDAO;
import com.pickliq.entities.AlcoholInfos;

@Service("categoryService")
public class CategoryService {
	
	@Autowired
	 CategoryDAO categoryDao;

	@Transactional
	public List<AlcoholInfos> getCategoryAlcohol(String name) {
		return categoryDao.getCategoryAlcohol(name);
	}

}
