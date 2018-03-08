package com.pickliq.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pickliq.entities.Place;

public interface PlaceDAOWebInterface extends CrudRepository<Place, Integer>{
	@Modifying
	@Transactional
	@Query("UPDATE Place p SET p.name = :name, p.address = :address, p.latitude = :latitude, p.longitude = :longitude WHERE p.placeId = :placeId")
	public void update(@Param("name") String name, @Param("address") String address, @Param("latitude") double latitude, @Param("longitude") double longitude, @Param("placeId") int placeId); 

}
