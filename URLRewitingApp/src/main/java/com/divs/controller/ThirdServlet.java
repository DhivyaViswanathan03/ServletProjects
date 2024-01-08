package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depName=request.getParameter("depname");
		String depAmount=request.getParameter("depamount");
		HttpSession session=request.getSession(false);
		session.setAttribute("depName", depName);
		session.setAttribute("depAmount", depAmount);
		
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='pink'>");
		out.println("<h1 style='color:red; text-align:center;'>Details about banking... </h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> elements=session.getAttributeNames();
		while(elements.hasMoreElements()) {
			String attributeName=elements.nextElement();
			String attributeValue=(String) session.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.close();
	}

}
