package com.course.service;

import java.util.List;

import com.course.model.Courseware;

public interface CouMgr {

	boolean save(Courseware cou);

	List<Courseware> getAllCourseware();

	List<Courseware> getCoursewares(int pageNo, int PAGE_SIZE);

}
