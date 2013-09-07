package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.AuthorityDAO;
import com.ascent.domain.Authority;

public class AuthorityDAOImpl extends HibernateDaoSupport implements
		AuthorityDAO {

	public List findAll() {
		// TODO Auto-generated method stub
		String hql = "from Authority";
		List list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public Authority findById(String id) {
		// TODO Auto-generated method stub
		String hql = "from Authority a where a.id=?";
		Authority authority = (Authority)this.getHibernateTemplate().find(hql,  Integer.valueOf(id)).get(0);
		return authority;
	}

	public List findByUser(com.ascent.domain.User user) {
		// TODO Auto-generated method stub
		String hql = "from Authority a where a.userAuthorities.id=?";
		List list = this.getHibernateTemplate().find(hql, Integer.valueOf(user.getId()));
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public boolean saveOne(Authority authority) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(authority);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteOne(Authority authority) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(authority);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List findByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Authority a where a.name=?";
		List list = this.getHibernateTemplate().find(hql,name);
		return list;
	}

}
