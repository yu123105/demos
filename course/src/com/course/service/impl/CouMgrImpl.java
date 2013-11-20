package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.course.dao.CouDao;
import com.course.model.Courseware;
import com.course.service.CouMgr;
@Component("couMgr")
public class CouMgrImpl implements CouMgr {

	private CouDao couDao;
	
	@Override
	public boolean save(Courseware cou) {
		return couDao.save(cou);
	}

	@Override
	public List<Courseware> getAllCourseware() {
		return couDao.getAllCourseware();
	}

	public CouDao getCouDao() {
		return couDao;
	}
	
	@Override
	public List<Courseware> getCoursewares(int pageNo, int PAGE_SIZE) {
		return couDao.getCoursewares(pageNo, PAGE_SIZE);
	}
	
	@Resource
	public void setCouDao(CouDao couDao) {
		this.couDao = couDao;
	}

}
