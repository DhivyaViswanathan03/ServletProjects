package com.divs.controller;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomizedResponse extends HttpServletResponseWrapper{

	private Writer output=new CharArrayWriter();

    public String toString() {
        return output.toString();
    }

    public CustomizedResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() {
        
		return new PrintWriter(output);
    }
    
    
	
	
}
