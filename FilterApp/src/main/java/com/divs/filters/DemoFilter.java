package com.divs.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DemoFilter implements Filter {
     static {
    	 System.out.println("Filter class is loading....");
     }
 
    public DemoFilter() {
       System.out.println("Filter class is instantiated..");
    }

public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("Filter class is initialized..");
	}
	
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println("Filer called before processing the request");
		chain.doFilter(request, response);
		out.println("Filer called after processing the request");
	}
	
    public void destroy() {
	System.out.println("Filter class is de-instantiated....");
	}

	
	

}
