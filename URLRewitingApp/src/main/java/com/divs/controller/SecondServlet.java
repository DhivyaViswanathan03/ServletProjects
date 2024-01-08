package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountType=request.getParameter("acctype");
		String accountBranch=request.getParameter("accbranch");
		HttpSession session=request.getSession(false);
		session.setAttribute("accountType", accountType);
		session.setAttribute("accountBranch", accountBranch);
		
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='pink'>");
		out.println("<h1 style=color:red; text-align:center;'>DEPOSIT FORM </h1>");
		out.println("<form method='POST' action='"+response.encodeURL("./third")+"'>");
		out.println("<table>");
		out.println("<tr><th>Depositor Name</th><td><input type='text' name='depname'/></td></tr>");
		out.println("<tr><th>Deposit Amount</th><td><input type='text' name='depamount'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.close();
	}

}
