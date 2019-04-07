package com.acsy.group.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.acsy.general.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.group.GroupJSON;
import com.acsy.system.auth.AuthHelpers;

public class DeleteCommand extends AbstractCommand {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("POST".equals(request.getMethod()) ){

      if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendRedirect("/ACSY/index.jsp");
        return;
      }

      Group group = GroupJSON.getInstance().getExistentFromStringId(request.getReader().readLine());
      if(GroupDAO.getInstance().delete(group) != null) {
        //json response soon
        response.setContentType("application/json");
        JSONObject resp = new JSONObject();
        resp.put("message", "Group was deleted successfully.");
        response.getOutputStream().print(resp.toString());
      } else {
        response.setContentType("application/json");
        JSONObject resp = new JSONObject();
        resp.put("message", "Could not delete group, try again.");
        response.getOutputStream().print(resp.toString());
      }

    } else {
      response.sendError(400);
    }
  }

}
