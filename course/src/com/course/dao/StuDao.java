package com.course.dao;

import java.util.List;

import com.course.model.Student;

public interface StuDao {

	boolean save(Student stu);

	List<Student> getAllStudents();

	List<Student> getStudents(int pageNo, int pAGE_SIZE);

	boolean delete(int id);

}
