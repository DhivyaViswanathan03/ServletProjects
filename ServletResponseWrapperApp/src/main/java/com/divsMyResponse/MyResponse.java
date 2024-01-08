package com.divsMyResponse;

import java.io.PrintWriter;

public class MyResponse extends PrintWriter{

	PrintWriter out;
	public MyResponse(PrintWriter out) {
		super(out);
		this.out=out;
		
	}
	
	@Override
	public void println(String name) {
		System.out.println("MyResponse is called...");
		if(!name.startsWith("<")) {
			StringBuffer str=new StringBuffer(name);
			out.println(str.reverse());
		}else {
			out.println(name);
		}
		
	}

}
