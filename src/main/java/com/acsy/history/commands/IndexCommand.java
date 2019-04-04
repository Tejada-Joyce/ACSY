package com.acsy.history.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.assignment.Assignment;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.history.HistoryHelpers;
import com.acsy.system.auth.AuthHelpers;

public class IndexCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      if (AuthHelpers.authenticate_admin(request, response)) {
        int consultant_id = Integer.parseInt(request.getParameter("consultant_id"));
        Consultant consultant = ConsultantDAO.getInstance().get(consultant_id);
        request.setAttribute("consultant", consultant);
        request.setAttribute("assignments", consultant.getAssignments());
        request.getRequestDispatcher(HistoryHelpers.index_path).forward(request, response);
        
      }else if(AuthHelpers.authenticate_consultant(request, response)) {
        Consultant consultant = (Consultant)AuthHelpers.getCurrentUser(request, response);
        request.setAttribute("consultant", consultant);
        Predicate<Assignment> incomplete_assignments = element -> !element.isCompleted();
        List<Assignment> assigments = consultant
            .getAssignments()
            .stream()
            .filter(incomplete_assignments)
            .collect(Collectors.toList());
        System.out.println(assigments.size());
        System.out.println(assigments.size());
        System.out.println(assigments.size());
        System.out.println(assigments.size());
        System.out.println(assigments.size());
        System.out.println(assigments.size());
        
        request.setAttribute("assignments", assigments);
        request.getRequestDispatcher(HistoryHelpers.index_path).forward(request, response);
      } else {
        response.sendError(401);
      }
      
    }
  }

}
