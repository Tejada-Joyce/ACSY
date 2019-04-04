package com.acsy.client.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.client.ClientHelpers;
import com.acsy.system.auth.AuthHelpers;

public class DeleteCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){

      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("index.jsp");
        return;
      }

      // Deleting Client
      String[] splitted = request.getRequestURI().split("/");
      String client_id = splitted[splitted.length-1];
      int id = Integer.parseInt(client_id);

      ClientDAO client_dao = ClientDAO.getInstance();
      Client client = client_dao.get(id);
      if(client_dao.delete(client) != null) {
        //json response soon
        response.sendRedirect("clients/index");
      } else {
    	  System.out.println(request.getContextPath()+ClientHelpers.index_path);
    	  System.out.println(request.getContextPath()+ClientHelpers.index_path);
    	  System.out.println(request.getContextPath()+ClientHelpers.index_path);
    	  System.out.println(request.getContextPath()+ClientHelpers.index_path);
        request.setAttribute("error", "Could not delete client, try again.'4");
        request.getRequestDispatcher(request.getContextPath()+ClientHelpers.index_path).forward(request, response);
      }


    } else {
      System.out.println("Your request could not be processed.");
      System.out.println("Your request could not be processed.");
      System.out.println("Your request could not be processed.");
      System.out.println("Your request could not be processed.");
      response.sendError(400);
    }
  }

}
