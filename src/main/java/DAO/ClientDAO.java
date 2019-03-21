package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Client;
import model.Consultant;

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
	
	public List<Client> getClients(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Client";
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
	
	public Client getClient(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Client where id = " + Integer.toString(id);
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
	
	public Client removeClient(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Client where id = " + Integer.toString(id);
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
	
	public Client saveClient(Client client){
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
	
	public Client UpdateClient(Client client){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.Client where id = " + Integer.toString(client.getId());
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
}
