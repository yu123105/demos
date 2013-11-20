package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.course.dao.StuDao;
import com.course.model.Student;
import com.course.service.StuMgr;
@Component("stuMgr")
public class StuMgrImpl implements StuMgr{
	
	private StuDao stuDao;
	
	@Override
	public boolean save(Student stu) {
		return stuDao.save(stu);
	}

	@Override
	public List<Student> getAllStudents() {
		return stuDao.getAllStudents();
	}
	
	@Override
	public List<Student> getStudents(int pageNo, int PAGE_SIZE) {
		return stuDao.getStudents(pageNo, PAGE_SIZE);
	}

	@Override
	public boolean delete(int id) {
		return stuDao.delete(id);
	}
	
	public StuDao getStuDao() {
		return stuDao;
	}
	@Resource
	public void setStuDao(StuDao stuDao) {
		this.stuDao = stuDao;
	}

}
