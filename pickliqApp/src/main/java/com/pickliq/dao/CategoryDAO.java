package com.pickliq.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholCatSubcat;
import com.pickliq.entities.AlcoholInfos;
import com.pickliq.entities.AlcoholandAlcoholcatsubcat;
import com.pickliq.entities.AlcoholandRanges;
import com.pickliq.entities.Category;

@Repository
public class CategoryDAO {
	
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	@SuppressWarnings("unchecked")
	public List<AlcoholInfos> getCategoryAlcohol(String name) {
		Session session = this.getSession();
		List<AlcoholInfos> list = new ArrayList<>();
		//get the category chosen 
		Category category = (Category) session.createCriteria(Category.class)
				 .add(Restrictions.eq("name", name)).list().get(0);
		//get the all the alcohols that have the category 
		List<AlcoholCatSubcat> alcoholcatsubcatlist =  session.createCriteria(AlcoholCatSubcat.class)
				 .add(Restrictions.eq("category", category)).list();
		for(int j=0;j<alcoholcatsubcatlist.size();j++) {
			AlcoholCatSubcat alcoholcatsubcat = alcoholcatsubcatlist.get(j);
			//get each alcohol 
		    Alcohol alcohol = alcoholcatsubcat.getAlcohol();
			//get the alcohol ranges list
			List<AlcoholandRanges> alcoholandrangeslist = session.createCriteria(AlcoholandRanges.class)
					 .add(Restrictions.eq("alcohol", alcohol)).list();
			for(int i=0;i<alcoholandrangeslist.size();i++) {
				list.add(new AlcoholInfos(alcohol.getName(), alcohol.getBrand().getName(), category.getName(), alcoholcatsubcat.getSubcategory().getName(), alcoholandrangeslist.get(i).getAlcoholrange().getName(), alcoholandrangeslist.get(i).getPrice()));
			}
		}		
		return list;
	}
	
	
	

}
