package com.course.service;

import java.util.List;

import com.course.model.Student;

public interface StuMgr {

	boolean save(Student stu);

	List<Student> getAllStudents();

	List<Student> getStudents(int pageNo, int PAGE_SIZE);

	boolean delete(int id);

}
