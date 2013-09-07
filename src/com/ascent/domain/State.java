package com.ascent.domain;

/**
 * State entity. @author MyEclipse Persistence Tools
 */

public class State implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String enname;

	// Constructors


	/** default constructor */
	public State() {
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	/** minimal constructor */
	public State(String name) {
		this.name = name;
	}

	/** full constructor */
	public State(String name, String description,String enname) {
		this.name = name;
		this.description = description;
		this.enname = enname;
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

}