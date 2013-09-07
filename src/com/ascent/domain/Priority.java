package com.ascent.domain;

/**
 * Priority entity. @author MyEclipse Persistence Tools
 */

public class Priority implements java.io.Serializable {

	// Fields

	private Integer id;
	private String enname;
	private String chname;
	private String description;

	// Constructors

	/** default constructor */
	public Priority() {
	}

	/** minimal constructor */
	public Priority(String enname, String chname) {
		this.enname = enname;
		this.chname = chname;
	}

	/** full constructor */
	public Priority(String enname, String chname, String description) {
		this.enname = enname;
		this.chname = chname;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnname() {
		return this.enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getChname() {
		return this.chname;
	}

	public void setChname(String chname) {
		this.chname = chname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}