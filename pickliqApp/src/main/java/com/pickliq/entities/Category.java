package com.pickliq.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	private String name;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categorieId, String name) {
		super();
		this.categoryId = categorieId;
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categorieId) {
		this.categoryId = categorieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
