package com.acsy.group.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.general.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.group.GroupHelpers;
import com.acsy.group.GroupJSON;
import com.acsy.system.auth.AuthHelpers;

public class GetJsonListCommand extends AbstractCommand {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if ("GET".equals(request.getMethod()) ){
      /*if (!AuthHelpers.authenticate_admin(request, response)) {
        response.sendError(401);
        return;
      }*/
      response.setContentType("application/json;charset=UTF-8");
      response.setCharacterEncoding("utf-8");
      ArrayList<Group> groups = (ArrayList<Group>)GroupDAO.getInstance().getAll(); 
      response.getOutputStream().print(GroupJSON.getInstance().getJsonList(groups).toString());
      
    }
  }
}
