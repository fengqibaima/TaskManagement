package com.ascent.service;

import java.util.List;

import com.ascent.dao.StateDAO;
import com.ascent.domain.State;

public interface StateService {

	public List findAll();
	
	public State findById(Integer id);
	
	public State findByEnName(String name);
}
