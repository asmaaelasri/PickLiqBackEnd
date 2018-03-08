package com.pickliq.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholandRanges;

public interface AlcoholandRangesDAOWebInterface extends CrudRepository<AlcoholandRanges, Integer> {

	@Query( "select a from AlcoholandRanges a where a.alcohol=:x" )
	List<AlcoholandRanges> findByAlcohol(@Param("x") Alcohol alcohol);

	@Transactional
	@Modifying
	@Query( "delete from AlcoholandRanges a where a.alcohol=:x" )
	void deleteAlcoholandRanges(@Param("x") Alcohol alcohol);
}
