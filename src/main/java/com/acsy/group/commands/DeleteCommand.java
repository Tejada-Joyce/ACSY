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

public class DeleteCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){

      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      // Deleting Client
      String[] splitted = request.getRequestURI().split("/");
      String group_id = splitted[splitted.length-1];
      int id = Integer.parseInt(group_id);

      GroupDAO group_dao = GroupDAO.getInstance();
      Group group = group_dao.get(id);
      if(group_dao.delete(group) != null) {
        //json response soon
        response.sendRedirect("groups/index");
      } else {
    	  System.out.println(request.getContextPath()+GroupHelpers.index_path);
    	  System.out.println(request.getContextPath()+GroupHelpers.index_path);
    	  System.out.println(request.getContextPath()+GroupHelpers.index_path);
    	  System.out.println(request.getContextPath()+GroupHelpers.index_path);
        request.setAttribute("error", "Could not delete group, try again.'4");
        request.getRequestDispatcher(request.getContextPath()+GroupHelpers.index_path).forward(request, response);
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
