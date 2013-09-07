package com.ascent.struts2.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ascent.domain.Authority;
import com.ascent.domain.Department;
import com.ascent.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private User user;
	private List authorityList;
	private List noteList;
	
	public List getNoteList() {
		return noteList;
	}

	public void setNoteList(List noteList) {
		this.noteList = noteList;
	}

	public List<Integer> getOwnAuthorityList() {
		return ownAuthorityList;
	}

	public void setOwnAuthorityList(List<Integer> ownAuthorityList) {
		this.ownAuthorityList = ownAuthorityList;
	}

	private List userList;
	private String userId;
	private List selectedAuthoritys;
	private List departmentList;
	private String email;
	private String departmentId;
	private String registedTime;
	private String departmentName;
	private String authority;
	private String realname;
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	private List<Integer> ownAuthorityList;
	private Department selectedDepartment;
	private User tempUser;
	
	public Department getSelectedDepartment() {
		return selectedDepartment;
	}

	public User getTempUser() {
		return tempUser;
	}

	public void setTempUser(User tempUser) {
		this.tempUser = tempUser;
	}

	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRegistedTime() {
		return registedTime;
	}

	public void setRegistedTime(String registedTime) {
		this.registedTime = registedTime;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return email;
	}

	public List getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List authorityList) {
		this.authorityList = authorityList;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List departmentList) {
		this.departmentList = departmentList;
	}

	public List getSelectedAuthoritys() {
		return selectedAuthoritys;
	}

	public void setSelectedAuthoritys(List selectedAuthoritys) {
		this.selectedAuthoritys = selectedAuthoritys;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		userList = userList;
	}

//	public String login(){
//		System.out.println("username: "+username+" password: "+password);
//		user = userService.checkUser(username, password);
//		
//		if(user!=null){
//			ActionContext.getContext().getSession().put("user", user);
//			ActionContext.getContext().getSession().put("username", user.getUsername());
//			HttpSession session = ServletActionContext.getRequest ().getSession(); 
//			session.setAttribute("user",user);
//			authorityList = authorityService.findByUser(user);
//			ActionContext.getContext().getSession().put("authorityList", authorityList);			
//			return "success";
//		}else{
//			return "input";
//		}		
//	}
	
	public String login(){
		System.out.println("username: "+username+" password: "+password);
		user = userService.checkUser(username, password);
				
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("username", username);
			HttpSession session = ServletActionContext.getRequest ().getSession(); 
			session.setAttribute("user",user);
			authorityList = authorityService.findByUser(user);
			realname = user.getRealname();
			if(authorityList == null){
				return "input";
			}
			ActionContext.getContext().getSession().put("authorityList", authorityList);			
			return "success";
		}else{
			return "input";
		}	
	}
	
	public String showAll(){
		userList = userService.findAll();
		return "success_showAll";
	}
	
	public String deleteOne(){
		User user = userService.findById(Integer.valueOf(userId));
		userService.deleteUser(user);
		userList = userService.findAll();
		return "success_deleteOne";
	}
	
	public String editOne(){
		String userIdTemp = (String)ActionContext.getContext().getSession().get("userIdTemp");
		user = userService.findById(Integer.valueOf(userIdTemp));
		user.setUsername(username);
		user.setEmail(email);
		user.setRealname(realname);
		//user.setPassword(password);
		user.setAuthority("1");
		user.setDepartment(departmentService.findById(departmentId));
		Set set = new HashSet();
		if(selectedAuthoritys!=null){
			for(int i =0; i<selectedAuthoritys.size();i++){
				set.add(authorityService.findById((String)selectedAuthoritys.get(i)));
			}
		}
		user.setUserAuthorities(set);
		userService.updateUser(user);
		userList = userService.findAll();
		return "success_editOne";
	}
	
	public String showEditOnePage(){
		authorityList = authorityService.findAll();
		departmentList = departmentService.findALL();	
		tempUser = userService.findById(Integer.valueOf(userId));
		ActionContext.getContext().getSession().put("tempUser", tempUser);
		selectedDepartment = tempUser.getDepartment();
//		List<Authority> temp = new ArrayList(user.getUserAuthorities());
//		System.out.println(temp.get(0).getName());
//		for(int i=0;i<temp.size();i++){
//			Integer aId = ((List<Authority>)authorityService.findByName(temp.get(i).getName())).get(0).getId();
//			ownAuthorityList.add(aId);
//		}
		String userIdTemp = userId;
		ActionContext.getContext().getSession().put("userIdTemp", userIdTemp);
		return "success_showEditOnePage";
	}
	
	public String showAddNewPage(){
		authorityList = authorityService.findAll();
		departmentList = departmentService.findALL();		
		return "success_showAddNewPage";
	}
	
	public String addNew(){		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword("666666");//Original password
		user.setAuthority("1");
		user.setRealname(realname);
		Date now = new Date();
		user.setRegistedtime(now);
		user.setDepartment(departmentService.findById(departmentId));
		Set set = new HashSet();
		for(int i =0; i<selectedAuthoritys.size();i++){
			set.add(authorityService.findById((String)selectedAuthoritys.get(i)));
		}
		user.setUserAuthorities(set);
		userService.saveOne(user);
		userList = userService.findAll();
		return "success_saveOne";
	}
	
	public String showDetail(){
		//if I directly use user, will replace the login user?
		User user = userService.findById(Integer.valueOf(userId));
		username = user.getUsername();
		password = user.getPassword();
		email = user.getEmail();
		registedTime = user.getRegistedtime().toString();
		departmentName = user.getDepartment().getName();	
		authority = user.getAuthority();
		authorityList = new ArrayList<Authority>(user.getUserAuthorities());
		return "success_showDetail";
	}
	
	public String logOut(){
		Map session = ActionContext.getContext().getSession();
		session.remove("username");
		return "success_logOut";
	}
	
	public String showEditMyselfPage(){
		user = (User) ActionContext.getContext().getSession().get("user");
//		List<Authority> temp = new ArrayList(user.getUserAuthorities());
//		System.out.println(temp.get(0).getName());
//		for(int i=0;i<temp.size();i++){
//			Integer aId = ((List<Authority>)authorityService.findByName(temp.get(i).getName())).get(0).getId();
//			ownAuthorityList.add(aId);
//		}
		Integer userId = user.getId();
		ActionContext.getContext().getSession().put("userId", userId);
		//the information can not change by users themselves
		username = user.getUsername();
		realname = user.getRealname();
		registedTime = user.getRegistedtime().toString();
		departmentName = user.getDepartment().getName();	
		authority = user.getAuthority();
		authorityList = new ArrayList<Authority>(user.getUserAuthorities());
		return "success_showEditMyselfPage";
	}
	
	public String editMyself(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		user.setEmail(email);
		user.setPassword(password);
		userService.updateUser(user);
		userList = userService.findAll();
		//should consider point to page
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		return "success_editMyself";
	}
}
