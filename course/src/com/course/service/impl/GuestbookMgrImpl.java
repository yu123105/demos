package com.course.service.impl;

import com.course.dao.GuestbookDao;
import com.course.model.Guestbook;
import com.course.service.GuestbookMgr;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-9
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
@Component("gbm")
public class GuestbookMgrImpl implements GuestbookMgr {

    /*
     * 属性--------------
     */
    private GuestbookDao guestbookDao;

    /*
     * 方法--------------
     */
    @Override
    public List<Guestbook> getAllGuestbooks() {
        return guestbookDao.getAllGuestbooks();
    }

    @Override
    public List<Guestbook> getGuestbooks(int pageNo, int PAGE_SIZE){
        return guestbookDao.getGuestbooks(pageNo, PAGE_SIZE);
    }

    @Override
    public boolean add(Guestbook guestbook, int parentid, int userid) {
        return guestbookDao.add(guestbook, parentid, userid);
    }
    
    /*
     * service层属性只需要setters即可,因为Spring注入就需要setters加@Resource注解
     */
    @Resource
    public void setGuestbookDao(GuestbookDao guestbookDao) {
        this.guestbookDao = guestbookDao;
    }

}
