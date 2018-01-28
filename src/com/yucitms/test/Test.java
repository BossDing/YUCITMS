package com.yucitms.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yucitms.orm.netLesson.ExcellentCourse;
@Component
public class Test {
	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void add() {
		Session session = sessionFactory.getCurrentSession();
		ExcellentCourse course= new ExcellentCourse();
		course.setPractice("132456");
		course.setScheduling("132456");
		session.save(course);
	}

	public static void main(String[] args) {
		Test test  =new Test();
		test.add();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
