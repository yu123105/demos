package com.course.action;

import com.course.model.Guestbook;
import com.course.service.GuestbookMgr;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-9
 * Time: 下午1:59
 * To change this template use File | Settings | File Templates.
 */
public class GuestbookAction extends ActionSupport {
    private int userid;
    private int parentid;
    private Guestbook guestbook;
    private List<Guestbook> list;
    private GuestbookMgr gbm;
    /*
    分页处理
     */
    private int pageNo = 1;
    private int PAGE_SIZE;
    private int totalPage;

    /*
     * methods
     */

    @Override
    public String execute() throws Exception {
        System.out.println("execute");
        PAGE_SIZE = 5;
        totalPage = (gbm.getAllGuestbooks().size() + PAGE_SIZE - 1) / PAGE_SIZE;
        if (pageNo == 0) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }
        list = gbm.getGuestbooks(pageNo, PAGE_SIZE);
        return SUCCESS;
    }

    public String add() {
        System.out.println("add...");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println(ts);
        guestbook.setDatetime(ts);
        boolean flag = gbm.add(this.guestbook, this.parentid, this.userid);
        if (!flag) {
            return ERROR;
        }
        return "index";
    }
    
    /*
     * setters getters
     */
    
    public GuestbookMgr getGbm() {
    	return gbm;
    }
    
    public void setGbm(GuestbookMgr gbm) {
    	this.gbm = gbm;
    }
    
    public int getParentid() {
    	return parentid;
    }
    
    public void setParentid(int parentid) {
    	this.parentid = parentid;
    }
    
    public int getUserid() {
    	return userid;
    }
    
    public void setUserid(int userid) {
    	this.userid = userid;
    }
    
    public Guestbook getGuestbook() {
    	return guestbook;
    }
    
    public void setGuestbook(Guestbook guestbook) {
    	this.guestbook = guestbook;
    }
    
    public List<Guestbook> getList() {
    	return list;
    }
    
    public void setList(List<Guestbook> list) {
    	this.list = list;
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
    
    public void setPAGE_SIZE(int PAGE_SIZE) {
    	this.PAGE_SIZE = PAGE_SIZE;
    }
    
    public int getTotalPage() {
    	return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
    	this.totalPage = totalPage;
    }
}
