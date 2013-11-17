package com.course.model;

import javax.persistence.*;
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
    private Date datetime;//留言时间
    private Student student;//学生留言者
    private Teacher teacher;//老师
    @Override
	public String toString() {
		return "Guestbook [student=" + student + ", teacher=" + teacher + "]";
	}
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
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @ManyToOne
    @JoinColumn(name="t_id")
    public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@ManyToOne
    @JoinColumn(name="s_id")
    public Student getStudent() {
        return student;
    }
    public void setUser(Student student) {
        this.student = student;
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
