package com.course.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.course.dao.UserDao;
import com.course.model.User;
import com.course.service.UserMgr;
//UserMgr业务接口的实现类，用Spring管理，注入到userMgr
@Component("userMgr")
public class UserMgrImpl implements UserMgr{
/*
 * 属性--------------
 */
	private UserDao userDao;
	
	
/*
 * 方法--------------
 */
	@Override
	public boolean exists(User user) throws Exception {
		return userDao.exists(user);
	}

	@Override
	public User LoadUserByName(String username) throws Exception {
		return userDao.LoadUserByName(username);
	}


/*
 * service层属性只需要setters即可,因为Spring注入就需要setters加@Resource注解
 */
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
