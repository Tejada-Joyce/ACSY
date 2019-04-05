package com.acsy.history.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.assignment.Assignment;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.general.AbstractCommand;
import com.acsy.history.History;
import com.acsy.history.HistoryDAO;
import com.acsy.system.auth.AuthHelpers;

public class UpdateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_consultant(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      int history_id = Integer.parseInt(request.getParameter("history_id"));
      String description = request.getParameter("description");
      int rate = Integer.parseInt(request.getParameter("rate"));

      History history = HistoryDAO.getInstance().get(history_id);
      Consultant consultant = history.getAssignment().getConsultant();
      Consultant current_user = (Consultant) AuthHelpers.getCurrentUser(request, response);
      if (consultant.getId() == current_user.getId()) {
        history.setDescription(description);
        history.setRate(rate);
        if (HistoryDAO.getInstance().update(history) != null) {
          request.setAttribute("notice", "Updated succesfully.");
          response.sendRedirect("/ACSY/histories/index");
        } else {
          request.setAttribute("error", "Could not update consultant, try again.");
          response.sendRedirect("/ACSY/histories/index");
        }
      } else {
        response.sendError(401);
      }
      


    } else {
      response.sendError(400);
    }

  }

}
