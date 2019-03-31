package com.acsy.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.acsy.database.hibernate.HibernateUtils;

public class AssignmentDAO {
	SessionFactory factory = null;
	Session session = null;
	
	private static AssignmentDAO single_instance = null;
	
	private AssignmentDAO () {
		factory = HibernateUtils.getSessionFactory();
	}
	
	public static AssignmentDAO getInstance() {
		
		if(single_instance == null) {
			single_instance = new AssignmentDAO();
		}
		
		return single_instance;
	}
	
	public List<Assignment> getAll(){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.assignment.Assignment";
			List<Assignment> assignments = (List<Assignment>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return assignments;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Assignment get(int id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.assignment.Assignment where id = " + Integer.toString(id);
			Assignment assignment = (Assignment)session.createQuery(sql).getSingleResult();
			session.getTransaction().commit();
			return assignment;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Assignment save(Assignment assignment){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.save(assignment);
			session.getTransaction().commit();
			return assignment;
		} catch (Exception e) {
			e.printStackTrace();
			//Rollback in case of an error occurred.
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<Assignment> assignmentsByCons(int consultant_id){
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			String sql = "from com.acsy.assignment.Assignment where consultant_id = " + Integer.toString(consultant_id);
			List<Assignment> assignments = (List<Assignment>)session.createQuery(sql).getResultList();
			session.getTransaction().commit();
			return assignments;
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
