package com.acsy.appcontroller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(
		name = "FrontController", 
		urlPatterns = {
				"/admins/*",
				"/clients/*",
				"/groups/*",
				"/consultants/*",
				"/histories/*"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, java.io.IOException {
		
		// If user is logged the request is sent to 
		// ApplicationController,
		// then one error 401 is sent to client.
		if(Objects.nonNull(request.getSession().getAttribute("USER"))) {
		
		//Send the request to ApplicationController
		//new ApplicationController(request, response).process();
		
		}
		
		else {
		response.sendError(401);
		}
		}

}
