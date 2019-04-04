package com.acsy.group;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GroupFrontController", urlPatterns = "/groups/*")
public class GroupFrontController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public GroupFrontController() {
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
    System.out.println(request.getRequestURI());
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
    System.out.println(request.getRequestURI());

    if(true)
      new GroupApplicationController(request, response).process();
    else
      response.sendError(401);

  }

}