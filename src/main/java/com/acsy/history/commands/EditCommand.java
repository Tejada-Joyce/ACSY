package com.acsy.history.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.assignment.Assignment;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.history.History;
import com.acsy.history.HistoryDAO;
import com.acsy.history.HistoryHelpers;
import com.acsy.system.auth.AuthHelpers;

public class EditCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_consultant(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }
      int id = Integer.parseInt(request.getParameter("history_id"));
      History history = HistoryDAO.getInstance().get(id);
      Assignment assignment = history.getAssignment();
      Consultant consultant = assignment.getConsultant();
      Consultant current_user = (Consultant)AuthHelpers.getCurrentUser(request, response); 
      if(current_user.getId() == consultant.getId()) {
        request.setAttribute("history", history);
        request.setAttribute("operation", "edit");
        request.setAttribute("action", "/histories/update");
        request.getRequestDispatcher(HistoryHelpers.edit_path).forward(request, response);
        return;
      }
      response.sendError(401);
      
    }
    else {
      response.sendError(400);
    }

  }

}
