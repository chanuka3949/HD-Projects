package com.persistence;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PatientManager {
	
	static Configuration configuration = new Configuration().configure();	
	static SessionFactory sessionFactory = configuration.buildSessionFactory();
//	static Session session = sessionFactory.getCurrentSession();
//	static Transaction transaction = session.beginTransaction();
	
	public static void addPatient(Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(patient);
		transaction.commit();
		session.close();
	}
	
	public static String getPatientName(int pID) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT concat(firstName,' ',lastName) AS Name FROM Patient WHERE id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", pID);
		List<String> pName = query.list();
		session.close();
		return pName.get(0);
		
	}
	
	public static HashMap<Integer,String> getPatientList() {
		Session session = sessionFactory.openSession();
		String hql = "SELECT p.id,concat(firstName,' ',lastName) as name FROM Patient p";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.getResultList();
		HashMap<Integer,String> patients = new HashMap<Integer,String>();
		for (Object[] objects : list) {
			patients.put((Integer)objects[0], (String)objects[1]);
		}
		session.close();
		return patients;
	}
	
	public static List<Patient> selectPatient(int patientID) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Patient WHERE id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", patientID);
		List<Patient> list = query.list();
		session.close();
		return list;
	}
	
	public static boolean updatePatientDetails(Patient patient) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "UPDATE Patient SET firstName=:fname,lastName=:lname,gender=:gender,address=:address,telephone=:tp,bloodGroup=:bg WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", patient.getId());
			query.setParameter("fname", patient.getFirstName());
			query.setParameter("lname", patient.getLastName());
			query.setParameter("gender", patient.getGender());
			query.setParameter("address", patient.getAddress());
			query.setParameter("tp", patient.getTelephone());
			query.setParameter("bg", patient.getBloodGroup());
			int rows = query.executeUpdate();
			transaction.commit();
			if(rows == 1)
				return true;
			else
				return false;
		}catch (Exception e) {
			transaction.rollback();
			session.close();
			return false;
		}
	}
	
}
