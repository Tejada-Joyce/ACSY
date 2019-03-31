package com.acsy.admin.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.assignment.Assignment;
import com.acsy.assignment.AssignmentDAO;
import com.acsy.client.Client;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.system.auth.AuthHelpers;

public class CreateAssignmentCommand extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!AuthHelpers.authenticate_admin(request, response)) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		int group_id = Integer.parseInt(request.getParameter("group_id"));
		int consultant_id = Integer.parseInt(request.getParameter("consultant_id"));
		
		Group group = GroupDAO.getInstance().get(group_id);
		Consultant consultant = ConsultantDAO.getInstance().get(consultant_id);
		Assignment assignment = new Assignment(group, consultant);
		AssignmentDAO.getInstance().save(assignment);
		// redirecting for now
		request.setAttribute("notice", "Created succesfully.");
		//request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
		response.sendRedirect("/ACSY/consultants/index");
	}

}
