package com.pickliq.entities;

import java.util.List;

public class AlcoholandAlcoholcatsubcat {
	Alcohol alcohol;
	AlcoholCatSubcat alcoholcatsubcat;
	List<AlcoholandRanges> alcoholandranges;
	
	
	
	public AlcoholandAlcoholcatsubcat(Alcohol alcohol, AlcoholCatSubcat alcoholcatsubcat,
			List<AlcoholandRanges> alcoholandranges) {
		super();
		this.alcohol = alcohol;
		this.alcoholcatsubcat = alcoholcatsubcat;
		this.alcoholandranges = alcoholandranges;
	}
	public AlcoholandAlcoholcatsubcat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alcohol getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(Alcohol alcohol) {
		this.alcohol = alcohol;
	}
	public AlcoholCatSubcat getAlcoholcatsubcat() {
		return alcoholcatsubcat;
	}
	public void setAlcoholcatsubcat(AlcoholCatSubcat alcoholcatsubcat) {
		this.alcoholcatsubcat = alcoholcatsubcat;
	}
	public List<AlcoholandRanges> getAlcoholandranges() {
		return alcoholandranges;
	}
	public void setAlcoholandranges(List<AlcoholandRanges> alcoholandranges) {
		this.alcoholandranges = alcoholandranges;
	}
	
	

}
