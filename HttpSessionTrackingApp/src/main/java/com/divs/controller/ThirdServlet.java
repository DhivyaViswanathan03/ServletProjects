package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobile=request.getParameter("smobile");
		String email=request.getParameter("semail");
		HttpSession session=request.getSession(false);
		session.setAttribute("MOBILE", mobile);
		session.setAttribute("EMAIL",email);
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<center>");
		out.println("<h1 style='color:cyan; text-align:center;'> REGISTARTION SUCCESS</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> elements=session.getAttributeNames();
		while(elements.hasMoreElements()) {
			String attributeName=elements.nextElement();
			Object attributeValue=session.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		System.out.println("Request SessionId: "+request.getRequestedSessionId());
	}

}
