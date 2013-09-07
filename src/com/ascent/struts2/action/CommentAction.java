package com.ascent.struts2.action;

import java.sql.Timestamp;
import java.util.List;

import com.ascent.domain.Comment;
import com.ascent.domain.Note;
import com.ascent.domain.Plan;
import com.ascent.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class CommentAction extends BaseAction {

	private String commentContent;
	private User user;
	private Note note;
	private String test;
	private String username1;
	private List authorityList;
	private List noteList;
	private List percentage;

	public List getPercentage() {
		return percentage;
	}

	public void setPercentage(List percentage) {
		this.percentage = percentage;
	}

	public List getNoteList() {
		return noteList;
	}

	public void setNoteList(List noteList) {
		this.noteList = noteList;
	}

	public List getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List authorityList) {
		this.authorityList = authorityList;
	}

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String addNew(){
		note = (Note)ActionContext.getContext().getSession().get("note");
		User user = (User)ActionContext.getContext().getSession().get("user");
		if(!commentContent.equals("")){
			Comment comment = new Comment();
			Timestamp now = new Timestamp(System.currentTimeMillis());
			comment.setDate(now);
			comment.setContent(commentContent);
			comment.setNote(note);
			comment.setUsername(user.getUsername());
			commentService.saveOne(comment);
		}
		
		List tempPlanDateList = (List)planService.findByNote(note);		
		for(int i=0;i<percentage.size();i++){
			Plan plan = (Plan)tempPlanDateList.get(i);
			if(!((String)percentage.get(i)).equals("")){
				plan.setPercentage(Integer.valueOf((String)percentage.get(i)));
			}else{
				plan.setPercentage(null);
			}
			planService.updateOne(plan);
		}
		
		authorityList = authorityService.findByUser(user);
		noteList = noteService.findByPublisher(user);
		if (noteList != null) {
			this.NoteListdeleteTime(noteList);
			return "success_saveOne_publisher";
		}else{
			noteList =null;
			return "success_saveOne_publisher";
		}
//		String flagExeOrPub = (String) ActionContext.getContext().getSession().get("flagExeOrPub");
//		if(flagExeOrPub.equals("publisher")){
//			noteList = noteService.findByPublisher(user);
//			if (noteList != null) {
//				this.NoteListdeleteTime(noteList);
//				return "success_saveOne_publisher";
//			}
//		}
//		if(flagExeOrPub.equals("executor")){
//			noteList = noteService.findByExecutor(user);
//			if (noteList != null) {
//				this.NoteListdeleteTime(noteList);
//				return "success_saveOne_executor";
//			}
//		}
//		return "fail";
	}
}
