package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.NoteDAO;
import com.ascent.domain.Note;
import com.ascent.domain.User;
import com.ascent.service.NoteService;

public class NoteServiceImpl implements NoteService {

	private NoteDAO noteDAO;
	
	public NoteDAO getNoteDAO() {
		return noteDAO;
	}

	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	public Note findById(String id) {
		// TODO Auto-generated method stub
		return noteDAO.findById(id);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByTitle(String title, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByMonthAndYear(int month, int year, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByDay(String date, User user) {
		// TODO Auto-generated method stub
		return noteDAO.findByDay(date, user);
	}

	public boolean update(Note note) {
		// TODO Auto-generated method stub
		return noteDAO.update(note);
	}

	public boolean deleteOne(Note note) {
		// TODO Auto-generated method stub
		return noteDAO.deleteOne(note);
	}

	public Note saveOne(Note note) {
		// TODO Auto-generated method stub
		return noteDAO.saveOne(note);
	}

	public List findByPublisher(User user) {
		// TODO Auto-generated method stub
		return noteDAO.findByPublisher(user);
	}

	public List findByExecutor(User user) {
		// TODO Auto-generated method stub
		return noteDAO.findByExecutor(user);
	}

}
