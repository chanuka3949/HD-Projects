package com.persistence;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AppointmentManager {
	
	static Configuration configuration = new Configuration().configure();	
	static SessionFactory sessionFactory = configuration.buildSessionFactory();
//	static Session session = sessionFactory.getCurrentSession();
//	static Transaction transaction = session.beginTransaction();
	
	public static boolean addAppointment(Appointment appointment) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(appointment);
			transaction.commit();
			return true;
		}catch (Exception e) {
			transaction.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}
	
	public static int getLastAppointment(int doctorID,String date) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT count(a.appointmentNo) FROM Appointment a WHERE a.doctorID=:id AND a.appointmentDate=:date";
		Query query = session.createQuery(hql);
		query.setParameter("id", doctorID);
		query.setParameter("date",date);
		List<Long> list = query.list();
		session.close();
		return list.get(0).intValue();
	}
	
}
