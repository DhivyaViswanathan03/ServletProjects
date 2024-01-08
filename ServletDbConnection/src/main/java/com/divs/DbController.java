package com.divs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded...");
		} catch (ClassNotFoundException e) {

		}
	}

	@Override
	public void init() {

		String url = getInitParameter("url");
		String user = getInitParameter("username");
		String password = getInitParameter("password");

		System.out.println("URL is:" + url);
		System.out.println("Username is:" + user);
		System.out.println("password is :" + password);
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection established...");
			if (connection != null) {
				System.out.println("connction is established");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select id,name,age,address from student");
			out.println("<center><h1>STUDENT DATABASE</h1></center>");
			out.println("<center>");
			out.println("<body>");
			out.println("<table border='1' text-align='center'>");
			out.println("<tr><th>ID</th><th>NAME</th><th>AGE</th><th>ADDRESS</th></tr>");

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String address = rs.getString(4);
				out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + address
						+ "</td></tr>");

			}
			out.println("</body>");
			out.println("</center>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
