package com.ascent.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Date foundedtime;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String name, Date foundedtime) {
		this.name = name;
		this.foundedtime = foundedtime;
	}

	/** full constructor */
	public Department(String name, String description, Date foundedtime,
			Set users) {
		this.name = name;
		this.description = description;
		this.foundedtime = foundedtime;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFoundedtime() {
		return this.foundedtime;
	}

	public void setFoundedtime(Date foundedtime) {
		this.foundedtime = foundedtime;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}