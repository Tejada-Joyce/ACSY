package com.acsy.consultant.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.system.auth.AuthHelpers;

public class IndexCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      if (AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("index.jsp");
        return;
      }
      ArrayList<Consultant> consultants = (ArrayList<Consultant>)ConsultantDAO.getInstance().getAll(); 
      request.setAttribute("consultants", consultants);
      request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
      return;
    }
  }

}
