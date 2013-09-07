package com.ascent.service;

import java.util.List;

import com.ascent.domain.Comment;
import com.ascent.domain.Note;

public interface CommentService {

	public List findByNote(Note note);
	
	public boolean saveOne(Comment comment);
	
}
