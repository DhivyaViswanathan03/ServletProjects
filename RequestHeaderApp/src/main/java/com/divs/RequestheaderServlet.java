package com.divs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestheaderServlet
 */
@WebServlet("/Test")
public class RequestheaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<h1>HEADER INFORMATION</h1>");
		out.println("<center>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>Header Name</th><th>Header Values</th></tr>");
		Enumeration<String> headers=request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String name=headers.nextElement();
			String value=request.getHeader(name);
			out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
		}
		
		out.println("</body>");
		out.println("</center>");
		out.close();
	}

}
