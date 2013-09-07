package com.ascent.dao;

import java.util.List;

import com.ascent.domain.State;

public interface StateDAO {

	public List findAll();
	
	public State findById(Integer id);
	
	public State findByEnName(String name);
}
