package com.acsy.consultant;

public class ConsultantHelpers {
  
	// https://stackoverflow.com/questions/25677974/requestdispatcher-forwarding-is-getting-rerouted-back-to-the-same-servlet
	public static final String index_path = "/WEB-INF/jsp/consultants/index.jsp";
	public static final String new_path = "/WEB-INF/jsp/consultants/new.jsp";
	public static final String edit_path = "/WEB-INF/jsp/consultants/edit.jsp";
	public static final String show_path = "/WEB-INF/jsp/consultants/show.jsp";
	
	// Verifies if password and password confirm matchs
	public static boolean is_valid(Consultant consultant){
		if(
			consultant.getPassword().length() > 5 &&
			(consultant.getPassword().length() == consultant.getPasswordConfirm().length()) &&
			consultant.getPassword().equals(consultant.getPasswordConfirm()) ) {
			return true;
		}
		return false;
	}
	
	
}
