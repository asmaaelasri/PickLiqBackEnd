package com.pickliq.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pickliq.entities.Subcategory;

@Repository
public class SubcategoryDAO {

	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	public Subcategory getSubcategory(String name) {
		Session session = this.getSession();
		Subcategory subcategory = (Subcategory) session.createCriteria(Subcategory.class)
				 .add(Restrictions.eq("name", name)).list().get(0);
		return subcategory;
	}

}
