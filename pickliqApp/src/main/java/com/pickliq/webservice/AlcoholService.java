package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.AlcoholDAO;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholInfos;

@Service("alcoholService")
public class AlcoholService {
	
	@Autowired
	 AlcoholDAO alcoholDao;

	@Transactional
	public Alcohol getAlcohol(Integer id) {
		return alcoholDao.getAlcohol(id);

	}

	@Transactional
	public List<Alcohol> getAlcohols() {
		return alcoholDao.getAlcohols();

	}

	@Transactional
	public List<AlcoholInfos> getAlcoholByName(String name) {
		return alcoholDao.getAlcoholByName(name);
		
	}

}
