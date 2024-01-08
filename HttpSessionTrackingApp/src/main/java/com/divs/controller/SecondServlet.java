package com.divs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qualification=request.getParameter("squal");
		String designation=request.getParameter("sdesg");
		HttpSession session=request.getSession(false);
		session.setAttribute("QUALIFICATION", qualification);
		session.setAttribute("DESIGNATION",designation);
		
		RequestDispatcher rd=request.getRequestDispatcher("./form3.html");
		rd.forward(request, response);
	}

}
