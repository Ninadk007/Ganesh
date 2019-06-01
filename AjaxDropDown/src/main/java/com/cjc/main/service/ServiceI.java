package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.City;
import com.cjc.main.model.Country;
import com.cjc.main.model.State;

public interface ServiceI {

	public List<Country> getcountry();
	public List<State> getstate(int cid);
	public List<City> getcity(int sid);
}
