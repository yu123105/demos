package com.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.CalDao;
import com.course.model.Calendar;
import com.course.model.Student;

@Component("calDao")
public class CalDaoImpl implements CalDao {

	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(Calendar cal) {
		try {
			getSession().save(cal);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Calendar> getAllCalendar() {
		List<Calendar> list = new ArrayList<Calendar>();
		String sql = "from Calendar c order by desc c.datetime";
		try {
			list = getSession().createQuery(sql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Calendar> getCalendars(int pageNo, int PAGE_SIZE) {
		List<Calendar> list = new ArrayList<Calendar>();
		int startPos = (pageNo - 1) * PAGE_SIZE;
		String sql = "from Calendar";
		try {
			list = getSession().createQuery(sql).setFirstResult(startPos)
					.setMaxResults(PAGE_SIZE).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
