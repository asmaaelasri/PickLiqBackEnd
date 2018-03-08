package com.pickliq.dao;

import org.springframework.data.repository.CrudRepository;

import com.pickliq.entities.Alcohol;

public interface AlcoholDAOWebInterface extends CrudRepository<Alcohol, Integer> {

}
