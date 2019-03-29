package com.acsy.group;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.acsy.database.hibernate.HibernateUtils;

import java.util.*;

public class GroupDAO {
	SessionFactory factory = null;
	Session session = null;
	
	private static GroupDAO single_instance = null;
	
	private GroupDAO () {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public static GroupDAO getInstance() {
		
		if(single_instance == null) {
			single_instance = new GroupDAO();
		}
		
		return single_instance;
	}
	
	public List<Group> getAll(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.group.Group";
			List<Group> groups = (List<Group>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return groups;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Group get(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.group.Group where id = " + Integer.toString(id);
			Group group = (Group)session.createQuery(sql).getSingleResult();
			session.getTransaction().commit();
			return group;
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
