package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.PlaceDAO;
import com.pickliq.entities.Place;

@Service("placeService")
public class PlaceService {

	@Autowired
	 PlaceDAO placeDao;
	
	@Transactional
	public List<Place> getPlaces() {
		return placeDao.getPlaces();
		
	}
	
	

	
}
