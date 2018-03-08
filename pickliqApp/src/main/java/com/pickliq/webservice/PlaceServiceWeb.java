package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.PlaceDAOWebInterface;
import com.pickliq.entities.Place;

@Service("placeServiceWeb")
public class PlaceServiceWeb {
	@Autowired
	 PlaceDAOWebInterface placeDaoWeb;
	
	@Transactional
	public Place savePlace(Place place) {
		return placeDaoWeb.save(place);
		
	}

	@Transactional
    public Iterable<Place> listAllPlaces() {
        return placeDaoWeb.findAll();
    }

	@Transactional
	public Place getPlaceById(Integer placeId) {
		return placeDaoWeb.findOne(placeId);
	}

	@Transactional
	public void deletePlace(Integer placeId) {
        placeDaoWeb.delete(placeId);	
	}

	@Transactional
	public void update(String name, String address, double latitude, double longitude, Integer placeId) {
		placeDaoWeb.update(name,address,latitude,longitude,placeId);
	}

}
