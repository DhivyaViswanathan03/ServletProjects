package com.divs.customresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.divsMyResponse.MyResponse;

public class DemoCustomeResponse extends HttpServletResponseWrapper {

	public DemoCustomeResponse(HttpServletResponse response) {
		super(response);
		
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter out=super.getWriter();
		MyResponse myOut=new MyResponse(out);
		return myOut;
	}

}
