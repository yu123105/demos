package com.course.dao;

import java.util.List;

import com.course.model.Teacher;

public interface TeaDao {

	Teacher getTeacher(int id);

	List<Teacher> getAllTeachers();

	boolean Modify(Teacher tea);

	List<Teacher> getTeachers(int pageNo, int PAGE_SIZE);

}
