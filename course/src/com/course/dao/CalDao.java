package com.course.dao;

import java.util.List;

import com.course.model.Calendar;

public interface CalDao {
	boolean save(Calendar cal);
	List<Calendar> getAllCalendar();
	List<Calendar> getCalendars(int pageNo, int PAGE_SIZE);
}
