package com.acsy.system.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acsy.admin.Admin;
import com.acsy.admin.AdminDAO;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;


/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		AdminDAO ad = AdminDAO.getInstance();
		Admin admin = ad.validate(email, password);
		ConsultantDAO cd = ConsultantDAO.getInstance();
		Consultant cons = cd.validate(email, password);
		if (admin != null) {
	      HttpSession session=request.getSession();  	      
	      session.setAttribute("user_id", admin.getId());
	      session.setAttribute("type", "admin");
	      session.setAttribute("active", true);
	      request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (cons != null) {			 
	      HttpSession session=request.getSession();  	      
	      session.setAttribute("user_id", cons.getId());
	      session.setAttribute("type", "cons");
	      session.setAttribute("active", true);
	      request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
	      request.setAttribute("error", "INVALID CREDENTIALS");
	      request.getRequestDispatcher("index.jsp").forward(request, response);
	      System.out.println(request.getRequestURI());
	      System.out.println(request.getRequestURI());
	      System.out.println(request.getRequestURI());
	      
		}
		
	}

}
