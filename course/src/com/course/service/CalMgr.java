package com.course.service;

import java.util.List;

import com.course.model.Calendar;

public interface CalMgr {
	boolean save(Calendar cal);
	List<Calendar> getAllCalendar();
	List<Calendar> getCalendars(int pageNo, int PAGE_SIZE);
}
