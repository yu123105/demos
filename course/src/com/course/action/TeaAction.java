package com.course.action;

import java.util.List;

import com.course.model.Teacher;
import com.course.service.TeaMgr;
import com.opensymphony.xwork2.ActionSupport;

public class TeaAction extends ActionSupport{
	private int id;
	private Teacher tea;
	private List<Teacher> teas;
	private TeaMgr teaMgr;
	
	/*
    分页处理
     */
    private int pageNo = 1;
    private int PAGE_SIZE;
    private int totalPage;
	
	public String getTeacher (){
		if (id != 0) {
			tea = teaMgr.getTeacher(id);
		}
		return "teaform";
	}
	
	public String modify () {
		if (!teaMgr.Modify(tea)) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String view() {
		System.out.println("Tea-view");
		PAGE_SIZE = 5;
        totalPage = (teaMgr.getAllTeachers().size() + PAGE_SIZE - 1) / PAGE_SIZE;
        if (pageNo == 0) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }
		teas = teaMgr.getTeachers(pageNo, PAGE_SIZE);
		return "teaview";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public TeaMgr getTeaMgr() {
		return teaMgr;
	}

	public void setTeaMgr(TeaMgr teaMgr) {
		this.teaMgr = teaMgr;
	}

	public List<Teacher> getTeas() {
		return teas;
	}

	public void setTeas(List<Teacher> teas) {
		this.teas = teas;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPAGE_SIZE() {
		return PAGE_SIZE;
	}

	public void setPAGE_SIZE(int pAGE_SIZE) {
		PAGE_SIZE = pAGE_SIZE;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
