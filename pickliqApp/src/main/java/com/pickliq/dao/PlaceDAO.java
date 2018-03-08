package com.pickliq.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pickliq.entities.Place;

@Repository
public class PlaceDAO {
	
 
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    
	@SuppressWarnings("unchecked")
	public List<Place> getPlaces() {
		Session session = this.getSession();
		List<Place> placeList = session.createQuery("from Place").list();
		return placeList;
	}
	
	

	
}
