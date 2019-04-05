package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.system.auth.AuthHelpers;

public class EditCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }
      
      int id = Integer.parseInt(request.getParameter("group_id"));
      Group group = GroupDAO.getInstance().get(id); 
      request.setAttribute("group", group);
      request.setAttribute("operation", "edit");
      request.setAttribute("action", "/groups/update");
      //request.setAttribute("groups", GroupDAO.getInstance().getAll());
      request.getRequestDispatcher(GroupHelpers.edit_path).forward(request, response);
    }
    else {
      response.sendError(400);
    }

  }

}
