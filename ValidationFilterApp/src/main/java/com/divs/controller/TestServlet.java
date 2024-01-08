package com.divs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divs.Dto.Employee;
import com.divs.dao.EmployeeDaoImpl;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String eage=request.getParameter("eage");
		String email=request.getParameter("email");
		String emobile=request.getParameter("emobile");
		
		Employee employee=new Employee();
		employee.setEid(eid);
		employee.setEname(ename);
		employee.setEage(Integer.parseInt(eage));
		employee.setEmail(email);
		employee.setEmobile(emobile);
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
				String output=dao.insert(employee);
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green; text-align:center;'>Employee Registration Details</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>EID</th><td>"+eid+"</td></tr");
		out.println("<tr><th>ENAME</th><td>"+ename+"</td></tr");
		out.println("<tr><th>EAGE</th><td>"+eage+"</td></tr");
		out.println("<tr><th>EMAIL</th><td>"+email+"</td></tr");
		out.println("<tr><th>EMOBILE</th><td>"+emobile+"</td></tr");
		out.println("<tr><th>RESULT</th><td>"+output+"</td></tr");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}









