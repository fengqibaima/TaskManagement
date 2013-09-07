package com.ascent.dao;

import java.util.List;

import com.ascent.domain.Comment;
import com.ascent.domain.Note;

public interface CommentDAO {

	public List findByNote(Note note);
	
	public boolean saveOne(Comment comment);
}
