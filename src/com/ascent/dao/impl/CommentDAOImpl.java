package com.ascent.dao.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.CommentDAO;
import com.ascent.domain.Comment;
import com.ascent.domain.Note;

public class CommentDAOImpl extends HibernateDaoSupport implements CommentDAO {

	private static final Logger LOGGER = LogManager
	.getLogger(NoteDAOImpl.class);
	
	public List findByNote(Note note) {
		// TODO Auto-generated method stub
		System.out.println("noteid "+note.getId());
		String hql = "from Comment c where c.note=?";
		List list = this.getHibernateTemplate().find(hql, note);
		if (list.size() > 0) {
			LOGGER.debug("success");
			return list;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}

	public boolean saveOne(Comment comment) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(comment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
