package com.ascent.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ascent.dao.UserDAO;
import com.ascent.domain.Department;
import com.ascent.domain.User;
import com.ascent.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User saveOne(User user) {
		// TODO Auto-generated method stub
		return userDAO.saveOne(user);
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.findByUsername(username);
	}

	public User checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(username, password);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	public int getTotalRows() {
		// TODO Auto-generated method stub
		return userDAO.getTotalRows();
	}

	public ArrayList getData(String sql, int firstRow, int maxRow) {
		// TODO Auto-generated method stub
		return userDAO.getData(sql, firstRow, maxRow);
	}

	public User findById(Integer uid) {
		// TODO Auto-generated method stub
		return userDAO.findById(uid);
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(user);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(user);
	}

	public List findByDepartment(Department department) {
		// TODO Auto-generated method stub
		return userDAO.findByDepartment(department);
	}

	@Override
	public boolean updateUser(int id, String col, String value) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(id, col, value);
	}

}
