package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.AlcoholandRangesDAOWebInterface;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholandRanges;

@Service("alcoholandrangesServiceWeb")
public class AlcoholandRangesServiceWeb {
	
	@Autowired
	 AlcoholandRangesDAOWebInterface alcoholandrangesDaoWeb;
	
	@Transactional
	public AlcoholandRanges saveAlcoholandranges(AlcoholandRanges alcoholandranges) {
		return alcoholandrangesDaoWeb.save(alcoholandranges);
		
	}

	@Transactional
	public List<AlcoholandRanges> findByAlcohol(Alcohol alc) {
		return alcoholandrangesDaoWeb.findByAlcohol(alc);
	}

	@Transactional
	public void deleteAlcoholandRanges(Alcohol alcohol) {
		alcoholandrangesDaoWeb.deleteAlcoholandRanges(alcohol);		
	}

}
