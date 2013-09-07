package com.ascent.service;

import java.util.List;

import com.ascent.domain.Category;

public interface CategoryService {

	public List findAll();
	
	public Category findById(Integer id);
	
	public Category findByEnName(String name);
	
}
