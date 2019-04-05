package com.acsy.system.auth.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acsy.admin.Admin;
import com.acsy.admin.AdminDAO;
import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;

public class LoginCommand extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AdminDAO ad = AdminDAO.getInstance();
		Admin admin = ad.validate(email, password);
		ConsultantDAO cd = ConsultantDAO.getInstance();
		Consultant cons = cd.validate(email, password);
			
				
		if (admin != null) {
	      HttpSession session=request.getSession();  	      
	      session.setAttribute("user_id", admin.getId());
	      session.setAttribute("type", "admin");
	      session.setAttribute("active", true);
	      response.sendRedirect("/ACSY/consultants/index");
	     
		} else if (cons != null) {			 
	      HttpSession session=request.getSession();  	      
	      session.setAttribute("user_id", cons.getId());
	      session.setAttribute("type", "consultant");
	      session.setAttribute("active", true);
	      response.sendRedirect("/ACSY/histories/index");
	      
		} else {
	      request.setAttribute("error", "INVALID CREDENTIALS");
	      response.sendRedirect("/ACSY/index.jsp");
	      
		}
	}

}
