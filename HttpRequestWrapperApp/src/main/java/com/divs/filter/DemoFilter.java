package com.divs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import com.divs.controller.CustomizedRequest;


@WebFilter("/test")
public class DemoFilter  implements Filter {
	
public void init(FilterConfig fConfig) throws ServletException {
		
	}


	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestWrapper=(HttpServletRequest) request;
		CustomizedRequest cr=new CustomizedRequest(requestWrapper);
				chain.doFilter(cr, response);
	}

public void destroy() {
		
	}

	
	
}
