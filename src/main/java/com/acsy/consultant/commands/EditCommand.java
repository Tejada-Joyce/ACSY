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

public class EditCommand extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod()) ){
			AuthHelpers.authenticate_admin(request, response);
			int consultant_id = Integer.parseInt(request.getParameter("consultant_id"));
			Consultant consultant = ConsultantDAO.getInstance().get(consultant_id); 
			request.setAttribute("consultant", consultant);
			request.getRequestDispatcher(ConsultantHelpers.edit_path).forward(request, response);
		}
		
	}

}
