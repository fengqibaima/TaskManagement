package com.ascent.struts2.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ascent.domain.Note;
import com.opensymphony.xwork2.ActionContext;

public class PlanChainAction extends BaseAction {

	private Note note;
	private List<String> processDayListStr;
	
	public List<Date> getProcessDayList() {
		return processDayList;
	}

	public void setProcessDayList(List<Date> processDayList) {
		this.processDayList = processDayList;
	}

	private List<Date> processDayList;	
	
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

	public String showPlanByPublisherPage(){
		note = (Note)ActionContext.getContext().getSession().get("newNote");
		Date startDate = note.getStarttime();		
		Date endDate = note.getEndtime();		
		long processDays = endDate.getTime()-startDate.getTime();
		processDays = processDays/1000/60/60/24;
		processDayListStr = new ArrayList<String>();	
		for(int i =0; i<=processDays;i++){
			Date temp = this.addDays(startDate, i);
			String sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(temp);
			processDayListStr.add(sdate);
		}
		ActionContext.getContext().getSession().put("tempPlanDateList", processDayListStr);
		return "success";
	}
	
}
