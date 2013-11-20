package com.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.TeaDao;
import com.course.model.Guestbook;
import com.course.model.Teacher;
@Component("teaDao")
public class TeaDaoImpl implements TeaDao {

	private SessionFactory sessionFactory;
	
	public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public Teacher getTeacher(int id) {
		return (Teacher) getSession().get(Teacher.class, id);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "from Teacher";
		try {
			list = getSession().createQuery(sql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean Modify(Teacher tea) {
		try {
			getSession().update(tea);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Teacher> getTeachers(int pageNo, int PAGE_SIZE) {
		List<Teacher> list = new ArrayList<Teacher>();
		int startPos = (pageNo - 1) * PAGE_SIZE;
		String sql = "from Teacher";
		try {
			list = getSession().createQuery(sql).setFirstResult(startPos).setMaxResults(PAGE_SIZE).list();
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
