package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String sage=request.getParameter("sage");
		PrintWriter out=response.getWriter();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>WELCOME INEURON INTELLIGENCE</h1>");
		out.println("<form method='post' action='./second'>");
		out.println("<table>");
		out.println("<tr><td><input type='hidden' name='sname' value='sname'/></td></tr>");
		out.println("<tr><td><input type='hidden' name='sage' value='sage'/></td></tr>");
		out.println("<tr><th>SGENDER</th><td><input type='text' name='sgender'/></td></tr>");
		out.println("<tr><th>SADDR</th><td><input type='text' name='saddr'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		
	}

}
