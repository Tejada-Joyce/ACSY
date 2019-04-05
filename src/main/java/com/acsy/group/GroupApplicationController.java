package com.acsy.group;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.acsy.general.AbstractCommand;
import com.acsy.group.commands.*;

public class GroupApplicationController {
	private static Logger logger = Logger.getLogger(GroupApplicationController.class);
    private final String PAGE_ERROR = "/pageError.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Class> map;
    private String key;
    
    public GroupApplicationController(HttpServletRequest request, HttpServletResponse  response){

		this.map = new HashMap<String, Class>();
		
		this.map.put("INDEX", IndexCommand.class);
		this.map.put("NEW", NewCommand.class);
		this.map.put("CREATE", CreateCommand.class);
		this.map.put("DELETE", DeleteCommand.class);
		this.map.put("EDIT", EditCommand.class);
		this.map.put("UPDATE", UpdateCommand.class);
		this.map.put("GET_JSON_LIST", GetJsonListCommand.class);
		
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

             AbstractCommand command = (AbstractCommand) commandClass.newInstance();

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


         //If an error occurred, response 500.
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
        Arrays.stream(uriSplitted).forEach(System.out::println);

        if(uriSplitted.length > 2)
            key = uriSplitted[2].toUpperCase();
    }
    
    private boolean validate(){

        String uri = request.getRequestURI();
        if(uri.startsWith("/")) uri = uri.replaceFirst("/", "");
        String[] uriSplitted = uri.split("/");

        return (uriSplitted.length == 3 || uriSplitted.length == 4) && map.containsKey(key);
    }
}
