package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.SearchCategoryPriceDAO;
import com.pickliq.entities.AlcoholInfos;

@Service("searchcategorypriceService")
public class SearchCategoryPriceService {
	
	@Autowired
	 SearchCategoryPriceDAO searchcategorypriceDao;
	
	@Transactional
	public List<AlcoholInfos> search(String category, Integer price) {
		return searchcategorypriceDao.search(category,price);
			
	}

	@Transactional
	public List<AlcoholInfos> searchprice(Integer price) {
		return searchcategorypriceDao.searchprice(price);
	}

}
