package com.bjsxt.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTreeTest {
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
//		new SchemaExport(new Configuration().configure()).create(false, true);
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testSave() {
		Org o = new Org();
		o.setName("总公司");
		Org o1 = new Org();
		o1.setName("分公司1");
		Org o2 = new Org();
		o2.setName("分公司2");
		Org o11 = new Org();
		o11.setName("分公司1下部门1");
		Org o12 = new Org();
		o12.setName("分公司1下部门2");
		Org o21 = new Org();
		o21.setName("分公司2下部门1");
		Org o22 = new Org();
		o22.setName("分公司2下部门2");
		
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.setParent(o);
		o2.setParent(o);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o11.setParent(o1);
		o12.setParent(o1);
		o2.getChildren().add(o21);
		o2.getChildren().add(o22);
		o21.setParent(o2);
		o22.setParent(o2);
		
		Org w = new Org();
		w.setName("w总公司");
		Org w1 = new Org();
		w1.setName("w分公司1");
		Org w2 = new Org();
		w2.setName("w分公司2");
		Org w11 = new Org();
		w11.setName("w分公司1下部门1");
		Org w12 = new Org();
		w12.setName("w分公司1下部门2");
		Org w21 = new Org();
		w21.setName("w分公司2下部门1");
		Org w22 = new Org();
		w22.setName("w分公司2下部门2");
		
		w.getChildren().add(w1);
		w.getChildren().add(w2);
		w1.setParent(w);
		w2.setParent(w);
		w1.getChildren().add(w11);
		w1.getChildren().add(w12);
		w11.setParent(w1);
		w12.setParent(w1);
		w2.getChildren().add(w21);
		w2.getChildren().add(w22);
		w21.setParent(w2);
		w22.setParent(w2);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(o);
		session.save(w);
		session.getTransaction().commit();
		
		
	}
	
	@Test
	public void testLoad () {
//		testSave();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Org o = (Org)session.load(Org.class, 1);
		print(o, 0);
		session.getTransaction().commit();
	}
	/**
	 * 多颗树同时获取
	 */
	@Test
	public void testLoad2 () {
//		testSave();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Org> list = session.createQuery("from Org o where o.parent.id = null").list();
		for (Org o : list) {
			print(o, 0);
		}
		session.getTransaction().commit();
	}
	
	//递归
	private void print(Org o, int level) {
		String preStr = "";
		for (int i = 0; i < level; i++){
			preStr += "---";
		}
		System.out.println(preStr + o.getName());
		for (Org child : o.getChildren()) {
			print(child, level+1);
		}
		
	}
	@Test
	public void testSchemaExport() {
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
	
	
	public static void main(String[] args) {
		beforeClass();
	}
}
