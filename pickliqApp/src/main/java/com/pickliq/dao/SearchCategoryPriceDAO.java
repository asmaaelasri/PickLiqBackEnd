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
import com.pickliq.entities.AlcoholandRanges;
import com.pickliq.entities.Category;

@Repository
public class SearchCategoryPriceDAO {
	
	@Autowired
	 AlcoholDAO alcoholDao;

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@SuppressWarnings("unchecked")
	public List<AlcoholInfos> search(String category, Integer price) {
		Session session = this.getSession();
		List<AlcoholInfos> list = new ArrayList<>();
		// get the category chosen
		Category cat = (Category) session.createCriteria(Category.class).add(Restrictions.eq("name", category)).list()
				.get(0);
		// get the all the alcohols that have the category
		List<AlcoholCatSubcat> alcoholcatsubcatlist = session.createCriteria(AlcoholCatSubcat.class)
				.add(Restrictions.eq("category", cat)).list();
		for (int j = 0; j < alcoholcatsubcatlist.size(); j++) {
			AlcoholCatSubcat alcoholcatsubcat = alcoholcatsubcatlist.get(j);
			// get each alcohol
			Alcohol alcohol = alcoholcatsubcat.getAlcohol();
			// get the alcohol ranges list
			List<AlcoholandRanges> alcoholandrangeslist = session.createCriteria(AlcoholandRanges.class)
					.add(Restrictions.eq("alcohol", alcohol)).add(Restrictions.le("price", price)).list();
			for (int i = 0; i < alcoholandrangeslist.size(); i++) {
				list.add(new AlcoholInfos(alcohol.getName(), alcohol.getBrand().getName(), category,
						alcoholcatsubcat.getSubcategory().getName(),
						alcoholandrangeslist.get(i).getAlcoholrange().getName(),
						alcoholandrangeslist.get(i).getPrice()));
			}
		}

		return list;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List<AlcoholInfos> searchprice(Integer price) {
		Session session = this.getSession();
		List<AlcoholInfos> list = new ArrayList<>();
		List<Alcohol> alcoholList = alcoholDao.getAlcohols();
		for(int i=0;i<alcoholList.size();i++) {
			//for each alcohol find the different ranges 
			List<AlcoholandRanges> alcoholandrangeslist = session.createCriteria(AlcoholandRanges.class)
					.add(Restrictions.eq("alcohol", alcoholList.get(i))).add(Restrictions.le("price", price)).list();
			for(int j=0;j<alcoholandrangeslist.size();j++) {
				AlcoholCatSubcat alcoholcatsubcat = (AlcoholCatSubcat) session.createCriteria(AlcoholCatSubcat.class)
						.add(Restrictions.eq("alcohol", alcoholList.get(i))).list().get(0);
				list.add(new AlcoholInfos(alcoholList.get(i).getName(), alcoholList.get(i).getBrand().getName(), alcoholcatsubcat.getCategory().getName(),
						alcoholcatsubcat.getSubcategory().getName(),
						alcoholandrangeslist.get(j).getAlcoholrange().getName(),
						alcoholandrangeslist.get(j).getPrice()));
			}
		}
		return list;		
	}

}
