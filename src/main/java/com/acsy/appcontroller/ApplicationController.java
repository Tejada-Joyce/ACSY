package com.acsy.appcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.acsy.client.ClientCommand;


public class ApplicationController {
	
	private static Logger logger = Logger.getLogger(ApplicationController.class);
    private final String PAGE_ERROR = "/pageError.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Class> map;
    private String key;
    
    public ApplicationController(HttpServletRequest request, HttpServletResponse  response){

		//On our example, only PDF and JPG is acepted to download.
		this.map = new HashMap<String, Class>();
		//this.map.put("admins", PdfCommand.class);
		//this.map.put("consultants", PdfCommand.class);
		this.map.put("clients", ClientCommand.class);
		//this.map.put("groups", PdfCommand.class);
		//this.map.put("histories", PdfCommand.class);
		//this.map.put("auth", PdfCommand.class);
		
		this.request = request;
		this.response = response;
		
	}
    
    public void process(){

        //Processes the URI and creates the key using URI.
        this.processUri();

         //Validates if the request is valid.
         if (!validate()) {
             try {
                 response.sendError(400);
             } catch (IOException e1) {
                 logger.error(e1.getMessage());
             }

             return;
         }

        //Get the correspondent command.
        Class commandClass = map.get(key);

        boolean error = false;

        try {

             AbstractCommand command = (AbstractCommand) 
             commandClass.newInstance();

             //Executes the command.
             command.execute(request,response);

         } catch (InstantiationException e) {
             logger.error(e.getMessage());
             error = true;

         } catch (IllegalAccessException e) {
             logger.error(e.getMessage());
             error = true;

         } catch (ServletException e) {
             logger.error(e.getMessage());
             error = true;
         } catch (IOException e) {
             logger.error(e.getMessage());
             error = true;
         }


         //If an error ocorred, response 500.
         if(error){
              try {
                  response.sendError(500);

              } catch (IOException e1) {
                  logger.error(e1.getMessage());
                  return;
              }
         }


     }
    
    /*private methods*/
    
    private void processUri(){

        String uri = request.getRequestURI();
        if(uri.startsWith("/")) uri = uri.replaceFirst("/", "");
        String[] uriSplitted = uri.split("/");

        if(uriSplitted.length > 2)
            key = uriSplitted[2].toUpperCase();
    }
    
    private boolean validate(){

        String uri = request.getRequestURI();
        if(uri.startsWith("/")) uri = uri.replaceFirst("/", "");
        String[] uriSplitted = uri.split("/");

        return uriSplitted.length == 3 && map.containsKey(key);
    }

}
