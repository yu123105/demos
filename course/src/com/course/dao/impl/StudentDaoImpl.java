package com.course.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.UserDao;
import com.course.model.Student;

@Component("userDao")
public class StudentDaoImpl implements UserDao {

/*
 * attributes----------------------------
 */
	/*
	 * SessionFactory必须要设置setters,getters
	 * 并且要让spring管理Session就需要加上注解@Resource
	 */
	private SessionFactory sessionFactory;
	
/*
 * methods-------------------------------
 */
	/**
	 * 为了方便获取Session
	 * @return Session
	 */
	public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public boolean exists(Student student) {
		Student u = (Student) getSession().createQuery(
				"from User u where u.username = '" + student.getUsername()
						+ "' and u.password = '" + student.getPassword() + "'")
				.uniqueResult();
		if (u != null) {
			return true;
		}
		return false;
	}

	@Override
	public Student LoadUserByName(String username) {
		Student user = (Student) getSession().createQuery(
				"from User u where u.username = '" + username + "'")
				.uniqueResult();
		return user;
	}

/*
 * setters,getters-------------------------
 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
