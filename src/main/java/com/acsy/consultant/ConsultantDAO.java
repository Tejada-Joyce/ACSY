package com.acsy.consultant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.acsy.database.hibernate.HibernateUtils;
import com.acsy.consultant.Consultant;
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
	
	public List<Consultant> getAll(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.consultant.Consultant";
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
	
	public Consultant get(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.consultant.Consultant where id = " + Integer.toString(id);
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
	
	public Consultant delete(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.consultant.Consultant where id = " + Integer.toString(id);
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
	
	public Consultant save(Consultant consultant){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(consultant);
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
	
	public Consultant update(Consultant consultant){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.update(consultant);
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
	
	public Consultant validate(String email, String password){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.consultant.Consultant where email = :email and password = :password";
			Query query = session.createQuery(sql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			Consultant consultant = (Consultant)query.getSingleResult();
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
