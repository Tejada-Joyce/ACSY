package com.acsy.admin.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.admin.AdminHelpers;
import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.group.GroupDAO;
import com.acsy.system.auth.AuthHelpers;

public class NewAssignmentCommand extends AbstractCommand {

	 @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if ("GET".equals(request.getMethod()) ){
	      if (!AuthHelpers.authenticate_admin(request, response)) {
	        response.sendRedirect("/ACSY/index.jsp");
	        return;
	      }
	      AuthHelpers.authenticate_admin(request, response);
	      request.setAttribute("operation", "new_assignment");
	      request.setAttribute("action", "/admins/create_assignment");
	      request.setAttribute("groups", GroupDAO.getInstance().getAllAvailable());
	      request.setAttribute("consultants", ConsultantDAO.getInstance().getAllAvailable());
	      request.getRequestDispatcher(AdminHelpers.new_assignment_path).forward(request, response);
	    }

	  }

}
