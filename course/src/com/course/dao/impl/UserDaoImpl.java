package com.course.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.UserDao;
import com.course.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

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
	public boolean exists(User user) {
		User u = (User) getSession().createQuery(
				"from User u where u.username = '" + user.getUsername()
						+ "' and u.password = '" + user.getPassword() + "'")
				.uniqueResult();
		if (u != null) {
			return true;
		}
		return false;
	}

	@Override
	public User LoadUserByName(String username) {
		User user = (User) getSession().createQuery(
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
