package com.acsy.group.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.client.ClientHelpers;
import com.acsy.system.auth.AuthHelpers;

public class IndexCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/index.jsp");
        return;
      }
      ArrayList<Client> clients = (ArrayList<Client>)ClientDAO.getInstance().getAll(); 
      request.setAttribute("clients", clients);
      request.getRequestDispatcher(ClientHelpers.index_path).forward(request, response);
      return;
    }
  }

}
