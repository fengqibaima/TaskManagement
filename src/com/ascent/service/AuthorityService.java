package com.ascent.service;

import java.util.List;

import com.ascent.domain.Authority;
import com.ascent.domain.User;

public interface AuthorityService {

	public List findAll();
	
	public Authority findById(String id);
	
	public List findByUser(User user);
	
	public boolean saveOne(Authority authority);
	
	public boolean deleteOne(Authority authority);
	
	public List findByName(String name);
	
}
