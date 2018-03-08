package com.pickliq.entities;

public class SearchCategoryPrice {
	String Category;
	Integer Price;
	public SearchCategoryPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchCategoryPrice(String category, Integer price) {
		super();
		Category = category;
		Price = price;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
	

}
