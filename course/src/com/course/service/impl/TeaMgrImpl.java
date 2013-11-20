package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.course.dao.TeaDao;
import com.course.model.Teacher;
import com.course.service.TeaMgr;
@Component("teaMgr")
public class TeaMgrImpl implements TeaMgr {

	private TeaDao teaDao; 
	
	@Override
	public Teacher getTeacher(int id) {
		return teaDao.getTeacher(id);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teaDao.getAllTeachers();
	}

	@Override
	public boolean Modify(Teacher tea) {
		return teaDao.Modify(tea);
	}
	

	@Override
	public List<Teacher> getTeachers(int pageNo, int PAGE_SIZE) {
		return teaDao.getTeachers(pageNo, PAGE_SIZE);
	}
	
	@Resource
	public void setTeaDao(TeaDao teaDao) {
		this.teaDao = teaDao;
	}
}
