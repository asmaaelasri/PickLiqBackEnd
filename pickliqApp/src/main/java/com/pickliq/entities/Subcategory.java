package com.pickliq.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Subcategory implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subCategoryId;
	
	private String name;
	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subcategory(int subCategoryId, String name) {
		super();
		this.subCategoryId = subCategoryId;
		this.name = name;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
