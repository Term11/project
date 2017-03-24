package bwf.teaching.book.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

class BaseDao {
	
	@Resource(name="sf")
	private SessionFactory sessionFactory;
	
	
	protected Session getCurrSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
