package com.divs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("config impl class is:"+getServletConfig().getClass().getName());
		System.out.println("context impl class is:"+getServletContext().getClass().getName());
		System.out.println("Request impl class is:"+request.getClass().getName());
		System.out.println("Response impl class is:"+response.getClass().getName());
	}

	

}
