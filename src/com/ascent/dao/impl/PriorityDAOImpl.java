package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.PriorityDAO;
import com.ascent.domain.Priority;
import com.ascent.domain.State;

public class PriorityDAOImpl extends HibernateDaoSupport implements PriorityDAO {

	public List findAll() {
		// TODO Auto-generated method stub
		String hql = "from Priority p";
		List list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public Priority findById(Integer id){
		String hql = "from Priority p where p.id=?";
		Priority priority = (Priority)this.getHibernateTemplate().find(hql,id).get(0);
		return priority;
	}
	
	public Priority findByEnName(String name){
		String hql = "from Priority p where p.enname=?";
		Priority priority = (Priority)this.getHibernateTemplate().find(hql,name).get(0);
		return priority;
	}

}
