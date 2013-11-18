package com.course.dao;

import com.course.model.User;

public interface UserDao {
	/**
	 * 检验是否存在该用户
	 * @param User
	 * @return Boolean
	 */
	public boolean exists(User user);
	
	/**
	 * 通过username来获取全部改用户信息
	 * @param username
	 * @return User
	 */
	public User LoadUserByName(String username);
}
