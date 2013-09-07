package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.CategoryDAO;
import com.ascent.domain.Category;
import com.ascent.domain.Priority;

public class CategoryDAOImpl extends HibernateDaoSupport implements CategoryDAO {

	public List findAll() {
		// TODO Auto-generated method stub
		String hql = "from Category c";
		List list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public Category findById(Integer id){
		String hql = "from Category c where c.id=?";
		Category category = (Category)this.getHibernateTemplate().find(hql,id).get(0);
		return category;
	}
	
	public Category findByEnName(String name){
		String hql = "from Category c where c.enname=?";
		Category category = (Category)this.getHibernateTemplate().find(hql,name).get(0);
		return category;
	}

}
