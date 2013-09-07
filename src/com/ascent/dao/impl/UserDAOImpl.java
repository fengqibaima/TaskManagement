package com.ascent.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.UserDAO;
import com.ascent.domain.Department;
import com.ascent.domain.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	private static final Logger LOGGER = LogManager
			.getLogger(UserDAOImpl.class);

	public User saveOne(User user) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(user);
			LOGGER.debug("success");
			return user;
		} catch (Exception e) {
			LOGGER.debug("fail");
			e.printStackTrace();
			return null;
		}
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stu
		String sql = "from User u where u.username=?";
		List list = this.getHibernateTemplate().find(sql, username);
		if (list.size() > 0) {
			LOGGER.debug("success");
			User user = (User) list.get(0);
			return user;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}

	public User checkUser(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "from User u where u.username=? and u.password=?";
		List list = this.getHibernateTemplate().find(sql,
				new String[] { username, password });
		if (list.size() > 0) {
			LOGGER.debug("success");
			User user = (User) list.get(0);
			return user;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}

	public List findAll() {
		// TODO Auto-generated method stub
		// List<User> users = new ArrayList<User>();
		String sql = "from User";
		List list = this.getHibernateTemplate().find(sql);
		// Iterator it =list.iterator();
		// if(it.hasNext()){
		// User u = new User();
		// u=(User)it.next();
		// users.add(u);
		// }
		return list;
	}

	public int getTotalRows() {
		// TODO Auto-generated method stub
		String sql = "from User u order by u.id";
		int totalRows = this.getHibernateTemplate().find(sql).size();
		return totalRows;
	}

	public ArrayList getData(String sql, int firstRow, int maxRow) {
		// TODO Auto-generated method stub

		return null;
	}

	public User findById(Integer uid) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.id=?";
		User user = (User) this.getHibernateTemplate().find(hql, uid).get(0);
		return user;
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List findByDepartment(Department department) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.department=?";
		this.getHibernateTemplate().find(hql, department);
		return this.getHibernateTemplate().find(hql, department);
	}

	@Override
	public boolean updateUser(int id, String col, String value) {
		String hql1 = "from User u where u.id=?";
		User user = (User)this.getHibernateTemplate().find(hql1, id).get(0);
		System.out.println("user.getUsername(): "+user.getUsername());
		if(col.equals("realname")) {
			user.setRealname(value);
			System.out.println("~~~~~~");
		}else{
			System.out.println("@@@@");
		}
		this.getHibernateTemplate().update(user);
		return true;
	}

}
