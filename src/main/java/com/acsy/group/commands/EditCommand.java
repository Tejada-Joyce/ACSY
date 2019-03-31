package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.client.ClientHelpers;
import com.acsy.group.GroupDAO;
import com.acsy.system.auth.AuthHelpers;

public class EditCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("index.jsp");
        return;
      }
      String[] splitted = request.getRequestURI().split("/");
      String client_id = splitted[splitted.length-1];
      int id = Integer.parseInt(client_id);
      Client client = ClientDAO.getInstance().get(id); 
      request.setAttribute("client", client);
      request.setAttribute("operation", "edit");
      request.setAttribute("action", "/clients/update");
      request.setAttribute("groups", GroupDAO.getInstance().getAll());
      request.getRequestDispatcher(ClientHelpers.edit_path).forward(request, response);
    }
    else {
      response.sendError(400);
    }

  }

}
