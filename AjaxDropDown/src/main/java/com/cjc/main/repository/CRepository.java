package com.cjc.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cjc.main.model.City;

public interface CRepository extends CrudRepository<City, Integer>{

	public List<City> findAllBySid(int sid);
}
