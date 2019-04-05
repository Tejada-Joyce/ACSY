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

      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      // Deleting Consultant
      int id = Integer.parseInt(request.getParameter("consultant_id"));

      ConsultantDAO consultant_dao = ConsultantDAO.getInstance();
      Consultant consultant = consultant_dao.get(id);
      if(consultant_dao.delete(consultant) != null) {
        //json response soon
    	request.setAttribute("notice", "Deleted succesfully.");
        response.sendRedirect("consultants/index");
      } else {
        request.setAttribute("error", "Could not delete consultant, try again.'4");
        request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
      }


    } else {
      response.sendError(400);
    }
  }

}
