package com.cjc.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cjc.main.model.State;

public interface SRepository extends CrudRepository<State, Integer>{

	public List<State> findAllByCid(int cid);
}
