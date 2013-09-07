package com.ascent.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String url;
	private Set userAuthorities = new HashSet(0);
	private String description;

	// Constructors

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/** default constructor */
	public Authority() {
	}

	/** minimal constructor */
	public Authority(String name, String url) {
		this.name = name;
		this.url = url;
	}

	/** full constructor */
	public Authority(String name, String url, Set userAuthorities) {
		this.name = name;
		this.url = url;
		this.userAuthorities = userAuthorities;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getUserAuthorities() {
		return this.userAuthorities;
	}

	public void setUserAuthorities(Set userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

}