package com.divs.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class LogFilter implements Filter {
       static {
    	   System.out.println("LogFilter class is loading....");
       }
  
    public LogFilter() {
    	System.out.println("LogFilter class is Instantiated....");
    }

    @Override
public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("LogFilter class is Initialized....");
	}
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out=response.getWriter();
		out.println("LogFilter called before processing the request");
		chain.doFilter(request, response);
		out.println("LogFilter called after processing the request");
	}

	
	@Override
public void destroy() {
	System.out.println("LogFilter class is deInstantiated....");
	}

}
