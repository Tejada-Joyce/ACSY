package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.client.ClientHelpers;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.general.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.group.GroupJSON;
import com.acsy.system.auth.AuthHelpers;

public class UpdateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){
      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      Group group =  GroupJSON.getInstance().getExistentFromString(request.getReader().readLine());
      
      if(GroupDAO.getInstance().update(group) != null) {
        // send json with response
        // redirecting for now
        response.setContentType("application/json");
        JSONObject resp = new JSONObject();
        resp.put("message", "Group was updated successfully.");
        response.getOutputStream().print(resp.toString());
      } else {
        // send json with response
        // redirecting for now
        response.setContentType("application/json");
        JSONObject resp = new JSONObject();
        resp.put("message", "Something went wrong.");
        response.getOutputStream().print(resp.toString());
      }



    } else {
      response.sendError(400);
    }

  }

}
