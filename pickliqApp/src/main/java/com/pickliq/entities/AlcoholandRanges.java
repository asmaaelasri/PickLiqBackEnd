package com.pickliq.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class AlcoholandRanges implements Serializable{
	@Embeddable
    public static class Pkk implements Serializable {
		@Column(nullable = false, updatable = false)
        private int alcoholId;
		
		@Column(nullable = false, updatable = false)
        private int alcoholrangeId;

		public Pkk() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Pkk(int alcoholId, int alcoholrangeId) {
			super();
			this.alcoholId = alcoholId;
			this.alcoholrangeId = alcoholrangeId;
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

		
	}
	
	 @EmbeddedId
	    private Pkk pkk;

	    @ManyToOne
	    @JoinColumn(name = "alcoholrangeId", insertable = false, updatable = false)
	    private Alcoholrange alcoholrange;
	    @ManyToOne
	    @JoinColumn(name = "alcoholId", insertable = false, updatable = false)
	    private Alcohol alcohol;
	    @Column
	    private int price;
	    
		public AlcoholandRanges() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Pkk getPkk() {
			return pkk;
		}

		public void setPkk(Pkk pk) {
			this.pkk = pk;
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

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		
		
		
	
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "alcohol_id")
//	public Alcohol alcohol;
//	
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "alcoholrange_id")
//	public Alcoholrange alcoholrange;
//	
//	@Column(name = "price")
//	public Integer price;
//
//
//	
//	public Alcohol getAlcohol() {
//		return alcohol;
//	}
//
//	
//	public void setAlcohol(Alcohol alcohol) {
//		this.alcohol = alcohol;
//	}
//
// 
//	public Alcoholrange getAlcoholrange() {
//		return alcoholrange;
//	}
//
//	public void setAlcoholrange(Alcoholrange alcoholrange) {
//		this.alcoholrange = alcoholrange;
//	}
//
//	public Integer getPrice() {
//		return price;
//	}
//
//	public void setPrice(Integer price) {
//		this.price = price;
//	}

}
