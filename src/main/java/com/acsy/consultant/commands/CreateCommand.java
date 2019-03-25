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

public class CreateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if ("POST".equals(request.getMethod()) ){
      if (AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("index.jsp");
        return;
      }

      // Creating new Consultant
      String first_name = request.getParameter("first_name");
      String last_name = request.getParameter("last_name");
      String phone = request.getParameter("phone");
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String password_confirm = request.getParameter("password_confirm");

      Consultant consultant = new Consultant(first_name, last_name, phone, email, password, password_confirm);

      if(ConsultantHelpers.is_valid(consultant)) {
        ConsultantDAO consultant_dao = ConsultantDAO.getInstance();
        consultant_dao.save(consultant);
        // send json with response
        // redirecting for now
        response.sendRedirect("index.jsp");

      } else {
        response.sendRedirect("index.jsp");
      }


    } else {
      response.sendError(400);
    }
  }

}
