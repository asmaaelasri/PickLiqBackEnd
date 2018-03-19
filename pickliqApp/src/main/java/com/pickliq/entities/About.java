package com.pickliq.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class About implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aboutId;
	
	private String about;
	

	public About() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public About(int aboutId, String about) {
		super();
		this.aboutId = aboutId;
		this.about = about;
	}



	public int getAboutId() {
		return aboutId;
	}

	public void setAboutId(int aboutId) {
		this.aboutId = aboutId;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	


}
