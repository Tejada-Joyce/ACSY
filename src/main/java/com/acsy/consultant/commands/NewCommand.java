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
      request.setAttribute("action", "/consultants/create");
      request.getRequestDispatcher(ConsultantHelpers.new_path).forward(request, response);
    }

  }

}
