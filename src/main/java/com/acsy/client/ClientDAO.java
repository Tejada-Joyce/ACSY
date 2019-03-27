package com.acsy.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.acsy.database.hibernate.HibernateUtils;

import java.util.*;

public class ClientDAO {
	
	SessionFactory factory = null;
	Session session = null;
	
	private static ClientDAO single_instance = null;
	
	private ClientDAO () {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public static ClientDAO getInstance() {
		
		if(single_instance == null) {
			single_instance = new ClientDAO();
		}
		
		return single_instance;
	}
	
	public List<Client> getAll(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.client.Client";
			List<Client> clients = (List<Client>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return clients;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Client get(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.client.Client where id = " + Integer.toString(id);
			Client client = (Client)session.createQuery(sql).getSingleResult();
			session.getTransaction().commit();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Client delete(Client client){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.remove(client);
			session.getTransaction().commit();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Client delete(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.client.Client where id = " + Integer.toString(id);
			Client client = (Client)session.createQuery(sql).getSingleResult();
			session.remove(client);
			session.getTransaction().commit();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Client save(Client client){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(client);
			session.getTransaction().commit();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Client update(Client client){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.update(client);
			session.getTransaction().commit();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<Client> clientsByGroup(int group_id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.client.Client where group_id = " + Integer.toString(group_id);
			List<Client> clients = (List<Client>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return clients;
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
