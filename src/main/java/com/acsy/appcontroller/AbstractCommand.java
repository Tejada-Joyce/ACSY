package com.acsy.appcontroller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractCommand {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException ;
}
