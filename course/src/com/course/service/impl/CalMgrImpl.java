package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.course.dao.CalDao;
import com.course.model.Calendar;
import com.course.service.CalMgr;

@Component("calMgr")
public class CalMgrImpl implements CalMgr {

	private CalDao calDao;
	
	@Override
	public boolean save(Calendar cal) {
		return calDao.save(cal);
	}
	
	@Override
	public List<Calendar> getAllCalendar() {
		return calDao.getAllCalendar();
	}
	
	@Override
	public List<Calendar> getCalendars(int pageNo, int PAGE_SIZE) {
		return calDao.getCalendars(pageNo, PAGE_SIZE);
	}
	
	@Resource
	public void setCalDao(CalDao calDao) {
		this.calDao = calDao;
	}

}
