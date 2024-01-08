package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("pcategory");
		String manu=request.getParameter("pmanu");
		
		 Cookie[] cookie = request.getCookies();
		 
		 String name=cookie[0].getValue();
		 String cost=cookie[1].getValue();
		 String brand=cookie[2].getValue();
		 String qty=cookie[3].getValue();
		 
		 PrintWriter out=response.getWriter();
			out.println("<body bgcolor='lightgreen'>");
			out.println("<center>");
			out.println("<h1 style='color:cyan; text-align:center;'> REGISTARTION SUCCESS</h1>");
			out.println("<table border='1'>");
			out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		    out.println("<tr><td>PNAME</td><td>"+name+"</td></tr>");
		    out.println("<tr><td>PCOST</td><td>"+cost+"</td></tr>");
		    out.println("<tr><td>PBRAND</td><td>"+brand+"</td></tr>");
		    out.println("<tr><td>PQTY</td><td>"+qty+"</td></tr>");
		    out.println("<tr><td>PCATEGORY</td><td>"+category+"</td></tr>");
		    out.println("<tr><td>PMANUFACTURER</td><td>"+manu+"</td></tr>");
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");
		 
	}

}
