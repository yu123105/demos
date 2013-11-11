package com.course.dao;

import com.course.model.Guestbook;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-9
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public interface GuestbookDao {
    abstract List<Guestbook> getAllGuestbooks();
    abstract boolean add(Guestbook guestbook, int parentid, int userid);
    abstract List<Guestbook> getGuestbooks(int pageNo, int PAGE_SIZE);
}
