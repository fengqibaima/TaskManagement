package com.ascent.struts2.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ascent.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction{

	private String username;
	private User user;
	private List authorityList;
	private String userId;
	private String realname;
	
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List authorityList) {
		this.authorityList = authorityList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	public String login(){
		System.out.println("username: "+username+" password: "+password);
		user = userService.checkUser(username, password);
				
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("username", username);
			HttpSession session = ServletActionContext.getRequest ().getSession(); 
			session.setAttribute("user",user);
			authorityList = authorityService.findByUser(user);
			realname = user.getRealname();
			System.out.println("realname :"+realname);
			if(authorityList.size()==0){
				return "input";
			}
			ActionContext.getContext().getSession().put("authorityList", authorityList);			
			return "success";
		}else{
			return "input";
		}	
	}
}
