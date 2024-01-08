package com.divs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test" }, 
       initParams = { @WebInitParam(name = "url", value = "jdbc:mysql:///divs"),
		@WebInitParam(name = "username", value = "root"),
		@WebInitParam(name = "password", value = "Welcome@123") }, 
       loadOnStartup = 10)
   public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private PreparedStatement pstmt=null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded ...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		String url=getInitParameter("url");
		String username=getInitParameter("username");
		String password=getInitParameter("password");
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection established...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if(connection!=null) {
			String insertQuery="insert into student(`name`,`age`,`address`) values(?,?,?)";
			try {
				pstmt=connection.prepareStatement(insertQuery);
				if(pstmt!=null) {
					
					pstmt.setString(1, request.getParameter("sname"));
					pstmt.setInt(2, Integer.parseInt(request.getParameter("sage")));
					pstmt.setString(3, request.getParameter("saddr"));
					int rowCount=pstmt.executeUpdate();
					response.setContentType("text/html");
					if(rowCount==1) {
						out.println("<center><h1 style='color:green; text-align:center;'>Inserted successfully..</h1></center>");
						
					}else {
						out.println("<center><h1 style='red; text-align:center;'>Failed..Pls try again..</h1></center>");
						out.println("<a href='./reg.html'>[REGISTRATION[</a>");
					}
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void destroy() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
