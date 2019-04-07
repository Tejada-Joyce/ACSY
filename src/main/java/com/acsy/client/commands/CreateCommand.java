package com.acsy.client.commands;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acsy.client.Client;
import com.acsy.client.ClientDAO;
import com.acsy.consultant.Consultant;
import com.acsy.general.AbstractCommand;
import com.acsy.group.Group;
import com.acsy.group.GroupDAO;
import com.acsy.system.auth.AuthHelpers;

public class CreateCommand extends AbstractCommand{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if ("POST".equals(request.getMethod()) ){
		if (!AuthHelpers.authenticate_admin(request, response)) {
			response.sendRedirect("/ACSY/index.jsp");
			return;
		}
		// Creating new Client
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");				
		int group_id = Integer.parseInt(request.getParameter("group_id"));
		
		Group group = GroupDAO.getInstance().get(group_id);
		
		Client client = new Client(first_name, last_name, phone, email, group);		
 
		ClientDAO client_dao = ClientDAO.getInstance();
		client_dao.save(client);
		sendEmail(client);
		// send json with response
		// redirecting for now
		request.setAttribute("notice", "Created succesfully.");
		//request.getRequestDispatcher(ConsultantHelpers.index_path).forward(request, response);
		response.sendRedirect("index");

    } else {
      response.sendError(400);
    }
  }
  
  private void sendEmail(Client client) {
		
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


					message.setSubject("New Client Registered");
				
					String msg = "A new client was created with the following information:\n\n" + client;

					MimeBodyPart mimeBodyPart = new MimeBodyPart();
					mimeBodyPart.setContent(msg, "text/plain");

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
