package com.ascent.dao;

import java.util.ArrayList;
import java.util.List;

import com.ascent.domain.Department;
import com.ascent.domain.User;

public interface UserDAO {

	public User saveOne(User user);
	
	public User findByUsername(String username);
	
	public List findByDepartment(Department department);
	
	public User checkUser(String username, String password);
	
	public List findAll();
	
	public int getTotalRows();
	
	public ArrayList getData(String sql, int firstRow, int maxRow);
	
	public User findById(Integer uid);
	
	public boolean deleteUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean updateUser(int id, String col, String value);
}
