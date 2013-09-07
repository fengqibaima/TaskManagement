package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.CommentDAO;
import com.ascent.domain.Comment;
import com.ascent.domain.Note;
import com.ascent.service.CommentService;

public class CommentServiceImpl implements CommentService {

	private CommentDAO commentDAO; 
	
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public List findByNote(Note note) {
		// TODO Auto-generated method stub
		return commentDAO.findByNote(note);
	}

	public boolean saveOne(Comment comment) {
		// TODO Auto-generated method stub
		return commentDAO.saveOne(comment);
	}

}
