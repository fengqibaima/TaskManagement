package com.ascent.struts2.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ascent.domain.Note;
import com.ascent.service.AuthorityService;
import com.ascent.service.CategoryService;
import com.ascent.service.CommentService;
import com.ascent.service.DepartmentService;
import com.ascent.service.NoteService;
import com.ascent.service.PlanService;
import com.ascent.service.PriorityService;
import com.ascent.service.StateService;
import com.ascent.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	protected UserService userService;
	protected NoteService noteService;
	protected CommentService commentService;
	protected AuthorityService	authorityService;
	protected DepartmentService departmentService;
	protected StateService stateService;
	protected PlanService planService;
	protected PriorityService priorityService;
	protected CategoryService categorySerivce;

	public PriorityService getPriorityService() {
		return priorityService;
	}

	public void setPriorityService(PriorityService priorityService) {
		this.priorityService = priorityService;
	}

	public CategoryService getCategorySerivce() {
		return categorySerivce;
	}

	public void setCategorySerivce(CategoryService categorySerivce) {
		this.categorySerivce = categorySerivce;
	}

	public PlanService getPlanService() {
		return planService;
	}

	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}

	public StateService getStateService() {
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List NoteListdeleteTime(List<Note> noteList){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<noteList.size();i++){
			try {
				noteList.get(i).setStarttime(sdf.parse(String.valueOf(noteList.get(i).getStarttime())));
				noteList.get(i).setEndtime(sdf.parse(String.valueOf(noteList.get(i).getEndtime())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return noteList;
	}

	public Date deleteTimeFromDate1(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTemp =null;
		try {
			dateTemp = sdf.parse(String.valueOf(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String temp =null;
//			try {
//				temp = sdf.parse(date.toString()).toString();
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		String temp = date.toString();
//		String[] b = temp.split(" ");
//		String a = b[0];
		return dateTemp;
	}
	
	public String deleteTimeFromDate2(Date date){
		String temp = date.toString();
		String[] b = temp.split(" ");
		String a = b[0];
		return a;
	}
	
	public void saveObjectInSession(String key, Object value){
		ActionContext.getContext().getSession().put(key, value);
		
	}
	
	public Object getObjectInSession(String key){
		return ActionContext.getContext().getSession().get(key);
	}
	
	public static Date add(Date date, int calendarField, int amount)  
    {  
        if(date == null)  
        {  
            throw new IllegalArgumentException("The date must not be null");  
        } else  
        {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(calendarField, amount);  
            return c.getTime();  
        }  
    }  
	
	  public Date addDays(Date date, int amount)  
	    {  
	        return add(date, 5, amount);  
	    }  
	  
}
