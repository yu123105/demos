package com.course.service;

import com.course.model.Student;
//User的业务接口
public interface StudentMgr {
	public abstract boolean exists(Student user) throws Exception;
	public abstract Student LoadUserByName (String username) throws Exception;
}
