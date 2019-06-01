package com.cjc.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.City;
import com.cjc.main.model.Country;
import com.cjc.main.model.State;
import com.cjc.main.repository.CRepository;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.repository.SRepository;
import com.cjc.main.service.ServiceI;

@Service
public class ServiceImpl implements ServiceI{

	@Autowired
	HomeRepository hr;
	
	@Autowired
	SRepository sr;
	
	@Autowired
	CRepository cr;
	
	@Override
	public List<Country> getcountry() {
		
		List<Country> l = (List<Country>) hr.findAll();
		return l;
	}

	@Override
	public List<State> getstate(int cid) {
		
		List<State> l = sr.findAllByCid(cid);
		return l;
	}

	@Override
	public List<City> getcity(int sid) {
		List<City> l = cr.findAllBySid(sid);
		return l;
	}

	
}
