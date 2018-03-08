package com.pickliq.webservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickliq.dao.OutletDAO;
import com.pickliq.entities.Outlet;

@Service("outletService")
public class OutletService {

	@Autowired
	 OutletDAO outletDao;
	
	
	@Transactional
	public List<Outlet> getOutlets() {
		return outletDao.getOutlets();
	}

}
