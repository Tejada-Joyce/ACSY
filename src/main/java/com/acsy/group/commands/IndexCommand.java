package com.acsy.group.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.system.auth.AuthHelpers;

public class IndexCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/index.jsp");
        return;
      }
      ArrayList<Group> groups = (ArrayList<Group>)GroupDAO.getInstance().getAll(); 
      request.setAttribute("groups", groups);
      request.getRequestDispatcher(GroupHelpers.index_path).forward(request, response);
      return;
    }
  }

}
