package com.ascent.service;

import java.util.List;

import com.ascent.domain.Priority;

public interface PriorityService {
	public List findAll();
	
	public Priority findById(Integer id);
	
	public Priority findByEnName(String name);
}
