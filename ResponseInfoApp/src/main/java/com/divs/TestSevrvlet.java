package com.divs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestSevrvlet
 */
@WebServlet("/test")
public class TestSevrvlet extends HttpServlet{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("image/jpg");
		
		File f=new File("C:\\Users\\Navis\\ServletApplication\\ResponseInfoApp\\divs.JPG");
		FileInputStream fis=new FileInputStream(f);
		
		byte[] b=new byte[(int)f.length()];
		fis.read(b);
		ServletOutputStream sos=response.getOutputStream();
		
		sos.write(b);
		sos.flush();
		sos.close();
		fis.close();
		
		
	}

}
