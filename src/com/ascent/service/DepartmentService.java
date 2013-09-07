package com.ascent.service;

import java.util.List;

import com.ascent.domain.Department;

public interface DepartmentService {

	public List findALL();
	
	public Department findById(String id);
}
