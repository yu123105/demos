package com.course.dao.impl;

import com.course.dao.GuestbookDao;
import com.course.model.Guestbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-9
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
@Component("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao {
    /*
     * attributes----------------------------
     */
	/*
	 * SessionFactory必须要设置setters,getters
	 * 并且要让spring管理Session就需要加上注解@Resource
	 */
    private SessionFactory sessionFactory;

    /**
     * 为了方便获取Session
     * @return Session
     */
    public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }

    /*
     * methods-------------------------------
     */
    @Override
    public List<Guestbook> getAllGuestbooks() {
        List<Guestbook> list = new ArrayList<Guestbook>();
    	/*
    	 * 这样写能否多棵树查询？经过测试这是可以的 测试程序见hibernate_2200_Tree
    	 * 值得注意的是HQL语句中得筛选出根节点
    	 * 一棵树查询是get(XXX.Class, id);
    	 */
        list = getSession().createQuery("from Guestbook g where g.parent.id = null").list();
        return list;
    }

    @Override
    public boolean add(Guestbook guestbook, int parentid, int userid) {
        try {

            String d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(guestbook.getDatetime());
            String sql = "insert into guestbook " +
                         "values ( null,'" + guestbook.getCont() + "'," +
                         "'" + d + "',";
            if (parentid == 0) {
                sql += null + ",";
            } else {
                sql += parentid + ",";
            }
            sql += userid + ")";
            System.out.println("---时间：" + d + "\n" + "sql:" + sql);
            getSession().createSQLQuery(sql).executeUpdate();

            /*错误方法
            getSession().createSQLQuery("insert into guestbook " +
                    "values ( null,'" + guestbook.getCont() + "'," +
                    "" + d + "," +
                    "" + parentid +"," +
                    "" + userid + ")").executeUpdate();*/

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /*
     * setters,getters-------------------------
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
