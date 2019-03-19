package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.History;
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
	
	public List<History> getHistories(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.History";
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
	
	public History getHistory(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from model.History where id = " + Integer.toString(id);
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

}
