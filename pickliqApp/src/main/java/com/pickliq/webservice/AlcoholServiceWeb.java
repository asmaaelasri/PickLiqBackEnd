package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.AlcoholDAOWebInterface;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.Place;

@Service("alcoholServiceWeb")
public class AlcoholServiceWeb {

	@Autowired
	AlcoholDAOWebInterface alcoholDaoWeb;

	@Transactional
	public Alcohol saveAlcohol(Alcohol alcohol) {
		return alcoholDaoWeb.save(alcohol);

	}

	@Transactional
	public Iterable<Alcohol> listAllAlcohols() {
		return alcoholDaoWeb.findAll();
	}

	@Transactional
	public void deleteAlcohol(Integer alcoholId) {
		alcoholDaoWeb.delete(alcoholId);
	}

	@Transactional
	public Alcohol getAlcoholById(Integer alcoholId) {
		return alcoholDaoWeb.findOne(alcoholId);
	}

}
