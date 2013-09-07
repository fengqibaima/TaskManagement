package com.ascent.domain;

import java.util.Date;


/**
 * Plan entity. @author MyEclipse Persistence Tools
 */

public class Plan  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Note note;
     private String content;
     private Date date;
     private String comment;
     private Integer expectedtime;
     private Integer usedtime;
     private Integer percentage;

    // Constructors

    public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	/** default constructor */
    public Plan() {
    }

	/** minimal constructor */
    public Plan(Note note, Date date) {
        this.note = note;
        this.date = date;
    }
    
    /** full constructor */
    public Plan(Note note, String content, Date date, String comment, Integer expectedtime, Integer usedtime) {
        this.note = note;
        this.content = content;
        this.date = date;
        this.comment = comment;
        this.expectedtime = expectedtime;
        this.usedtime = usedtime;
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

    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getExpectedtime() {
        return this.expectedtime;
    }
    
    public void setExpectedtime(Integer expectedtime) {
        this.expectedtime = expectedtime;
    }

    public Integer getUsedtime() {
        return this.usedtime;
    }
    
    public void setUsedtime(Integer usedtime) {
        this.usedtime = usedtime;
    }
   








}