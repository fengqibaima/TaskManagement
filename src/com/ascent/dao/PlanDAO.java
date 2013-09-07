package com.ascent.dao;

import java.util.List;

import com.ascent.domain.Note;
import com.ascent.domain.Plan;


public interface PlanDAO {

	public boolean saveOne(Plan plan);
	
	public List findByNote(Note note);	
	
	public boolean updateOne(Plan plan);	
}
