package com.ascent.struts2.action;

import java.util.List;

public class SearchAction extends BaseAction {
	
	private List priorityList;
	private List categoryList;
	private List stateList;
	
	public List getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(List priorityList) {
		this.priorityList = priorityList;
	}

	public List getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}

	public List getStateList() {
		return stateList;
	}

	public void setStateList(List stateList) {
		this.stateList = stateList;
	}

	public String showModuleExecutor(){
		priorityList = this.priorityService.findAll();
		categoryList = this.categorySerivce.findAll();
		stateList = this.stateService.findAll();
		return "success_showModuleExecutor";
	}
	
	public String showModulePublisher(){
		priorityList = this.priorityService.findAll();
		categoryList = this.categorySerivce.findAll();
		stateList = this.stateService.findAll();
		return "success_showModulePublisher";
	}
}
