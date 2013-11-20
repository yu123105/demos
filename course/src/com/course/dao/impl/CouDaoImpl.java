package com.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.CouDao;
import com.course.model.Courseware;
import com.course.model.Guestbook;

@Component("couDao")
public class CouDaoImpl implements CouDao {

	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(Courseware cou) {
		try {
			getSession().save(cou);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Courseware> getAllCourseware() {
		List<Courseware> list = new ArrayList<Courseware>();
		String sql = "from Courseware c order by c.datetime desc";
		try {
			list = getSession().createQuery(sql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Courseware> getCoursewares(int pageNo, int PAGE_SIZE) {
		List<Courseware> list = new ArrayList<Courseware>();
		int startPos = (pageNo - 1) * PAGE_SIZE;
		String sql = "from Courseware";
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
