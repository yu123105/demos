package com.course.action;

import java.util.Map;
import com.course.model.User;
import com.course.service.UserMgr;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//用作登录的Action
public class LoginAction extends ActionSupport {
/*
 * 属性--------------------
 */
	//model
	private User user;
	
	//Service
	private UserMgr userMgr;
	
/*
 * 方法代码
 */
	/**
	 * 仅供登录并跳转页面：login成功后返回"login"，失败后返回"error"
	 * @return
	 * @throws Exception 
	 */
	public String login() throws Exception{
		if (userMgr.exists(user)) {
			user = userMgr.LoadUserByName(user.getUsername());
			System.out.println(user.getUsername()
					+ " is already login, password is " + user.getPassword());
			//将用户压入ActionContext中的session栈中（以后Session都这么操作）
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			return "login";
		}
		return "error";
	}

	
/*
 * setters,getters--------------------
 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public UserMgr getUserMgr() {
		return userMgr;
	}


	public void setUserMgr(UserMgr userMgr) {
		this.userMgr = userMgr;
	}
	
}
