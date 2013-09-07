package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.PriorityDAO;
import com.ascent.domain.Priority;
import com.ascent.service.PriorityService;

public class PriorityServiceImpl implements PriorityService {

	private PriorityDAO priorityDAO;
	
	public PriorityDAO getPriorityDAO() {
		return priorityDAO;
	}

	public void setPriorityDAO(PriorityDAO priorityDAO) {
		this.priorityDAO = priorityDAO;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return priorityDAO.findAll();
	}

	@Override
	public Priority findById(Integer id) {
		// TODO Auto-generated method stub
		return priorityDAO.findById(id);
	}

	@Override
	public Priority findByEnName(String name) {
		// TODO Auto-generated method stub
		return priorityDAO.findByEnName(name);
	}

}
