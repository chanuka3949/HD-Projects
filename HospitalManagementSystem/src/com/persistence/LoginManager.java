package com.persistence;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LoginManager {
	static Configuration configuration = new Configuration().configure();	
	static SessionFactory sessionFactory = configuration.buildSessionFactory();
	static Session session = sessionFactory.getCurrentSession();
	static Transaction transaction = session.beginTransaction();
	
	
	public static void addEmployee(Login login) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(login);
		transaction.commit();
		session.close();
	}
	
	public static String CheckLogin(Login login) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT l.userType FROM Login l WHERE username=:un AND password=:pw";
		Query query = session.createQuery(hql);
		query.setParameter("un", login.getUsername());
		query.setParameter("pw",login.getPassword());
		List<String> list = query.getResultList();
		session.close();
		if(list.isEmpty())
			return "null";
		else {
			return list.get(0).toString();
		}
	}
}
