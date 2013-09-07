package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.DepartmentDAO;
import com.ascent.domain.Department;
import com.ascent.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDAO departmentDAO;
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public List findALL() {
		// TODO Auto-generated method stub
		return this.departmentDAO.findAll();
	}

	public Department findById(String id) {
		// TODO Auto-generated method stub
		return this.departmentDAO.findById(id);
	}

}
