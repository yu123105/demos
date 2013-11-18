package com.course.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-9
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Guestbook {
    private int id;//留言ID
    private String cont;//留言内容
    private Timestamp datetime;//留言时间
    private User user;//留言者
    private Guestbook parent;//父留言
    private List<Guestbook> children = new ArrayList<Guestbook>();//子留言

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCont() {
        return cont;
    }
    public void setCont(String cont) {
        this.cont = cont;
    }
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
    @ManyToOne
    @JoinColumn(name="u_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name="parent_id")
    public Guestbook getParent() {
        return parent;
    }
    public void setParent(Guestbook parent) {
        this.parent = parent;
    }

    @OneToMany(cascade={CascadeType.ALL} ,mappedBy="parent", fetch=FetchType.EAGER)
    public List<Guestbook> getChildren() {
        return children;
    }
    public void setChildren(List<Guestbook> children) {
        this.children = children;
    }
}
