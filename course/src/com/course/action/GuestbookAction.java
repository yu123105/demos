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

    @Override
    public String execute() throws Exception {
        System.out.println("execute");
        list = gbm.getAllGuestbooks();
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
}
