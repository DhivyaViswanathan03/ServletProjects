package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet class is called...");
		String name=request.getParameter("sname");
		String temp="";
		for(int i=name.length()-1;i>=0;i--) {
			temp=temp+name.charAt(i);
		}
		PrintWriter res = response.getWriter();
		res.println(temp);
	
	
	}

}
