package com.pickliq.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Brand implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int brandId;
	
	private String name;
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(int brandId, String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="brand")
		  private Set<Alcohol> alcohols;
	
}
