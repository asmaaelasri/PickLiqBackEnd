package com.pickliq.webservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.AvailabilityDAOWebInterface;
import com.pickliq.entities.Availability;
import com.pickliq.entities.Availability.AvailabilityPk;

@Service("availabilityServiceWeb")
public class AvailabilityServiceWeb {
	@Autowired
	AvailabilityDAOWebInterface availabilityDaoWeb;
	
	@Transactional
	public Availability saveAvailability(Availability availability) {
		return availabilityDaoWeb.save(availability);

	}

	@Transactional
	public Iterable<Availability> listAllAvailabilities() {
		return availabilityDaoWeb.findAll();

	}

	@Transactional
	public void deleteAvailability(AvailabilityPk id) {
		availabilityDaoWeb.delete(id);	
	}

}
