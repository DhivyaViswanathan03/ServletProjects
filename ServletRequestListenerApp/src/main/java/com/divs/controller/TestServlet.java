package com.divs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divs.Listener.RequestDemoListener;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static{
	System.out.println("TestServlet is loading..");
}
      public TestServlet() {

System.out.println("TestServlet is instantiated...");
}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TestServlet is called..");
		System.out.println("Servlet hit count is::"+RequestDemoListener.count);
		System.in.read();
	}

}
