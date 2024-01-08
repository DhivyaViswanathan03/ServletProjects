package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static {
    	   System.out.println("servlet class is loading..");
       }
   
    public DemoServlet() {
    	System.out.println("servlet class is instantiated..");
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet class is initialized..");
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("servlet processing is called.....");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet class is de-instantiated..");
	}

}
