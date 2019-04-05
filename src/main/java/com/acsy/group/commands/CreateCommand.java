package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.system.auth.AuthHelpers;

public class CreateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if ("POST".equals(request.getMethod()) ){
		if (!AuthHelpers.authenticate_admin(request, response)) {
			response.sendRedirect("/ACSY/index.jsp");
			return;
		}
		// Creating new Group
		String name = request.getParameter("name");
		
		Group group = new Group();	
		group.setName(name);
		
		GroupDAO group_dao = GroupDAO.getInstance();		
		group = group_dao.save(group);
		// send json with response
		// redirecting for now
		request.setAttribute("notice", "Created succesfully.");
		//request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
		response.sendRedirect("index");

    } else {
      response.sendError(400);
    }
  }

}
