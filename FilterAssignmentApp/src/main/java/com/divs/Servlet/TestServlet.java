package com.divs.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		Integer eage=Integer.parseInt(request.getParameter("eage"));
		String email=request.getParameter("email");
		String emobile=request.getParameter("emobile");
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:green; text-align:center;'>All fields are validated properly</h1>");
		
	}

}
