package com.divs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		Enumeration<String> paramNames=context.getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String name=paramNames.nextElement();
			String value=context.getInitParameter(name);
			out.println("context name is:"+name);
			out.println("context value is:"+value);
		}
		
		
	}

}
