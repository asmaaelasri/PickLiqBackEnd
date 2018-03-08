package com.pickliq.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Alcoholrange implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rangeId;
	

	private String name;
	public Alcoholrange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alcoholrange(int rangeId, String name) {
		super();
		this.rangeId = rangeId;
		this.name = name;
	}
	public int getRangeId() {
		return rangeId;
	}
	public void setRangeId(int rangeId) {
		this.rangeId = rangeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@ManyToMany(mappedBy="ranges")
//    public Set<Alcohol> alcohols;
//	
//	public Set<Alcohol> getAlcohols() {
//		return alcohols;
//	}
//	public void setAlcohols(Set<Alcohol> alcohols) {
//		this.alcohols = alcohols;
//	}
	
//	 @OneToMany(mappedBy = "alcoholrange")
//	    private List<AlcoholandRanges> alcoholandranges;
//
//	    public List<AlcoholandRanges> getAlcoholandranges() {
//	        return alcoholandranges;
//	    }
//
//	    public void setAlcoholandranges(List<AlcoholandRanges> alcoholandranges) {
//	        this.alcoholandranges = alcoholandranges;
//	    }
	
	

}
