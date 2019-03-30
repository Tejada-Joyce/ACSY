package com.acsy.history.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
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
      String consultant_id = splitted[splitted.length-1];
      int id = Integer.parseInt(consultant_id);
      Consultant consultant = ConsultantDAO.getInstance().get(id); 
      request.setAttribute("consultant", consultant);
      request.setAttribute("operation", "edit");
      request.setAttribute("action", "/consultants/update");
      request.getRequestDispatcher(ConsultantHelpers.edit_path).forward(request, response);
    }
    else {
      response.sendError(400);
    }

  }

}
