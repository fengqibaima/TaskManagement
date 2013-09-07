package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.PlanDAO;
import com.ascent.domain.Note;
import com.ascent.domain.Plan;

public class PlanDAOImpl extends HibernateDaoSupport implements PlanDAO {

	public boolean saveOne(Plan plan) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(plan);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List findByNote(Note note) {
		String hql = "from Plan p where p.note=?";
		List list = this.getHibernateTemplate().find(hql, note);
		System.out.println("list size " + list.size());
		return list;
	}

	public boolean updateOne(Plan plan) {
		try {
			this.getHibernateTemplate().update(plan);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
