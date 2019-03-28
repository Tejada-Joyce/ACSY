package com.acsy.client.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.system.auth.AuthHelpers;

public class CreateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if ("POST".equals(request.getMethod()) ){
		if (!AuthHelpers.authenticate_admin(request, response)) {
			response.sendRedirect("index.jsp");
			return;
		}
		// Creating new Client
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		  
		Client client = new Client(first_name, last_name, phone, email);		
		  
		ClientDAO client_dao = ClientDAO.getInstance();
		client_dao.save(client);
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
