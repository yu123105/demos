package com.course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.course.dao.VidDao;
import com.course.model.Video;
@Component("vidDao")
public class VidDaoImpl implements VidDao {

	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean save(Video vid) {
		try {
			getSession().save(vid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Video> getAllVideo() {
		List<Video> list = new ArrayList<Video>();
		String sql = "from Video v order by desc v.datetime";
		try {
			list = getSession().createQuery(sql).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Video> getVideos(int pageNo, int PAGE_SIZE) {
		List<Video> list = new ArrayList<Video>();
		int startPos = (pageNo - 1) * PAGE_SIZE;
		String sql = "from Video";
		try {
			list = getSession().createQuery(sql).setFirstResult(startPos)
					.setMaxResults(PAGE_SIZE).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
