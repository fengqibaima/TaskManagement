package com.ascent.domain;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private String enname;
	private String chname;
	private String decription;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String enname, String chname) {
		this.enname = enname;
		this.chname = chname;
	}

	/** full constructor */
	public Category(String enname, String chname, String decription) {
		this.enname = enname;
		this.chname = chname;
		this.decription = decription;
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

	public String getDecription() {
		return this.decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

}