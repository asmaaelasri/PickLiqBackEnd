package com.pickliq.dao;

import org.springframework.data.repository.CrudRepository;

import com.pickliq.entities.Category;

public interface CategoryDAOWebInterface extends CrudRepository<Category, Integer>{

}
