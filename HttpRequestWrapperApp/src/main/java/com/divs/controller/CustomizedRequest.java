package com.divs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper{

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
		
	}
	
	
//	@Override
//	public String getAttribute(String name) {
//		String word = super.getAttribute(name);
//		if(word.equalsIgnoreCase("jee") || word.equalsIgnoreCase("spring") || word.equalsIgnoreCase("java"))
//			return "SLEEP";
//		
//		return word;
//	}
	
	@Override
	public String getParameter(String name) {
		String word = super.getParameter(name);
		if(word.equalsIgnoreCase("jee") || word.equalsIgnoreCase("spring") || word.equalsIgnoreCase("java"))
			return "SLEEP";
		
		return word;
	}
	

}
