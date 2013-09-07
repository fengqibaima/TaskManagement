package com.ascent.domain;

import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Note note;
	private String content;
	private Date date;
	private String username;
	private String usertitle;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Note note, String content, Date date, String username) {
		this.note = note;
		this.content = content;
		this.date = date;
		this.username = username;
	}

	/** full constructor */
	public Comment(Note note, String content, Date date, String username,
			String usertitle) {
		this.note = note;
		this.content = content;
		this.date = date;
		this.username = username;
		this.usertitle = usertitle;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertitle() {
		return this.usertitle;
	}

	public void setUsertitle(String usertitle) {
		this.usertitle = usertitle;
	}

}