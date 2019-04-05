package com.acsy.client.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.client.ClientHelpers;
import com.acsy.group.Group;
import com.acsy.general.AbstractCommand;
import com.acsy.group.GroupDAO;
import com.acsy.system.auth.AuthHelpers;

public class EditCommand extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("POST".equals(request.getMethod()) ){
			if (!AuthHelpers.authenticate_admin(request, response)) {
				response.sendRedirect("/ACSY/index.jsp");
				return;
			}

			int id = Integer.parseInt(request.getParameter("client_id"));
			Client client = ClientDAO.getInstance().get(id); 
			List<Group> groups = GroupDAO.getInstance().getAll();

			request.setAttribute("client", client);
			request.setAttribute("operation", "edit");
			request.setAttribute("action", "/clients/update");
			request.setAttribute("groups", groups);
			request.getRequestDispatcher(ClientHelpers.edit_path).forward(request, response);
			return;		

		}
		else {
			response.sendError(400);
		}

	}

}
