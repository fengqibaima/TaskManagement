package com.ascent.struts2.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ascent.domain.Comment;
import com.ascent.domain.Note;
import com.ascent.domain.Plan;
import com.ascent.domain.State;
import com.ascent.domain.User;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings({"rawtypes","unchecked", "serial"})
public class PlanAction extends BaseAction {
	
	private List<String> processDayListStr;
	private Note note;
	private List planContent;
	private List planTime;
	private List dateList;
	private String commentContent;
	private List noteList;
	private String noteId;
	private String recordTime;
	private String startTime;
	private String endTime;
	private List content;
	private List expectedtime;
	private List percentage;
	private String stateid;
	private List<State> stateList;
	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public List getPercentage() {
		return percentage;
	}

	public void setPercentage(List percentage) {
		this.percentage = percentage;
	}

	public String getStateid() {
		return stateid;
	}

	public void setStateid(String stateid) {
		this.stateid = stateid;
	}

	public List getExpectedtime() {
		return expectedtime;
	}

	public void setExpectedtime(List expectedtime) {
		this.expectedtime = expectedtime;
	}

	public List getContent() {
		return content;
	}

	public void setContent(List content) {
		this.content = content;
	}

	private List<User> publishersList;
		public List getComment() {
		return comment;
	}

	public void setComment(List comment) {
		this.comment = comment;
	}

	public List getUsedtime() {
		return usedtime;
	}

	public void setUsedtime(List usedtime) {
		this.usedtime = usedtime;
	}

	private List<User> executorsList;
	private List<Comment> commentsList;
	private List planList;
	private List comment;
	private List usedtime;
	
	public List getPlanList() {
		return planList;
	}

	public void setPlanList(List planList) {
		this.planList = planList;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
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

	public List<User> getPublishersList() {
		return publishersList;
	}

	public void setPublishersList(List<User> publishersList) {
		this.publishersList = publishersList;
	}

	public List<User> getExecutorsList() {
		return executorsList;
	}

	public void setExecutorsList(List<User> executorsList) {
		this.executorsList = executorsList;
	}

	public List<Comment> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public List getNoteList() {
		return noteList;
	}

	public void setNoteList(List noteList) {
		this.noteList = noteList;
	}

	public List getDate() {
		return dateList;
	}

	public void setDate(List dateList) {
		this.dateList = dateList;
	}

	public List getPlanContent() {
		return planContent;
	}

	public void setPlanContent(List planContent) {
		this.planContent = planContent;
	}

	public List getPlanTime() {
		return planTime;
	}

	public void setPlanTime(List planTime) {
		this.planTime = planTime;
	}
	
	public Note getNote() {
		return note;
	}

	public List<String> getProcessDayListStr() {
		return processDayListStr;
	}

	public void setProcessDayListStr(List<String> processDayListStr) {
		this.processDayListStr = processDayListStr;
	}

	public void setNote(Note note) {
		this.note = note;
	}
	
	public List getDateList() {
		return dateList;
	}

	public void setDateList(List dateList) {
		this.dateList = dateList;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String addNew(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		Plan plan = new Plan();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Note newNote = this.noteService.saveOne((Note)ActionContext.getContext().getSession().get("newNote"));
		List tempPlanDateList = (List)ActionContext.getContext().getSession().get("tempPlanDateList");
		for(int i=0;i<planContent.size();i++){
			plan.setContent((String)planContent.get(i));
			if(planTime.get(i).equals("")){
				plan.setExpectedtime(null);
			}else{
				plan.setExpectedtime(Integer.valueOf((String)planTime.get(i)));
			}
			try {
				plan.setDate(sdf.parse((String)tempPlanDateList.get(i)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plan.setNote(newNote);
			planService.saveOne(plan);
		}
		
		//set new comment
		if(!commentContent.equals("")){
			Comment comment = new Comment();
			Timestamp now = new Timestamp(System.currentTimeMillis());
			comment.setDate(now);
			comment.setContent(commentContent);
			comment.setNote(newNote);
			comment.setUsername(user.getUsername());
			commentService.saveOne(comment);
		}
		noteList = noteService.findByPublisher(user);
		
		//change note state
		String stateName = "process";
		State state = stateService.findByEnName(stateName);
		newNote.setState(state);		
		this.noteService.update(newNote);
		
		return "success_addNew_publisher";
	}
	
	public String showEditPageExecutor(){
		note = noteService.findById(noteId);
		//put tempNote for next step update plan list, put tempState for jsp page show different plan table
		ActionContext.getContext().getSession().put("tempNote", note);
		ActionContext.getContext().getSession().put("tempState", note.getState().getEnname());
		publishersList = new ArrayList<User>(note.getNotePublishers());
		executorsList = new ArrayList<User>(note.getNoteExecutors());
		commentsList = commentService.findByNote(note);		
			
		recordTime = this.deleteTimeFromDate2(note.getDate());
		startTime = this.deleteTimeFromDate2(note.getStarttime());
		endTime = this.deleteTimeFromDate2(note.getEndtime());
		
		//show plan list
		planList = this.planService.findByNote(note);
		List tempPlanList = planList;
		ActionContext.getContext().getSession().put("tempPlanList", tempPlanList);
		return "success_showEditPage_executor";
	}
	
	public String editExecutor(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		Note tempNote = (Note)ActionContext.getContext().getSession().get("tempNote");
		List tempPlanDateList = (List)ActionContext.getContext().getSession().get("tempPlanList");
		if(tempNote.getState().getEnname().equals("start")){
			for(int i=0;i<content.size();i++){
				Plan plan = (Plan)tempPlanDateList.get(i);
				plan.setContent((String)content.get(i));
				if(expectedtime.get(i).equals("")){
					plan.setExpectedtime(null);
				}else{
					plan.setExpectedtime(Integer.valueOf((String)expectedtime.get(i)));
				}
				planService.updateOne(plan);
			}
		}else if(tempNote.getState().getEnname().equals("process")){
			System.out.println("process");
			for(int i=0;i<comment.size();i++){
				Plan plan = (Plan)tempPlanDateList.get(i);
				plan.setComment((String)comment.get(i));
				if(usedtime.get(i).equals("")){
					plan.setUsedtime(null);
				}else{
					plan.setUsedtime(Integer.valueOf((String)usedtime.get(i)));
				}
				planService.updateOne(plan);
			}
		}
			
		if(!commentContent.equals("")){
			Comment comment = new Comment();
			Timestamp now = new Timestamp(System.currentTimeMillis());
			comment.setDate(now);
			comment.setContent(commentContent);
			comment.setNote(tempNote);
			comment.setUsername(user.getUsername());
			commentService.saveOne(comment);
		}
		
		if(tempNote.getState().getEnname().equals("start")){
			String stateName = "process";
			State state = stateService.findByEnName(stateName);
			tempNote.setState(state);
			this.noteService.update(tempNote);
		}
				
		noteList = noteService.findByExecutor(user);
		return "success_edit_executor";
	}
	
	public String showEditPagePublisher() {
		note = noteService.findById(noteId);
		publishersList = new ArrayList<User>(note.getNotePublishers());
		executorsList = new ArrayList<User>(note.getNoteExecutors());
		ActionContext.getContext().getSession().put("tempNote", note);
		ActionContext.getContext().getSession().put("tempState", note.getState().getEnname());
		
		String stateFlag =null;
		if(!note.getState().getEnname().equals("end")){
			stateFlag = "notEnd";			
		}else{
			stateFlag = "end";
		}
		ActionContext.getContext().getSession().put("stateFlag", stateFlag);
		
		commentsList = commentService.findByNote(note);		
			
		recordTime = this.deleteTimeFromDate2(note.getDate());
		startTime = this.deleteTimeFromDate2(note.getStarttime());
		endTime = this.deleteTimeFromDate2(note.getEndtime());
		
		//plan list
		planList = this.planService.findByNote(note);
				
		if(note.getState().getEnname().equals("end")){
			stateList = new ArrayList();
			State state = this.stateService.findByEnName("end");
			stateList.add(state);
		}else{
			stateList = this.stateService.findAll();
			for(int i=0;i<stateList.size();i++){
				State state = stateList.get(i);
				if(state.getEnname().equals("start")){
					stateList.remove(i);
				}
			}
		}
		
		stateid = note.getState().getId().toString();
		
		return "success_showEditPage_publisher";
	}
	
	public String editPublisher(){
		Note tempNote = (Note)ActionContext.getContext().getSession().get("tempNote");
		User user = (User)ActionContext.getContext().getSession().get("user");
		
		State state = this.stateService.findById(Integer.valueOf(stateid));
		tempNote.setState(state);
		this.noteService.update(tempNote);
		
		if(!commentContent.equals("")){
			Comment comment = new Comment();
			Timestamp now = new Timestamp(System.currentTimeMillis());
			comment.setDate(now);
			comment.setContent(commentContent);
			comment.setNote(tempNote);
			comment.setUsername(user.getUsername());
			commentService.saveOne(comment);
		}
		
		String stateFlag = (String)ActionContext.getContext().getSession().get("stateFlag");
		if(!stateFlag.equals("end")){
			List tempPlanDateList = (List)planService.findByNote(tempNote);		
			for(int i=0;i<percentage.size();i++){
				Plan plan = (Plan)tempPlanDateList.get(i);
				if(!((String)percentage.get(i)).equals("")){
					plan.setPercentage(Integer.valueOf((String)percentage.get(i)));
				}else{
					plan.setPercentage(null);
				}
				planService.updateOne(plan);
			}
		}
		
		//authorityList = authorityService.findByUser(user);
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
			return "success_edit_publisher";
		}else{
			noteList =null;
			return "success_edit_publisher";
		}
	}
}
