package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.general.AbstractCommand;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.system.auth.AuthHelpers;

public class NewCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }
      AuthHelpers.authenticate_admin(request, response);
      request.setAttribute("operation", "new");
      request.setAttribute("action", "/groups/create");
      request.setAttribute("groups", GroupDAO.getInstance().getAll());
      request.getRequestDispatcher(GroupHelpers.new_path).forward(request, response);
    }

  }

}
