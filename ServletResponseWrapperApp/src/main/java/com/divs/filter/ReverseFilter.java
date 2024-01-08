package com.divs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

import com.divs.customresponse.DemoCustomeResponse;

/**
 * Servlet Filter implementation class ReverseFilter
 */
public class ReverseFilter implements Filter {
       
  
    public ReverseFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res=(HttpServletResponse)response;
		DemoCustomeResponse myResponse=new DemoCustomeResponse(res);
		chain.doFilter(request, myResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
