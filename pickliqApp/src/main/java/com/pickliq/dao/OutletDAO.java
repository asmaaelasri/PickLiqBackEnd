package com.pickliq.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pickliq.entities.Outlet;

@Repository
public class OutletDAO {
	
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	@SuppressWarnings("unchecked")
	public List<Outlet> getOutlets() {
		Session session = this.getSession();
		List<Outlet> outletList = session.createQuery("from Outlet").list();
		return outletList;
	}

}
