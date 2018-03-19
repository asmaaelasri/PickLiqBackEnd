package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.PlaceDAO;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholInfos;
import com.pickliq.entities.Availability;
import com.pickliq.entities.Place;

@Service("placeService")
public class PlaceService {

	@Autowired
	 PlaceDAO placeDao;
	
	@Transactional
	public List<Place> getPlaces() {
		return placeDao.getPlaces();
		
	}

	@Transactional
	public List<AlcoholInfos> getAvailability(Integer id) {
		return placeDao.getAvailability(id);
	}
	
	

	
}
