package com.course.action;

import java.util.Map;
import com.course.model.Student;
import com.course.service.StudentMgr;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//用作登录的Action
public class LoginAction extends ActionSupport {
/*
 * 属性--------------------
 */
	//model
	private Student student;
	
	//Service
	private StudentMgr studentMgr;
	
/*
 * 方法代码
 */
	/**
	 * 仅供登录并跳转页面：login成功后返回"login"，失败后返回"error"
	 * @return
	 * @throws Exception 
	 */
	public String login() throws Exception{
		if (studentMgr.exists(student)) {
			student = studentMgr.LoadUserByName(student.getUsername());
			System.out.println(student.getUsername()
					+ " is already login, password is " + student.getPassword());
			//将用户压入ActionContext中的session栈中（以后Session都这么操作）
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("user", student);
			return "login";
		}
		return "error";
	}

	
/*
 * setters,getters--------------------
 */
	public Student getStudentr() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public StudentMgr getStudentMgr() {
		return studentMgr;
	}


	public void setStudentMgr(StudentMgr studentMgr) {
		this.studentMgr = studentMgr;
	}
	
}
