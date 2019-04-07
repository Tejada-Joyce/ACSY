package com.acsy.system.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acsy.admin.Admin;
import com.acsy.admin.AdminDAO;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;

public class AuthHelpers {
	
	private static Object current_user = null;
	
	public static Object getCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(current_user != null) return current_user;
		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("user_id");
		Boolean active = (Boolean) session.getAttribute("active");
		String type = (String)session.getAttribute("type");
		
		if(user_id != null && active != null && type != null) {
			if ("admin".equals(type)) {
				current_user = (Admin)AdminDAO.getInstance().get(user_id);
			} else if ("consultant".equals(type)) {
				current_user = (Consultant)ConsultantDAO.getInstance().get(user_id);
			}
		}
		
		return current_user;
	}
	
	public static boolean authenticate_admin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (getCurrentUser(request, response) instanceof Admin) return true;
		System.out.println(getCurrentUser(request, response));
		return false;
	}
	
	public static boolean authenticate_consultant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (getCurrentUser(request, response) instanceof Consultant) return true;
		System.out.println(getCurrentUser(request, response));
		return false;
	}
	
	public static boolean destroySession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		current_user = null;
		HttpSession session=request.getSession(); 
	    session.invalidate();
	    response.sendRedirect("/ACSY/index.jsp");
	    return true;	
	}
	
}
