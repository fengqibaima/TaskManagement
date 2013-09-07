package com.ascent.struts2.action;

import java.util.List;

import com.ascent.domain.Authority;

public class AuthorityAction extends BaseAction {

	private List authorityList;
	private String authorityId;
	private Authority authority;
	private String name;
	private String url;
	private String description;

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public void setAuthorityList(List authorityList) {
		this.authorityList = authorityList;
	}
	
	public List getAuthorityList() {
		return authorityList;
	}
	
	public String showAll(){
		authorityList = authorityService.findAll();
		return "success_showAll";
	}
	
	public String showAddNewPage(){
		return "success_showAddNewPage";
	}

	public String showDetail(){
		System.out.println("authority id "+authorityId);
		authority = authorityService.findById(authorityId);
		System.out.println("authority name "+ authority.getName());
		return "success_showDetail";
	}
	
	public String addNew(){
		Authority authority = new Authority();
		authority.setDescription(description);
		authority.setName(name);
		authority.setUrl(url);
		authorityService.saveOne(authority);
		authorityList = authorityService.findAll();
		return "success_saveOne";
	}
	
	public String deleteOne(){
		authority = authorityService.findById(authorityId);
		authorityService.deleteOne(authority);
		authorityList = authorityService.findAll();
		return "success_deleteOne";
	}
}