package com.pickliq.entities;

public class AlcoholInfos {
	String name;
	String brand;
	String category;
	String subcategory;
	String range;
	Integer price;
	public AlcoholInfos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlcoholInfos(String name, String brand, String category, String subcategory, String range, Integer price) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.subcategory = subcategory;
		this.range = range;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
	
}
