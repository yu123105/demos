package com.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 用户：学生
 * @author Administrator
 */
@Entity
@PrimaryKeyJoinColumn(name="stu_id")
public class Student extends User{

	private String clazz;
	
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
}
