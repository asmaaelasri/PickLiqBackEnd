package com.pickliq.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class AlcoholCatSubcat implements Serializable{
	
	 @Embeddable
	    public static class Pk implements Serializable {
	        @Column(nullable = false, updatable = false)
	        private int categoryId;

	        @Column(nullable = false, updatable = false)
	        private int subcategoryId;

	        @Column(nullable = false, updatable = false)
	        private int alcoholId;

			public Pk() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Pk(int categoryId, int subcategoryId, int alcoholId) {
				super();
				this.categoryId = categoryId;
				this.subcategoryId = subcategoryId;
				this.alcoholId = alcoholId;
			}

			public int getCategoryId() {
				return categoryId;
			}

			public void setCategoryId(int categoryId) {
				this.categoryId = categoryId;
			}

			public int getSubcategoryId() {
				return subcategoryId;
			}

			public void setSubcategoryId(int subcategoryId) {
				this.subcategoryId = subcategoryId;
			}

			public int getAlcoholId() {
				return alcoholId;
			}

			public void setAlcoholId(int alcoholId) {
				this.alcoholId = alcoholId;
			}

	        
	        
	    }

	    @EmbeddedId
	    private Pk pk;

	    @ManyToOne
	    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
	    private Category category;
	    @ManyToOne
	    @JoinColumn(name = "alcoholId", insertable = false, updatable = false)
	    private Alcohol alcohol;
	    @ManyToOne
	    @JoinColumn(name = "subcategoryId", insertable = false, updatable = false)
	    private Subcategory subcategory;
	    
		public Pk getPk() {
			return pk;
		}
		public void setPk(Pk pk) {
			this.pk = pk;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public Alcohol getAlcohol() {
			return alcohol;
		}
		public void setAlcohol(Alcohol alcohol) {
			this.alcohol = alcohol;
		}
		public Subcategory getSubcategory() {
			return subcategory;
		}
		public void setSubcategory(Subcategory subcategory) {
			this.subcategory = subcategory;
		}

	    


}
