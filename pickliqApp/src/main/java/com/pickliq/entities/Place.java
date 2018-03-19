package com.pickliq.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Place implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int placeId;
	private String name;
	private String address;
	private double latitude;
	private double longitude;
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Place(int placeId, String name, String address, double latitude, double longitude) {
		super();
		this.placeId = placeId;
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Place(String name, String address, double latitude, double longitude) {
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/*@ManyToMany(mappedBy="places")
    public Set<Alcohol> alcohols;
	
	public Set<Alcohol> getAlcohols() {
		return alcohols;
	}
	public void setAlcohols(Set<Alcohol> alcohols) {
		this.alcohols = alcohols;
	}*/

}
