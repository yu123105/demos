package com.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.StuDao;
import com.course.model.Student;

@Component("stuDao")
public class StuDaoImpl implements StuDao {

	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(Student stu) {
		try {
			getSession().save(stu);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		String sql = "from Student";
		try {
			list = getSession().createQuery(sql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> getStudents(int pageNo, int PAGE_SIZE) {
		List<Student> list = new ArrayList<Student>();
		int startPos = (pageNo - 1) * PAGE_SIZE;
		String sql = "from Student";
		try {
			list = getSession().createQuery(sql).setFirstResult(startPos)
					.setMaxResults(PAGE_SIZE).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean delete(int id) {
		String sql = "delete Student s where s.id = " + id;
		try {
			getSession().createQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
