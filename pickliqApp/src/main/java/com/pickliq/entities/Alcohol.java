package com.pickliq.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Alcohol implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int alcoholId;

	private String name;
	
	public Alcohol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Alcohol(int alcoholId, String name) {
		super();
		this.alcoholId = alcoholId;
		this.name = name;
	}
	public int getAlcoholId() {
		return alcoholId;
	}
	public void setAlcoholId(int alcoholId) {
		this.alcoholId = alcoholId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@ManyToMany
//    @JoinTable(name="Range_Alcohol",joinColumns=@JoinColumn(name="alcoholId", referencedColumnName="alcoholId"),
//    	      inverseJoinColumns=@JoinColumn(name="rangeId", referencedColumnName="rangeId"))
//    public List<Alcoholrange> ranges;
	
//	@OneToMany(mappedBy = "alcohol", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<AlcoholandRanges> alcoholandranges;
//
//    public List<AlcoholandRanges> getAlcoholandranges() {
//        return alcoholandranges;
//    }
//	
//	public void setAlcoholandranges(List<AlcoholandRanges> alcoholandranges) {
//        this.alcoholandranges = alcoholandranges;
//    }
	
	/*@JsonIgnore
	@ManyToMany
    @JoinTable(name="place_Alcohol",joinColumns=@JoinColumn(name="alcoholId", referencedColumnName="alcoholId"),
    	      inverseJoinColumns=@JoinColumn(name="placeId", referencedColumnName="placeId"))
    public List<Place> places;*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="brandId")
	  private Brand brand;
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
//	public List<Alcoholrange> getRanges() {
//		return ranges;
//	}
//	public void setRanges(List<Alcoholrange> ranges) {
//		this.ranges = ranges;
//	}
	/*public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}*/
	
	
}
