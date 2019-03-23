package com.acsy.consultant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.acsy.database.hibernate.HibernateUtils;

import java.util.*;

public class ConsultantDAO {
	
	SessionFactory factory = null;
	Session session = null;
	
	private static ConsultantDAO single_instance = null;
	
	private ConsultantDAO () {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public static ConsultantDAO getInstance() {
		
		if(single_instance == null) {
			single_instance = new ConsultantDAO();
		}
		
		return single_instance;
	}
	
	public List<Consultant> getConsultants(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Consultant";
			List<Consultant> consultants = (List<Consultant>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return consultants;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Consultant getConsultant(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Consultant where id = " + Integer.toString(id);
			Consultant consultant = (Consultant)session.createQuery(sql).getSingleResult();
			session.getTransaction().commit();
			return consultant;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Consultant removeConsultant(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Consultant where id = " + Integer.toString(id);
			Consultant consultant = (Consultant)session.createQuery(sql).getSingleResult();
			session.remove(consultant);
			session.getTransaction().commit();
			return consultant;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
}
