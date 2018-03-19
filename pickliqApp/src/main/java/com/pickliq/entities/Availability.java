package com.pickliq.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Availability implements Serializable{
	@Embeddable
    public static class AvailabilityPk implements Serializable {
        @Column(nullable = false, updatable = false)
        private int alcoholId;

        @Column(nullable = false, updatable = false)
        private int alcoholrangeId;

        @Column(nullable = false, updatable = false)
        private int placeId;

		public AvailabilityPk() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AvailabilityPk(int placeId, int alcoholId, int alcoholrangeId) {
			super();
			this.placeId = placeId;
			this.alcoholrangeId = alcoholrangeId;
			this.alcoholId = alcoholId;
		}

		public int getAlcoholId() {
			return alcoholId;
		}

		public void setAlcoholId(int alcoholId) {
			this.alcoholId = alcoholId;
		}

		public int getAlcoholrangeId() {
			return alcoholrangeId;
		}

		public void setAlcoholrangeId(int alcoholrangeId) {
			this.alcoholrangeId = alcoholrangeId;
		}

		public int getPlaceId() {
			return placeId;
		}

		public void setPlaceId(int placeId) {
			this.placeId = placeId;
		}

		
        
        
    }

    @EmbeddedId
    private AvailabilityPk pk;
    
    private Integer price;
    
    @ManyToOne
    @JoinColumn(name = "alcoholrangeId", insertable = false, updatable = false)
    private Alcoholrange alcoholrange;
    @ManyToOne
    @JoinColumn(name = "alcoholId", insertable = false, updatable = false)
    private Alcohol alcohol;
    @ManyToOne
    @JoinColumn(name = "placeId", insertable = false, updatable = false)
    private Place place;
    
	public AvailabilityPk getAvailabilityPk() {
		return pk;
	}
	
	public void setAvailabilityPk(AvailabilityPk pk) {
		this.pk = pk;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Alcoholrange getAlcoholrange() {
		return alcoholrange;
	}
	public void setAlcoholrange(Alcoholrange alcoholrange) {
		this.alcoholrange = alcoholrange;
	}
	public Alcohol getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(Alcohol alcohol) {
		this.alcohol = alcohol;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	

}
