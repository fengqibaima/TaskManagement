package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.StateDAO;
import com.ascent.domain.State;
import com.ascent.service.StateService;

public class StateServiceImpl implements StateService {

	private StateDAO stateDAO;

	public StateDAO getStateDAO() {
		return stateDAO;
	}

	public void setStateDAO(StateDAO stateDAO) {
		this.stateDAO = stateDAO;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return stateDAO.findAll();
	}
	
	public State findById(Integer id){
		return this.stateDAO.findById(id);
	}
	
	public State findByEnName(String name){
		return this.stateDAO.findByEnName(name);
	}
}
