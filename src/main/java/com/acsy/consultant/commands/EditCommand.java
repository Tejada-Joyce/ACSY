package com.acsy.consultant.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.general.AbstractCommand;
import com.acsy.system.auth.AuthHelpers;

public class EditCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }
      
      int id = Integer.parseInt(request.getParameter("consultant_id"));
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
