package com.acsy.consultant.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.system.auth.AuthHelpers;

public class DeleteCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){

      if (AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("index.jsp");
        return;
      }

      // Deleting Consultant
      int consultant_id = Integer.parseInt(request.getParameter("consultant_id"));

      ConsultantDAO consultant_dao = ConsultantDAO.getInstance();
      Consultant consultant = consultant_dao.get(consultant_id);
      if(consultant_dao.delete(consultant) != null) {
        //json response soon
        response.sendRedirect("index.jsp");
      } else {
        response.sendRedirect("index.jsp");
      }


    } else {
      response.sendError(400);
    }
  }

}
