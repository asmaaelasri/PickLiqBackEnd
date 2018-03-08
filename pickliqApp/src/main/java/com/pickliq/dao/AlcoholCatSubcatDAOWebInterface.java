package com.pickliq.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholCatSubcat;

public interface AlcoholCatSubcatDAOWebInterface extends CrudRepository<AlcoholCatSubcat, Integer> {

	@Query("select a from AlcoholCatSubcat a where a.alcohol=:x")
	List<AlcoholCatSubcat> findByAlcohol(@Param("x") Alcohol alcohol);

	@Transactional
	@Modifying
	@Query("delete from AlcoholCatSubcat a where a.alcohol=:x")
	void deleteAlcoholCatSubcat(@Param("x") Alcohol alcohol);

}
