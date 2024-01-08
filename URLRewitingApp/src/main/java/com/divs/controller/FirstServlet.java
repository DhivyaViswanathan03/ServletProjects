package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNo=request.getParameter("accno");
		String accountName=request.getParameter("accname");
		HttpSession session=request.getSession();
		session.setAttribute("accountNo", accountNo);
		session.setAttribute("accountName", accountName);
		
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='pink'>");
		out.println("<h1 style=color:red; text-align:center;'>DEPOSIT FORM </h1>");
		out.println("<form method='POST' action='"+response.encodeURL("./second")+"'>");
		out.println("<table>");
		out.println("<tr><th>Account Type</th><td><input type='text' name='acctype'/></td></tr>");
		out.println("<tr><th>Account Branch</th><td><input type='text' name='accbranch'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.close();
	}

}
