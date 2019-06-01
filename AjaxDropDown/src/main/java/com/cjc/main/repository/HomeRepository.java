package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.cjc.main.model.Country;

public interface HomeRepository extends CrudRepository<Country, Integer>{

}
