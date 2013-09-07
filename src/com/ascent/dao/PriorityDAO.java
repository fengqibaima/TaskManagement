package com.ascent.dao;

import java.util.List;

import com.ascent.domain.Priority;

public interface PriorityDAO {

	public List findAll();
	
	public Priority findById(Integer id);
	
	public Priority findByEnName(String name);
}
