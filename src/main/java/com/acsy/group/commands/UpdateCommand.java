package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.client.ClientHelpers;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.system.auth.AuthHelpers;

public class UpdateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      // Update Group
      
      String name = request.getParameter("name");
		
      Group group = new Group();      
  
      group.setName(name);

      if(GroupDAO.getInstance().update(group) != null) {
        // send json with response
        // redirecting for now
        request.setAttribute("notice", "Updated succesfully.");
        response.sendRedirect("/ACSY/groups/index");
      } else {
        // send json with response
        // redirecting for now
        request.setAttribute("error", "Could not update group, try again.");
        request.getRequestDispatcher(GroupHelpers.index_path).forward(request, response);
      }



    } else {
      response.sendError(400);
    }

  }

}
