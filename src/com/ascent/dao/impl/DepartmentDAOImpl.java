package com.ascent.dao.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.DepartmentDAO;
import com.ascent.domain.Department;

public class DepartmentDAOImpl extends HibernateDaoSupport implements DepartmentDAO{

	private static final Logger LOGGER = LogManager
	.getLogger(NoteDAOImpl.class);
	
	public List findAll() {
		// TODO Auto-generated method stub
		String hql = "from Department";
		List list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			LOGGER.debug("success");
			return list;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}

	public Department findById(String id) {
		// TODO Auto-generated method stub
		String hql = "from Department d where d.id=?";
		Department department =(Department) this.getHibernateTemplate().find(hql, Integer.valueOf(id)).get(0);
		return department;
	}

}
