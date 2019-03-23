package com.acsy.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.acsy.database.hibernate.HibernateUtils;

import java.util.*;

public class AdminDAO {
	
	SessionFactory factory = null;
	Session session = null;
	
	private static AdminDAO single_instance = null;
	
	private AdminDAO () {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public static AdminDAO getInstance() {
		
		if(single_instance == null) {
			single_instance = new AdminDAO();
		}
		
		return single_instance;
	}
	
	public List<Admin> getAll(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.admin.Admin";
			List<Admin> admins = (List<Admin>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return admins;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Admin get(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.admin.Admin where id = " + Integer.toString(id);
			Admin admin = (Admin)session.createQuery(sql).getSingleResult();
			session.getTransaction().commit();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Admin validate(String email, String password){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.admin.Admin where email = :email and password = :password";
			Query query = session.createQuery(sql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			Admin admin = (Admin)query.getSingleResult();
			session.getTransaction().commit();			
			return admin;
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
