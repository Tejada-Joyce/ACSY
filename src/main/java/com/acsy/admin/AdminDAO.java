package com.acsy.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	
	public List<Admin> getAdmins(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Admin";
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
	
	public Admin getAdmin(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Admin where id = " + Integer.toString(id);
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
	
}
