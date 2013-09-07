package com.ascent.ajax;


import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.toplink.SessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ascent.domain.User;
import com.ascent.service.UserService;

/**
 * @author yulian
 * 
 */

public class UpdateAjax extends HibernateDaoSupport {

	protected UserService userService; 
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void updateSql(String table, String updateCol, String updateData, String ID){ 		
	    System.out.println("table "+table);
	    System.out.println("ID "+ID);
	    System.out.println("updateCol "+updateCol);
	    System.out.println("updateData "+updateData);
		
	    if(userService == null){
	    	System.out.println("userService == null");
	    }
	    userService.updateUser(Integer.parseInt(ID), updateCol, updateData);
	    System.out.println("finish");

	    //JdbcTemplate  jdbcTemplate = JdbcTemplate.;
	    
//	    SpringContextUtils sUtil = new SpringContextUtils();
//	    WebApplicationContext webApplication = ContextLoader.;
//	    ApplicationContext applicationContext = new  FileSystemXmlApplicationContext("");
//	    sUtil.setApplicationContext(applicationContext);
	}
}
