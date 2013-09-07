package com.ascent.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private String username;
	private String password;
	private String email;
	private String authority;
	private Date registedtime;
	private String realname;
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	private Set notePublishers = new HashSet(0);
	private Set userAuthorities = new HashSet(0);
	private Set noteExecutors = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Department department, String username, String password,
			String authority, Date registedtime) {
		this.department = department;
		this.username = username;
		this.password = password;
		this.authority = authority;
		this.registedtime = registedtime;
	}

	/** full constructor */
	public User(Department department, String username, String password,
			String email, String authority, Date registedtime,
			Set notePublishers, Set userAuthorities, Set noteExecutors) {
		this.department = department;
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
		this.registedtime = registedtime;
		this.notePublishers = notePublishers;
		this.userAuthorities = userAuthorities;
		this.noteExecutors = noteExecutors;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Date getRegistedtime() {
		return this.registedtime;
	}

	public void setRegistedtime(Date registedtime) {
		this.registedtime = registedtime;
	}

	public Set getNotePublishers() {
		return this.notePublishers;
	}

	public void setNotePublishers(Set notePublishers) {
		this.notePublishers = notePublishers;
	}

	public Set getUserAuthorities() {
		return this.userAuthorities;
	}

	public void setUserAuthorities(Set userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

	public Set getNoteExecutors() {
		return this.noteExecutors;
	}

	public void setNoteExecutors(Set noteExecutors) {
		this.noteExecutors = noteExecutors;
	}

}