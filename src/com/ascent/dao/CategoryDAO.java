package com.ascent.dao;

import java.util.List;

import com.ascent.domain.Category;

public interface CategoryDAO {

	public List findAll();
	
	public Category findById(Integer id);
	
	public Category findByEnName(String name);
	
}
