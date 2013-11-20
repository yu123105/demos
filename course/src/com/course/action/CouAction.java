package com.course.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.course.model.Courseware;
import com.course.service.CouMgr;
import com.opensymphony.xwork2.ActionSupport;

public class CouAction extends ActionSupport{
	private File couFile;
    private String couFileContentType;
    private String couFileFileName;
    private String destPath;
    
    private Courseware cou;
    private CouMgr couMgr;
    private List<Courseware> cous;
    
    /*
    分页处理
     */
    private int pageNo = 1;
    private int PAGE_SIZE;
    private int totalPage;
    
   /*
    *  注：getters和setters的名字因与属性名对应，否则struts2找不到该属性的setter方法，因而赋不了值
    * @see com.opensymphony.xwork2.ActionSupport#execute()
    */
    public String execute() throws Exception {
       System.out.println("Execute!");
       destPath = ServletActionContext.getServletContext().getRealPath("/coursewares/");
       
       try {
    	   System.out.println("Src File name: " + couFile);
		   System.out.println("Dst File name: " + couFileFileName);
		   
		   File destFile = new File(destPath, couFileFileName);
		   FileUtils.copyFile(couFile, destFile);
		   
	} catch (IOException e) {
		e.printStackTrace();
		return ERROR;
	}
       if (cou.getCwname() == null) {
    	   cou.setCwname(couFileFileName);
       }
	   cou.setPath("coursewares/" + couFileFileName);
	   cou.setDatetime(new Timestamp(System.currentTimeMillis()));
	   //System.out.println("cou = = = " + cou);
	   couMgr.save(cou);
	   
	   if (!couMgr.save(cou)) {
			return ERROR;
	   }
       
       System.out.println("Upload Finish!");
       return SUCCESS;
    }
    
    public String view() {
    	System.out.println("Cou-view");
		PAGE_SIZE = 5;
        totalPage = (couMgr.getAllCourseware().size() + PAGE_SIZE - 1) / PAGE_SIZE;
        if (pageNo == 0) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }
		cous = couMgr.getCoursewares(pageNo, PAGE_SIZE);
    	return "couview";
    }
    
	public File getCouFile() {
		return couFile;
	}
	public void setCouFile(File couFile) {
		this.couFile = couFile;
	}
	public String getCouFileContentType() {
		return couFileContentType;
	}
	public void setCouFileContentType(String couFileContentType) {
		this.couFileContentType = couFileContentType;
	}
	public String getCouFileFileName() {
		return couFileFileName;
	}
	public void setCouFileFileName(String couFileFileName) {
		this.couFileFileName = couFileFileName;
	}
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	public CouMgr getCouMgr() {
		return couMgr;
	}
	public void setCouMgr(CouMgr couMgr) {
		this.couMgr = couMgr;
	}
	public Courseware getCou() {
		return cou;
	}
	public void setCou(Courseware cou) {
		this.cou = cou;
	}

	public List<Courseware> getCous() {
		return cous;
	}

	public void setCous(List<Courseware> cous) {
		this.cous = cous;
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
