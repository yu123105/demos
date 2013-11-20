package com.course.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.course.model.Calendar;
import com.course.service.CalMgr;
import com.opensymphony.xwork2.ActionSupport;

public class CalAction extends ActionSupport {
	private File calFile;
	private String calFileContentType;
	private String calFileFileName;
	private String destPath;

	private Calendar cal;
	private CalMgr calMgr;
	private List<Calendar> cals;
	
	/*
    分页处理
     */
    private int pageNo = 1;
    private int PAGE_SIZE;
    private int totalPage;

	/*
	 * 注：getters和setters的名字因与属性名对应，否则struts2找不到该属性的setter方法，因而赋不了值
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		System.out.println("Execute!");
		destPath = ServletActionContext.getServletContext().getRealPath(
				"/calendars/");
		try {
			System.out.println("Src File name: " + calFile);
			System.out.println("Dst File name: " + calFileFileName);

			File destFile = new File(destPath, calFileFileName);
			FileUtils.copyFile(calFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		if (cal.getCname() == null) {
			cal.setCname(calFileFileName);
		}
		cal.setPath("calendars/" + calFileFileName);
		cal.setDatetime(new Timestamp(System.currentTimeMillis()));

		if (!calMgr.save(cal)) {
			return ERROR;
		}

		System.out.println("Upload Finish!");
		return SUCCESS;
	}

	public String view() {
		System.out.println("Cal-view");
		PAGE_SIZE = 5;
        totalPage = (calMgr.getAllCalendar().size() + PAGE_SIZE - 1) / PAGE_SIZE;
        if (pageNo == 0) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }
		cals = calMgr.getCalendars(pageNo, PAGE_SIZE);
		return "calview";
	}
	public File getCalFile() {
		return calFile;
	}

	public void setCalFile(File calFile) {
		this.calFile = calFile;
	}

	public String getCalFileContentType() {
		return calFileContentType;
	}

	public void setCalFileContentType(String calFileContentType) {
		this.calFileContentType = calFileContentType;
	}

	public String getCalFileFileName() {
		return calFileFileName;
	}

	public void setCalFileFileName(String calFileFileName) {
		this.calFileFileName = calFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public CalMgr getCalMgr() {
		return calMgr;
	}

	public void setCalMgr(CalMgr calMgr) {
		this.calMgr = calMgr;
	}

	public List<Calendar> getCals() {
		return cals;
	}

	public void setCals(List<Calendar> cals) {
		this.cals = cals;
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
