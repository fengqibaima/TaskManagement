package com.ascent.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Note entity. @author MyEclipse Persistence Tools
 */

public class Note  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String title;
     private String content;
     private Date starttime;
     private Date endtime;
     private Date date;
     private State state;
     private Category category;
     private Priority priority;
     private Set plans = new HashSet(0);
     private Set notePublishers = new HashSet(0);
     private Set noteExecutors = new HashSet(0);
     private Set comments = new HashSet(0);


    // Constructors

    /** default constructor */
    public Note() {
    }

	/** minimal constructor */
    public Note(String title, String content, Date starttime, Date endtime, Date date, State state, Category category, Priority priority) {
        this.title = title;
        this.content = content;
        this.starttime = starttime;
        this.endtime = endtime;
        this.date = date;
        this.state = state;
        this.category = category;
        this.priority = priority;
    }
    
    /** full constructor */
    public Note(String title, String content, Date starttime, Date endtime, Date date, State state, Category category, Priority priority, Set plans, Set notePublishers, Set noteExecutors, Set comments) {
        this.title = title;
        this.content = content;
        this.starttime = starttime;
        this.endtime = endtime;
        this.date = date;
        this.state = state;
        this.category = category;
        this.priority = priority;
        this.plans = plans;
        this.notePublishers = notePublishers;
        this.noteExecutors = noteExecutors;
        this.comments = comments;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Date getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public State getState() {
        return this.state;
    }
    
    public void setState(State state) {
        this.state = state;
    }

    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public Priority getPriority() {
        return this.priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Set getPlans() {
        return this.plans;
    }
    
    public void setPlans(Set plans) {
        this.plans = plans;
    }

    public Set getNotePublishers() {
        return this.notePublishers;
    }
    
    public void setNotePublishers(Set notePublishers) {
        this.notePublishers = notePublishers;
    }

    public Set getNoteExecutors() {
        return this.noteExecutors;
    }
    
    public void setNoteExecutors(Set noteExecutors) {
        this.noteExecutors = noteExecutors;
    }

    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }
   








}