package com.divs.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ValidationFilter  implements Filter {
       
   
    public ValidationFilter() {
        super();
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("validation filter is getting called...");
		String eid_err_msg="",ename_err_msg="",eage_err_msg="",email_err_msg="",emobile_err_msg="";
		boolean flag=true;
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String eage=request.getParameter("eage");
		String email=request.getParameter("email");
		String emobile=request.getParameter("emobile");
		
		PrintWriter out=response.getWriter();
		
		if(eid==null || eid.equals("")) {
			eid_err_msg="EID is required";
			flag=false;
		}else {
			if(!eid.startsWith("iNeuron-")) {
				eid_err_msg="EID should start with iNeuron-";
				flag=false;
			}else {
				flag=true;
			}
		}

		if(ename==null || ename.equals("")) {
			ename_err_msg="ENAME is required";
			flag=false;
		}else {
			if(ename.length()<3) {
				ename_err_msg="ENAME length should be greater than 3";
				flag=false;
			}else {
				flag=true;
			}
		}

		if(eage==null || eage.isEmpty()) {
			eage_err_msg="EAGE is required";
			flag=false;
		}else {
			if(Integer.parseInt(eage)<20 ||Integer.parseInt(eage)>30) {
				eage_err_msg="EAGE should between 20 and 30";
				flag=false;
			}else {
				flag=true;
			}
		}

		if(email==null || email.equals("")) {
			email_err_msg="EMAIL is required";
			flag=false;
		}else {
			if(!email.endsWith("@ineuron.ai")) {
				email_err_msg="EMAIL should end with @ineuron.ai";
				flag=false;
			}else {
				flag=true;
			}
		}

		if(emobile==null || emobile.equals("")) {
			emobile_err_msg="EMOBILE is required";
			flag=false;
		}else {
			if(!emobile.startsWith("91-")) {
				emobile_err_msg="EMOBILE should ends with 91-";
				flag=false;
			}else {
				flag=true;
			}
		}
		
		if(flag==true) {
			chain.doFilter(request, response);
		}
		else {
			
			out.println("<html>");
			out.println("<body>");
			out.println("<center>");
			out.println("<form method='post' action='./test'>");
			out.println("<h1 style='color:green; text-align:center;'>Employee Registration FORM</h1>");
			out.println("<table border='1'>");
			out.println("<tr><th>EID</th><td><input type='text' name='eid' value='"+eid+"'</td>"
					+ "<td><font color='red' size='3'>"+eid_err_msg+"</font></td></tr");
			out.println("<tr><th>ENAME</th><td><input type='text' name='ename' value='"+ename+"'</td>"
					+ "<td><font color='red' size='3'>"+ename_err_msg+"</font></td></tr>");
			out.println("<tr><th>EAGE</th><td><input type='text' name='eage' value='"+eage+"'</td>"
					+ "<td><font color='red' size='3'>"+eage_err_msg+"</font></td></tr");
			out.println("<tr><th>EMAIL</th><td><input type='text' name='email' value='"+email+"'</td>"
					+ "<td><font color='red' size='3'>"+email_err_msg+"</font></td></tr");
			out.println("<tr><th>EMOBILE</th><td><input type='text' name='emobile' value='"+emobile+"'</td>"
					+ "<td><font color='red' size='3'>"+emobile_err_msg+"</font></td></tr");
			out.println("<tr><th></th><td><input type='submit' value='reg'/></td></tr>");
			
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
