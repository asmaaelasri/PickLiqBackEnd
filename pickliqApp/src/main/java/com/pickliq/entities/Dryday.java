package com.pickliq.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dryday implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int drydayId;
	
	private String date;
	
	private String name;

	public Dryday() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dryday(int drydayId, String date, String name) {
		super();
		this.drydayId = drydayId;
		this.date = date;
		this.name = name;
	}

	public int getDrydayId() {
		return drydayId;
	}

	public void setDrydayId(int drydayId) {
		this.drydayId = drydayId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
