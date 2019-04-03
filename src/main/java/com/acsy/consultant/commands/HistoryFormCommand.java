package com.acsy.consultant.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.history.History;
import com.acsy.history.HistoryDAO;
import com.acsy.system.auth.AuthHelpers;

public class HistoryFormCommand extends AbstractCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!AuthHelpers.authenticate_consultant(request, response)) {
			response.sendRedirect("index.jsp");
			return;
		} 
		String[] splitted = request.getRequestURI().split("/");
		String history_id = splitted[splitted.length-1];
		int id = Integer.parseInt(history_id);
		History history = HistoryDAO.getInstance().get(id); 
		request.setAttribute("history", history);
		request.setAttribute("operation", "edit_history");
		request.setAttribute("action", "/histories/update");
		request.getRequestDispatcher(ConsultantHelpers.show_history_path).forward(request, response);
	}

}
