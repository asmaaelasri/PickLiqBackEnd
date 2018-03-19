package com.pickliq.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pickliq.entities.About;
import com.pickliq.entities.Alcohol;
import com.pickliq.entities.AlcoholCatSubcat;
import com.pickliq.entities.AlcoholInfos;
import com.pickliq.entities.AlcoholandRanges;
import com.pickliq.entities.Category;
import com.pickliq.entities.Dryday;
import com.pickliq.entities.Subcategory;

@Repository
public class AlcoholDAO {
	
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	public Alcohol getAlcohol(Integer id) {
		Session session = this.getSession();
		Alcohol alcohol = (Alcohol) session.createCriteria(Alcohol.class)
				 .add(Restrictions.eq("alcoholId", id)).list().get(0);
		return alcohol;
	}

	@SuppressWarnings("unchecked")
	public List<Alcohol> getAlcohols() {
		Session session = this.getSession();
		List<Alcohol> alcoholList = session.createQuery("from Alcohol").list();
		return alcoholList;
	}

	@SuppressWarnings("unchecked")
	public List<AlcoholInfos> getAlcoholByName(String name) {
		Session session = this.getSession();
		List<AlcoholInfos> list = new ArrayList<>();
		Alcohol alcohol = (Alcohol) session.createCriteria(Alcohol.class)
				 .add(Restrictions.eq("name", name)).list().get(0);
		List<AlcoholCatSubcat> alcoholcatsubcatlist =  session.createCriteria(AlcoholCatSubcat.class)
				 .add(Restrictions.eq("alcohol", alcohol)).list();
		for(int j=0;j<alcoholcatsubcatlist.size();j++) {
			AlcoholCatSubcat alcoholcatsubcat = alcoholcatsubcatlist.get(j);
			//get the category and subcategory of the alcohol 
		    Category category = alcoholcatsubcat.getCategory();
		    Subcategory subcategory = alcoholcatsubcat.getSubcategory();
			//get the alcohol ranges list
			List<AlcoholandRanges> alcoholandrangeslist = session.createCriteria(AlcoholandRanges.class)
					 .add(Restrictions.eq("alcohol", alcohol)).list();
			for(int i=0;i<alcoholandrangeslist.size();i++) {
				list.add(new AlcoholInfos(alcohol.getName(), alcohol.getBrand().getName(), category.getName(), subcategory.getName(), alcoholandrangeslist.get(i).getAlcoholrange().getName(), alcoholandrangeslist.get(i).getPrice()));
			}
		}		
		return list;
	}

	@SuppressWarnings("unchecked")
	public About getAbout() {
		Session session = this.getSession();
		List<About> about = session.createQuery("from About").list();	
		return about.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Dryday> getDrydays() {
		Session session = this.getSession();
		List<Dryday> drydays = session.createQuery("from Dryday").list();	
		return drydays;
	}


}
