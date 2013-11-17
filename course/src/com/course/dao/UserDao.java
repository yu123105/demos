package com.course.dao;

import com.course.model.Student;

public interface UserDao {
	/**
	 * 检验是否存在该用户
	 * @param User
	 * @return Boolean
	 */
	public boolean exists (Student user);
	
	/**
	 * 通过username来获取全部改用户信息
	 * @param username
	 * @return User
	 */
	public Student LoadUserByName (String username);
}
