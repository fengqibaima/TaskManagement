package com.ascent.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.NoteDAO;
import com.ascent.domain.Note;
import com.ascent.domain.User;

public class NoteDAOImpl extends HibernateDaoSupport implements NoteDAO {

	private static final Logger LOGGER = LogManager
			.getLogger(NoteDAOImpl.class);

	public Note findById(String id) {
		// TODO Auto-generated method stub
		String hql = "from Note n where n.id=?";
		Note note = (Note)this.getHibernateTemplate().find(hql,new Integer(id)).get(0);
		return note;
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
		String sql = "from Note n where month(date)=? and year(date)=? and User=?";
		List list = this.getHibernateTemplate().find(sql,
				new Object[] { month, year, user });
		return list;
	}

	public List findByDay(String date, User user) {
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		String timeEndOfADay = " 23:59:58";
		String tiemBeginOfADay = " 00:00:00";
		
		StringBuffer sbBegin = new StringBuffer();
		sbBegin.append(date);	
		sbBegin.append(tiemBeginOfADay);
		String dateBegin = sbBegin.toString();	

		StringBuffer sbDateEnd = new StringBuffer();
		sbDateEnd.append(date);
		sbDateEnd.append(timeEndOfADay);
		String dateEnd = sbDateEnd.toString();
		
		Date dfDateEnd = null;
		Date dfDateBegin = null;
		try {
			dfDateEnd = df2.parse(dateEnd);
			dfDateBegin = df2.parse(dateBegin);
//			System.out.println("begin of the day: "+dfDateBegin);	
//			System.out.println("end of the day: "+dfDateEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp tsDateBegin = new Timestamp(dfDateBegin.getTime());
		Timestamp tsDateEnd = new Timestamp(dfDateEnd.getTime());
		System.out.println("timestamp begin of the day: "+tsDateBegin);	
		System.out.println("timestamp end of the day: "+tsDateEnd);
		System.out.println("user name: "+user.getUsername());
		String hql = "from Note n where n.date>=? and n.date<=? and n.notePublishers.id=?";
		List list = this.getHibernateTemplate().find(hql,
				new Object[] { tsDateBegin,tsDateEnd, user.getId() });	
		
		if (list.size() > 0) {
			LOGGER.debug("success");
			return list;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}
	
//	public List findByDay(String date, User user) {
//		
//		String dateSplit[] = date.split("-");
//		String year = dateSplit[0];
//		String month = dateSplit[1];
//		String day = dateSplit[2];
//		String dayNext = String.valueOf(Integer.valueOf(day)+1);
//		StringBuffer sbNext = new StringBuffer();
//		sbNext.append(year);
//		sbNext.append("-");
//		sbNext.append(month);
//		sbNext.append("-");
//		sbNext.append(dayNext);
//		String dateNext = sbNext.toString();
//		System.out.println("next date: "+dateNext);
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		
//		String timeEndOfADay = " 23:59:58";
//		String tiemBeginOfADay = " 00:00:00";
//		
//		StringBuffer sbBegin = new StringBuffer();
//		sbBegin.append(date);	
//		sbBegin.append(tiemBeginOfADay);
//		String dateBegin = sbBegin.toString();	
//
//		StringBuffer sbDateEnd = new StringBuffer();
//		sbDateEnd.append(date);
//		sbDateEnd.append(timeEndOfADay);
//		String dateEnd = sbDateEnd.toString();
//		
//		Date dfDateEnd = null;
//		Date dfDateBegin = null;
//		Date dfDateNext = null;
//		try {
//			dfDateEnd = df2.parse(dateEnd);
//			dfDateBegin = df2.parse(dateBegin);
//			dfDateNext = df.parse(dateNext);
////			System.out.println("begin of the day: "+dfDateBegin);	
////			System.out.println("end of the day: "+dfDateEnd);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Timestamp tsDateBegin = new Timestamp(dfDateBegin.getTime());
//		Timestamp tsDateEnd = new Timestamp(dfDateEnd.getTime());
//		System.out.println("timestamp begin of the day: "+tsDateBegin);	
//		System.out.println("timestamp end of the day: "+tsDateEnd);
//		
////		String hql = "from Note n where n.date between ? and ? and n.user=?";
////		List list = this.getHibernateTemplate().find(hql,
////				new Object[] { tsDateBegin, tsDateEnd, user });
//		
//		String hql = "from Note n where n.date>=? and n.date<=? and n.user=?";
//		List list = this.getHibernateTemplate().find(hql,
//				new Object[] { tsDateBegin,tsDateEnd, user });	
//
////		String hql = "from Note n where n.date>= :beginTime and n.date<= :endTime and n.user= :user";
////		String[] params = { "beginTime", "endTime", "user" }; 
////		Object[] args = { tsDateBegin, tsDateEnd, user }; 
////		List list = this.getHibernateTemplate().findByNamedParam(hql, params, args);
//		
//		System.out.println("~~~~~~~list.size(): "+list.size());
//		if (list.size() > 0) {
//			LOGGER.debug("success");
//			return list;
//		} else {
//			LOGGER.debug("fail");
//			return null;
//		}
//	}

	public boolean update(Note note) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(note);
		return true;
	}

	public boolean deleteOne(Note note) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(note);
		return true;
	}

	public Note saveOne(Note note) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(note);
			return note;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List findByPublisher(User user) {
		// TODO Auto-generated method stub
		String hql = "from Note n where n.notePublishers.id=?";
		List list = this.getHibernateTemplate().find(hql, user.getId());
		if (list.size() > 0) {
			LOGGER.debug("success");
			return list;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}

	public List findByExecutor(User user) {

		String hql = "from Note n where n.noteExecutors.id=?";
		List list = this.getHibernateTemplate().find(hql, user.getId());
		System.out.println("list.size() "+list.size());
		if (list.size() > 0) {
			LOGGER.debug("success");
			return list;
		} else {
			LOGGER.debug("fail");
			return null;
		}
	}
}
