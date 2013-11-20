package com.course.action;

import java.util.List;

import com.course.model.Student;
import com.course.service.StuMgr;
import com.opensymphony.xwork2.ActionSupport;

public class StuAction extends ActionSupport {
	private int id;
	private Student stu;
	private StuMgr stuMgr;
	private List<Student> stus;
	
	 /*
    分页处理
     */
    private int pageNo = 1;
    private int PAGE_SIZE;
    private int totalPage;
	
	public String add() {
		if (!stuMgr.save(stu)) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String view () {
		System.out.println("Stu-view");
		PAGE_SIZE = 5;
        totalPage = (stuMgr.getAllStudents().size() + PAGE_SIZE - 1) / PAGE_SIZE;
        if (pageNo == 0) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }
		stus = stuMgr.getStudents(pageNo, PAGE_SIZE);
		return "stuview";
	}

	public String delete() {
		if(stuMgr.delete(id)) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/*getters,setters*/
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public StuMgr getStuMgr() {
		return stuMgr;
	}

	public void setStuMgr(StuMgr stuMgr) {
		this.stuMgr = stuMgr;
	}

	public List<Student> getStus() {
		return stus;
	}

	public void setStus(List<Student> stus) {
		this.stus = stus;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
