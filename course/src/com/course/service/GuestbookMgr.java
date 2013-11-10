package com.course.service;

import com.course.model.Guestbook;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-9
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public interface GuestbookMgr {
    abstract List<Guestbook> getAllGuestbooks();
    abstract boolean add(Guestbook guestbook, int parentid, int userid);
}
