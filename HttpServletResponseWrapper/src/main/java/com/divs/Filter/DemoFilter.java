package com.divs.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.divs.controller.CustomizedResponse;


@WebFilter("/test")
public class DemoFilter implements Filter {

	
    public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter before processing..");
		HttpServletResponse res=(HttpServletResponse) response;
		CustomizedResponse customResponse=new CustomizedResponse(res);
		chain.doFilter(request, customResponse);
		 String servletResponse = new String(customResponse.toString());
		System.out.println("filter After processing..");
		System.out.println("after filter value is:"+servletResponse);
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>"+servletResponse+"</h1>");
		
	
		
	}

    public void destroy() {
		
	}
	
	

}
