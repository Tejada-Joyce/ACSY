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

public class UpdateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("index.jsp");
        return;
      }

      // Creating new Client
      int client_id = Integer.parseInt(request.getParameter("client_id"));
      String first_name = request.getParameter("first_name");
      String last_name = request.getParameter("last_name");
      String phone = request.getParameter("phone");
      String email = request.getParameter("email");

      Client client = ClientDAO.getInstance().get(client_id);
      client.setFirstName(first_name);
      client.setLastName(last_name);
      client.setPhone(phone);
      client.setEmail(email);

      if(ClientDAO.getInstance().update(client) != null) {
        // send json with response
        // redirecting for now
        request.setAttribute("notice", "Updated succesfully.");
        response.sendRedirect("/ACSY/clients/index");
      } else {
        // send json with response
        // redirecting for now
        request.setAttribute("error", "Could not update client, try again.");
        request.getRequestDispatcher(ClientHelpers.index_path).forward(request, response);
      }



    } else {
      response.sendError(400);
    }

  }

}
