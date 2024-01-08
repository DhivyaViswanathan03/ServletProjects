package com.divs.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/test")
public class ValidationFilter implements Filter {
   
    public ValidationFilter() {
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		Integer eage=Integer.parseInt(request.getParameter("eage"));
		String email=request.getParameter("email");
		String emobile=request.getParameter("emobile");
		
		
		String errpage="error.jsp";
		String errpage2="error2.jsp";
		RequestDispatcher rd=null;
		if(eid==null || eid.isEmpty()
				||ename==null || ename.isEmpty()
				|| eage==null
				|| email==null || email.isEmpty()
				|| emobile==null || emobile.isEmpty()) {
			rd=request.getRequestDispatcher(errpage);
			rd.forward(request, response);
		}else if(!(eid.startsWith("iNeuron")) || !(eage>=20 && eage<=30) || !(email.endsWith("ineuron.ai")) 
				|| !(emobile.startsWith("91-"))){
			rd=request.getRequestDispatcher(errpage2);
			rd.forward(request, response);
			}else {
				chain.doFilter(request, response);
			}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
