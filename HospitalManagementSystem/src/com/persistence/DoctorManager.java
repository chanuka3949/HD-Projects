package com.persistence;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DoctorManager {

		static Configuration configuration = new Configuration().configure();	
		static SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
		
		public static void addDoctor(Doctor doctor) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			try {
				session.save(doctor);
				transaction.commit();
			}catch (Exception e) {
				transaction.rollback();
			}
			finally {
				session.close();
			}
		}
		
		public static String getDoctorName(int docID) {
			Session session = sessionFactory.openSession();
			String hql = "SELECT concat(firstName,' ',lastName) AS Name FROM Doctor WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", docID);
			List<String> docName = query.list();
			session.close();
			return docName.get(0);
			
		}
		
		public static List<String> getAvailableDates(int doctorID){
			Session session = sessionFactory.openSession();
			String hql = "SELECT appointmentDate FROM Appointment WHERE appointmentNo = (SELECT appointmentCount FROM Doctor WHERE ID =:id) AND appointmentDate >=:date";
			Query query = session.createQuery(hql);
			query.setParameter("id", doctorID);
			query.setParameter("date", LocalDate.now().toString());
			List list = query.getResultList();
			session.close();
			return list;
		}
		
		public static HashMap<Integer,String> getDoctorList() {
			Session session = sessionFactory.openSession();
			String hql = "SELECT d.id,concat(firstName,' ',lastName) as name FROM Doctor d";
			Query query = session.createQuery(hql);
			List<Object[]> list = query.getResultList();
			HashMap<Integer,String> doctors = new HashMap<Integer,String>();
			for (Object[] objects : list) {
				doctors.put((Integer)objects[0], (String)objects[1]);
			}
			session.close();
			return doctors;
		}
		
		public static List<Doctor> selectDoctor(int doctorID){
			Session session = sessionFactory.openSession();
			String hql = "FROM Doctor WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", doctorID);
			List<Doctor> list = query.list();
			session.close();
			return list;
		}
		
		public static boolean updateDoctorDetails(Doctor doctor) {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			try {
				String hql = "UPDATE Doctor SET firstName=:fname, lastName=:lname,mobile=:mobile,medicalLicense=:medlicense,appointmentCount=:acount WHERE id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", doctor.getId());
				query.setParameter("fname", doctor.getFirstName());
				query.setParameter("lname", doctor.getLastName());
				query.setParameter("mobile", doctor.getMobile());
				query.setParameter("medlicense", doctor.getMedicalLicense());
				query.setParameter("acount", doctor.getAppointmentCount());
				int rows = query.executeUpdate();
				transaction.commit();
				if(rows == 1)
					return true;
				else
					return false;
			}catch (Exception e) {
				transaction.rollback();
				return false;
			}
			finally {
				session.close();
			}
			
		}

}
