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

public class UpdateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      // Updating Consultant
      int consultant_id = Integer.parseInt(request.getParameter("consultant_id"));
      String first_name = request.getParameter("first_name");
      String last_name = request.getParameter("last_name");
      String phone = request.getParameter("phone");
      String email = request.getParameter("email");

      Consultant consultant = ConsultantDAO.getInstance().get(consultant_id);
      consultant.setFirstName(first_name);
      consultant.setLastName(last_name);
      consultant.setPhone(phone);
      consultant.setEmail(email);

      if(ConsultantDAO.getInstance().update(consultant) != null) {
        // send json with response
        // redirecting for now
        request.setAttribute("notice", "Updated succesfully.");
        response.sendRedirect("/ACSY/consultants/index");
      } else {
        // send json with response
        // redirecting for now
        request.setAttribute("error", "Could not update consultant, try again.");
        request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
      }



    } else {
      response.sendError(400);
    }

  }

}
