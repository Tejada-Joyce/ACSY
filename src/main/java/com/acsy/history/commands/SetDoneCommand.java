package com.acsy.history.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.assignment.AssignmentDAO;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.general.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.history.History;
import com.acsy.history.HistoryDAO;
import com.acsy.history.HistoryHelpers;
import com.acsy.system.auth.AuthHelpers;

public class SetDoneCommand extends AbstractCommand {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_consultant(request, response)) {
        response.sendError(401);
        return;
      }

      int history_id = Integer.parseInt(request.getParameter("history_id"));
      History history = HistoryDAO.getInstance().get(history_id);
      Consultant consultant = history.getAssignment().getConsultant();
      Consultant current_user = (Consultant) AuthHelpers.getCurrentUser(request, response);
      if (consultant.getId() == current_user.getId()) {
        history.setDone(true);
        if(history.wasDone() || (history.wasDone() == history.isDone())) return;
        if(!history.wasDone() && history.isDone()) {
          int counter = history.getAssignment().getHistoriesCounter();
          history.getAssignment().setHistoriesCounter(counter+1);
          if(history.getAssignment().getHistoriesCounter() == history.getAssignment().getTotalHistories()) {
            history.getAssignment().setCompleted(true);
            Group group = history.getAssignment().getGroup();
            group.setStatus(true);
            GroupDAO.getInstance().update(group);
            history.getAssignment().setGroup(group);
            history.getAssignment().getConsultant().setStatus(true);
            ConsultantDAO.getInstance().update(history.getAssignment().getConsultant());
          }
        }
        if (HistoryDAO.getInstance().update(history) != null) {
          AssignmentDAO.getInstance().update(history.getAssignment());
          response.sendRedirect("/ACSY/histories/index");
          return;
        } else {
          response.sendError(400);
        }
      }
      response.sendError(401);
      
    } else {
      response.sendError(400);
    }
  }
}
