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
import com.pickliq.entities.Availability;
import com.pickliq.entities.Category;
import com.pickliq.entities.Place;
import com.pickliq.entities.Subcategory;

@Repository
public class PlaceDAO {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@SuppressWarnings("unchecked")
	public List<Place> getPlaces() {
		Session session = this.getSession();
		List<Place> placeList = session.createQuery("from Place").list();
		return placeList;
	}

	@SuppressWarnings("unchecked")
	public List<AlcoholInfos> getAvailability(Integer id) {
		Session session = this.getSession();
		List<AlcoholInfos> list = new ArrayList<>();
		Place place = (Place) session.createCriteria(Place.class).add(Restrictions.eq("placeId", id)).list().get(0);
		List<Availability> availabilityList = session.createCriteria(Availability.class)
				.add(Restrictions.eq("place", place)).list();
		System.out.println(availabilityList.size());
		for (int i = 0; i < availabilityList.size(); i++) {
			System.out.println(availabilityList.get(i).getAlcohol());
			AlcoholCatSubcat alcoholcatsubcat = (AlcoholCatSubcat) session.createCriteria(AlcoholCatSubcat.class)
					.add(Restrictions.eq("alcohol", availabilityList.get(i).getAlcohol())).list().get(0);
			System.out.println(alcoholcatsubcat.getCategory().getName());
			System.out.println(alcoholcatsubcat.getSubcategory().getName());
			System.out.println(alcoholcatsubcat.getAlcohol().getName());
			/*List<AlcoholandRanges> alcoholandrangeslist = session.createCriteria(AlcoholandRanges.class)
					.add(Restrictions.eq("alcohol", availabilityList.get(i).getAlcohol()))
					.add(Restrictions.le("price", availabilityList.get(i).getPrice())).list();
			for (int k = 0; k < alcoholandrangeslist.size(); k++) {*/
				list.add(new AlcoholInfos(availabilityList.get(i).getAlcohol().getName(),
						availabilityList.get(i).getAlcohol().getBrand().getName(),
						alcoholcatsubcat.getCategory().getName(), alcoholcatsubcat.getSubcategory().getName(),
						availabilityList.get(i).getAlcoholrange().getName(),
						availabilityList.get(i).getPrice()));
			//}

		}
		return list;
	}

}
