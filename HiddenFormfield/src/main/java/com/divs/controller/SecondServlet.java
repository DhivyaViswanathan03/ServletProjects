package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sgender=request.getParameter("sgender");
		String saddr=request.getParameter("saddr");
		String sname=request.getParameter("sname");
		String sage=request.getParameter("sage");
		PrintWriter out=response.getWriter();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>WELCOME INEURON INTELLIGENCE</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><td>"+sname+"</td></tr>");
		out.println("<tr><th>AGE</th><td>"+sage+"</td></tr>");
		out.println("<tr><th>GENDER</th><td>"+sgender+"</td></tr>");
		out.println("<tr><th>ADDRESS</th><td>"+saddr+"</td></tr>");
		out.println("</table>");
	    out.println("</center>");
		out.println("</body>");
	}

}
