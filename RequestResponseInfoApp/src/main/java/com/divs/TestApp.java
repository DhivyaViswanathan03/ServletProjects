package com.divs;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Demo")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDateTime date = LocalDateTime.now();
		int h = date.getHour();
		String msg="";
		if(h<12) {
			msg+="Good Morning";
		}else if(h<16) {
			msg+="Good Noon";
		}else if(h<20) {
			msg+="Good Evening";
		}else {
			msg+="Good Night";
		}
		
		PrintWriter out=response.getWriter();
		out.println("Request thread:"+request.hashCode());
		out.println("Response Theread:"+response.hashCode());
		out.println("Current Servlet Thread:"+this.hashCode());
		out.println("Executing thread:"+Thread.currentThread().hashCode());
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.close();
	}

}
