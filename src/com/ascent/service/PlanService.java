package com.ascent.service;

import java.util.List;

import com.ascent.domain.Note;
import com.ascent.domain.Plan;


public interface PlanService {

	public boolean saveOne(Plan plan);
	
	public List findByNote(Note note);
	
	public boolean updateOne(Plan plan);
}
