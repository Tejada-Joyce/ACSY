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
		Class type = (Class) session.getAttribute("type");
		
		if(user_id != null && active != null && type != null) {
			if (Admin.class == type) {
				current_user = AdminDAO.getInstance().get(user_id);
			} else if (Consultant.class == type) {
				current_user = ConsultantDAO.getInstance().get(user_id);
			}
		} else {
			response.sendRedirect("index.jsp");
		}
		
		return current_user;
	}
	
	public static void authenticate_admin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (current_user instanceof Admin) return ;
		response.sendRedirect("index.jsp");
	}
	
	public static void authenticate_consultant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (current_user instanceof Consultant) return;
		response.sendRedirect("index.jsp");
	}
	
}