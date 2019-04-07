package com.acsy.history;

import java.util.ArrayList;
import java.util.List;

import com.acsy.assignment.Assignment;

public class HistoryHelpers {
  
	// https://stackoverflow.com/questions/25677974/requestdispatcher-forwarding-is-getting-rerouted-back-to-the-same-servlet
	public static final String index_path = "/WEB-INF/jsp/histories/index.jsp";
	public static final String new_path = "/WEB-INF/jsp/histories/new.jsp";
	public static final String edit_path = "/WEB-INF/jsp/histories/edit.jsp";
	public static final String show_path = "/WEB-INF/jsp/histories/show.jsp";
	
	public static boolean is_inside(Assignment assignment) {
	  List<History> histories = assignment.getHistories();
	  return false;
	}
		
}
