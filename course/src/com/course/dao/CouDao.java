package com.course.dao;

import java.util.List;

import com.course.model.Courseware;

public interface CouDao {

	boolean save(Courseware cou);

	List<Courseware> getAllCourseware();

	List<Courseware> getCoursewares(int pageNo, int PAGE_SIZE);
	
}
