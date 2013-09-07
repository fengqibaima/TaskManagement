package com.ascent.struts2.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ascent.domain.Category;
import com.ascent.domain.Comment;
import com.ascent.domain.Note;
import com.ascent.domain.Plan;
import com.ascent.domain.Priority;
import com.ascent.domain.State;
import com.ascent.domain.User;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("unchecked")
public class NoteAction extends BaseAction {

	private String date;
	private List<Note> noteList;
	private String noteId;
	private String recordTime;
	private String startTime;
	private String endTime;
	private String stateid;
	private String priorityid;
	private String categoryid;
	private String executorId;
	private String publisher;
	private List categoryList;
	private List priorityList;
	private Note note;
	private List<User> publishersList;
	private List<User> executorsList;
	private String nextStep;
	private List<State> stateList;
	private List planList;
	private List percentage;
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

	public List getPercentage() {
		return percentage;
	}

	public void setPercentage(List percentage) {
		this.percentage = percentage;
	}

	public List getPlanList() {
		return planList;
	}

	public void setPlanList(List planList) {
		this.planList = planList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}
	
	public List getStateList() {
		return stateList;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public List getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List authorityList) {
		this.authorityList = authorityList;
	}

	private List<Comment> commentsList;
	private List authorityList;

	public List<User> getPublishersList() {
		return publishersList;
	}

	public void setPublisherList(List<User> publishersList) {
		this.publishersList = publishersList;
	}

	public List<User> getExecutorsList() {
		return executorsList;
	}

	public void setExecutorList(List<User> executorsList) {
		this.executorsList = executorsList;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getStateid() {
		return stateid;
	}

	public void setStateid(String stateid) {
		this.stateid = stateid;
	}

	public String getPriorityid() {
		return priorityid;
	}

	public void setPriorityid(String priorityid) {
		this.priorityid = priorityid;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	private String title;
	private String content;

	private User user;
	private List<User> userList;

	public User getUser() {
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExecutorId() {
		return executorId;
	}

	public void setExecutorId(String executorId) {
		this.executorId = executorId;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String showByDay() {
		user = (User) ActionContext.getContext().getSession().get("user");
		noteList = noteService.findByDay(date, user);
		return "success";
	}

	public List<Comment> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public void setPublishersList(List<User> publishersList) {
		this.publishersList = publishersList;
	}

	public void setExecutorsList(List<User> executorsList) {
		this.executorsList = executorsList;
	}

	public String addNew() {
		Note note = new Note();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		User user = (User) ActionContext.getContext().getSession().get("user");
		note.setDate(ts);
		note.setTitle(title);
		note.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStartTime = null;
		Date dateEndTime = null;
		try {
			dateStartTime = sdf.parse(startTime);
			dateEndTime = sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		note.setStarttime(dateStartTime);
		note.setEndtime(dateEndTime);
		State state = stateService.findById(Integer.valueOf(stateid));
		note.setState(state);
		Priority priority = this.priorityService.findById(Integer.valueOf(priorityid));
		note.setPriority(priority);
		Category category = this.categorySerivce.findById(Integer.valueOf(categoryid));
		note.setCategory(category);
		User executorUser = new User();
		executorUser = userService.findById(Integer.valueOf(executorId));
		Set executors = new HashSet();
		executors.add(executorUser);
		User publisher = new User();
		publisher = userService.findById(user.getId());
		Set publishers = new HashSet();
		publishers.add(publisher);
		note.setNoteExecutors(executors);
		note.setNotePublishers(publishers);
	
		//save newNote in session update later
		//Note newNote = noteService.saveOne(note);
		authorityList = authorityService.findByUser(user);
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		if(nextStep.equals("planedByExecutor")){
			noteService.saveOne(note);
			
			//create checkListForPlan
			Date startDate = note.getStarttime();		
			Date endDate = note.getEndtime();		
			long processDays = endDate.getTime()-startDate.getTime();
			processDays = processDays/1000/60/60/24;
			for(int i =0; i<=processDays;i++){
				Plan plan = new Plan();
				Date temp = this.addDays(startDate, i);
				plan.setDate(temp);
				plan.setNote(note);
				planService.saveOne(plan);
			}			
			noteList = noteService.findByPublisher(user);			
			return "success_saveOne";
			
		}else if(nextStep.equals("planedByPubliser")){
			ActionContext.getContext().getSession().put("newNote", note);
			return "success_showPlanPublisherPage";
		}
		return "fail";
	}

	public String deleteOne() {
		Note note = noteService.findById(noteId);
		noteService.deleteOne(note);
		User user = (User)ActionContext.getContext().getSession().get("user");
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		return "success_deleteOne";
	}

	public String showAddNewPage() {
		user = (User) ActionContext.getContext().getSession().get("user");
		userList = (ArrayList<User>) this.userService.findByDepartment(user
				.getDepartment());
		//just show start option
		State state = this.stateService.findByEnName("start");
		stateList = new ArrayList();
		stateList.add(state);
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(user.getId())) {
				userList.remove(i);
				break;
			}
		}
		
		priorityList = this.priorityService.findAll();
		categoryList = this.categorySerivce.findAll();
		
		ActionContext.getContext().getSession().put("userList", userList);
		return "success_showAddNewPage";
	}

	public String showAllPublished() {
		String flagExeOrPub = "publisher";
		ActionContext.getContext().getSession().put("flagExeOrPub", flagExeOrPub);
		user = (User) ActionContext.getContext().getSession().get("user");
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		ActionContext.getContext().getSession().put("noteList", noteList);
		return "success_showAllPublished";
	}

	public String showAllExecuted() {		
		
		String flagExeOrPub = "executor";
		ActionContext.getContext().getSession().put("flagExeOrPub", flagExeOrPub);
		user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println("user " + user.getUsername());
		noteList = noteService.findByExecutor(user);
		
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		
		ActionContext.getContext().getSession().put("noteList", noteList);

		return "success_showAllExecuted";
	}
	
	public String showselectedExecuted() {
		String flagExeOrPub = "executor";
		ActionContext.getContext().getSession().put("flagExeOrPub", flagExeOrPub);
		user = (User) ActionContext.getContext().getSession().get("user");
		noteList = noteService.findByExecutor(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		ActionContext.getContext().getSession().put("noteList", noteList);
		return "success_showselectedExecuted";
	}
	
	public String showselectedPublished() {
		System.out.println("stateid "+stateid);
		String flagExeOrPub = "publisher";
		ActionContext.getContext().getSession().put("flagExeOrPub", flagExeOrPub);
		user = (User) ActionContext.getContext().getSession().get("user");
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
		}
		ActionContext.getContext().getSession().put("noteList", noteList);
		return "success_showselectedPublished";
	}
	
}
