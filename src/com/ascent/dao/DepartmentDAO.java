package com.ascent.dao;

import java.util.List;

import com.ascent.domain.Department;

public interface DepartmentDAO {

	public List findAll();
	
	public Department findById(String id);
}
