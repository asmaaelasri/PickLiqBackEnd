package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.AlcoholrangeDAOWebInterface;
import com.pickliq.entities.Alcoholrange;

@Service("alcoholrangeServiceWeb")
public class AlcoholrangeServiceWeb {
	
	@Autowired
	 AlcoholrangeDAOWebInterface alcoholrangeDaoWeb;
	
	@Transactional
   public Iterable<Alcoholrange> listAllAlcoholranges() {
       return alcoholrangeDaoWeb.findAll();
   }

}
