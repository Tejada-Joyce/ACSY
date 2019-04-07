package com.acsy.history;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.acsy.database.hibernate.HibernateUtils;

import java.util.*;

public class HistoryDAO {
	SessionFactory factory = null;
	Session session = null;
	
	private static HistoryDAO single_instance = null;
	
	private HistoryDAO () {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public static HistoryDAO getInstance() {
		
		if(single_instance == null) {
			single_instance = new HistoryDAO();
		}
		
		return single_instance;
	}
	
	public List<History> getAll(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.history.History";
			List<History> histories = (List<History>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return histories;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public History get(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.history.History where id = " + Integer.toString(id);
			History history = (History)session.createQuery(sql).getSingleResult();
			session.getTransaction().commit();
			return history;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	public History delete(History history){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.remove(history);
			session.getTransaction().commit();
			return history;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public History delete(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.history.History where id = " + Integer.toString(id);
			History history = (History)session.createQuery(sql).getSingleResult();
			session.remove(history);
			session.getTransaction().commit();
			return history;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public History save(History history){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(history);
			session.getTransaction().commit();
			return history;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<History> save(List<History> histories){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(histories);
			session.getTransaction().commit();
			return histories;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public History update(History history){
	  System.out.println("UPDATING HISTORY: ");
      
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.update(history);
			session.getTransaction().commit();
			return history;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<History> historiesByAssignment(int assignment_id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.history.History where assignment_id = " + Integer.toString(assignment_id);
			List<History> histories = (List<History>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return histories;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<History> historiesByClient(int client_id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.history.History where client_id = " + Integer.toString(client_id);
			List<History> histories = (List<History>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return histories;
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
