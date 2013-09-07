package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.PlanDAO;
import com.ascent.domain.Note;
import com.ascent.domain.Plan;
import com.ascent.service.PlanService;

public class PlanServiceImpl implements PlanService {

	private PlanDAO planDAO;
	
	public PlanDAO getPlanDAO() {
		return planDAO;
	}

	public void setPlanDAO(PlanDAO planDAO) {
		this.planDAO = planDAO;
	}

	public boolean saveOne(Plan plan) {
		// TODO Auto-generated method stub
		return planDAO.saveOne(plan);
	}

	public List findByNote(Note note){
		return planDAO.findByNote(note);
	}
	
	public boolean updateOne(Plan plan){
		return planDAO.updateOne(plan);
	}
}
