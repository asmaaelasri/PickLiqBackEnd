package com.pickliq.dao;

import org.springframework.data.repository.CrudRepository;

import com.pickliq.entities.Availability;
import com.pickliq.entities.Availability.AvailabilityPk;

public interface AvailabilityDAOWebInterface extends CrudRepository<Availability, AvailabilityPk>{

}
