package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.AlcoholCatSubcatDAOWebInterface;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholCatSubcat;

@Service("alcoholcatsubcatServiceWeb")
public class AlcoholCatSubcatServiceWeb {
	
	@Autowired
	 AlcoholCatSubcatDAOWebInterface alcoholcatsubcatDaoWeb;
	
	@Transactional
	public AlcoholCatSubcat saveAlcoholcatsubcat(AlcoholCatSubcat alcoholcatsubcat) {
		return alcoholcatsubcatDaoWeb.save(alcoholcatsubcat);
		
	}

	@Transactional
	public Iterable<AlcoholCatSubcat> listAllAlcoholsCatSubcat() {
       return alcoholcatsubcatDaoWeb.findAll();
	}

	@Transactional
	public List<AlcoholCatSubcat> findByAlcohol(Alcohol alc) {		
		return alcoholcatsubcatDaoWeb.findByAlcohol(alc);
	}

	@Transactional
	public void deleteAlcoholCatSubcat(Alcohol alcohol) {
		alcoholcatsubcatDaoWeb.deleteAlcoholCatSubcat(alcohol);
	}

}
