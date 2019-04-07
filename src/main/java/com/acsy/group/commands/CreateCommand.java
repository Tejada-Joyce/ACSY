package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.acsy.admin.Admin;
import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.general.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupJSON;
import com.acsy.system.auth.AuthHelpers;

public class CreateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if ("POST".equals(request.getMethod()) ){
		if (!AuthHelpers.authenticate_admin(request, response)) {
			response.sendRedirect("/ACSY/index.jsp");
			return;
		}
		
		Group group = GroupJSON.getInstance().getNewFromString(request.getReader().readLine());	
		GroupDAO group_dao = GroupDAO.getInstance();		
		group = group_dao.save(group);
		// send json with response
		// redirecting for now
		response.setContentType("application/json");
		JSONObject resp = new JSONObject();
		resp.put("message", "Created");
		response.getOutputStream().print(resp.toString());
		//request.setAttribute("notice", "Created succesfully.");
		//request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
		//response.sendRedirect("index");

    } else {
      response.sendError(400);
    }
  }

}
