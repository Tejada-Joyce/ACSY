package com.acsy.consultant.commands;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.appcontroller.AbstractCommand;
import com.acsy.consultant.Consultant;
import com.acsy.consultant.ConsultantDAO;
import com.acsy.consultant.ConsultantHelpers;
import com.acsy.system.auth.AuthHelpers;

public class CreateCommand extends AbstractCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if ("POST".equals(request.getMethod()) ){
			if (!AuthHelpers.authenticate_admin(request, response)) {
				response.sendRedirect("index.jsp");
				return;
			}

			// Creating new Consultant
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String password_confirm = request.getParameter("password_confirm");

			Consultant consultant = new Consultant(first_name, last_name, phone, email, password, password_confirm);

			if(ConsultantHelpers.is_valid(consultant)) {
				ConsultantDAO consultant_dao = ConsultantDAO.getInstance();
				consultant = consultant_dao.save(consultant);
				if (consultant == null) {
					request.setAttribute("error", "Could not create consultant.");
					request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
					return;
				} 
				sendEmail(consultant);
				
				// send json with response
				// redirecting for now
				request.setAttribute("notice", "Created succesfully.");
				//request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
				response.sendRedirect("index");

			} else {
				request.setAttribute("error", "Could not create consultant.");
				request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
			}


		} else {
			response.sendError(400);
		}
	}

	private void sendEmail(Consultant consultant) {
		
		try {
			ExecutorService executor = Executors.newFixedThreadPool(1);	

			Runnable task = () -> {
				Properties props = System.getProperties();
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", "587"); 
				props.put("mail.smtp.starttls.enable", "true"); 

				Session session = Session.getDefaultInstance(props, null);

				try {

					Message message = new MimeMessage(session);
					message.addRecipient(Message.RecipientType.TO, new InternetAddress("acsy.ceo@gmail.com"));


					message.setSubject("New Consultant Created");
				
					String msg = "A new consultant was created with the following information:\n\n" + consultant;

					MimeBodyPart mimeBodyPart = new MimeBodyPart();
					mimeBodyPart.setContent(msg, "text/html");

					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(mimeBodyPart);

					message.setContent(multipart);

					Transport transport = session.getTransport("smtp");
					transport.connect("smtp.gmail.com", "acsy.information@gmail.com", "ACSYproject");
					transport.sendMessage(message, message.getAllRecipients());
					transport.close();

					System.out.println("Sent");
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}         
			};
			executor.execute(task);


		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


}
