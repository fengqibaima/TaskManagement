package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.CategoryDAO;
import com.ascent.domain.Category;
import com.ascent.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;
	
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return categoryDAO.findById(id);
	}

	@Override
	public Category findByEnName(String name) {
		// TODO Auto-generated method stub
		return categoryDAO.findByEnName(name);
	}

}
