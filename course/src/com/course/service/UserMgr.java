package com.course.service;

import com.course.model.User;
//User的业务接口
public interface UserMgr {
	public abstract boolean exists(User user) throws Exception;
	public abstract User LoadUserByName (String username) throws Exception;
}
