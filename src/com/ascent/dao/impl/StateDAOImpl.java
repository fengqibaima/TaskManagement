package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.StateDAO;
import com.ascent.domain.State;

public class StateDAOImpl extends HibernateDaoSupport implements StateDAO {

	
	public List findAll() {
		// TODO Auto-generated method stub
		String hql = "from State s";
		List list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public State findById(Integer id){
		String hql = "from State s where s.id=?";
		State state = (State)this.getHibernateTemplate().find(hql,id).get(0);
		return state;
	}
	
	public State findByEnName(String name){
		String hql = "from State s where s.enname=?";
		State state = (State)this.getHibernateTemplate().find(hql,name).get(0);
		return state;
	}
}
