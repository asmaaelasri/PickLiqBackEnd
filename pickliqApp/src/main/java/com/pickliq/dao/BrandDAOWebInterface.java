package com.pickliq.dao;

import org.springframework.data.repository.CrudRepository;

import com.pickliq.entities.Brand;


public interface BrandDAOWebInterface extends CrudRepository<Brand, Integer> {

}
