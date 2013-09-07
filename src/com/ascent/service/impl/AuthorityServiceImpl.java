package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.AuthorityDAO;
import com.ascent.domain.Authority;
import com.ascent.domain.User;
import com.ascent.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService {

	private AuthorityDAO authorityDAO;
	
	public AuthorityDAO getAuthorityDAO() {
		return authorityDAO;
	}

	public void setAuthorityDAO(AuthorityDAO authorityDAO) {
		this.authorityDAO = authorityDAO;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.authorityDAO.findAll();
	}

	public Authority findById(String id) {
		// TODO Auto-generated method stub
		return this.authorityDAO.findById(id);
	}

	public List findByUser(User user) {
		// TODO Auto-generated method stub
		return this.authorityDAO.findByUser(user);
	}

	public boolean saveOne(Authority authority) {
		// TODO Auto-generated method stub
		return this.getAuthorityDAO().saveOne(authority);
	}

	public boolean deleteOne(Authority authority) {
		// TODO Auto-generated method stub
		return this.getAuthorityDAO().deleteOne(authority);
	}

	public List findByName(String name) {
		// TODO Auto-generated method stub
		return this.getAuthorityDAO().findByName(name);
	}

}
