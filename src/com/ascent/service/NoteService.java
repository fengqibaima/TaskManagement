package com.ascent.service;

import java.util.List;

import com.ascent.domain.Note;
import com.ascent.domain.User;

public interface NoteService {

	public Note findById(String id);
	
	public List findAll();
	
	public List findByTitle(String title, User user);
	
	public List findByMonthAndYear(int month, int year, User user);
	
	public List findByDay(String date, User user);
	
	public boolean update(Note note);
	
	public boolean deleteOne(Note note);
	
	public Note saveOne(Note note);
	
	public List findByPublisher(User user);
	
	public List findByExecutor(User user);
}
