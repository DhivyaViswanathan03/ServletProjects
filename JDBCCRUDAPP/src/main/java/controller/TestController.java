package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Student;
import service.IStudentService;
import servicefactory.StudentServiceFactory;


@WebServlet("/controller/*")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Request URI is:"+request.getRequestURI());
		System.out.println("Path Info is:"+request.getPathInfo());
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		response.setContentType("text/html");
		if(request.getRequestURI().endsWith("addform")) {
			Student s=new Student();
			s.setName(request.getParameter("sname"));
			s.setAge(Integer.parseInt(request.getParameter("sage")));
			s.setAddress(request.getParameter("saddr"));
			PrintWriter out=response.getWriter();
			String message=studentService.addStudent(s);
			if(message.equalsIgnoreCase("success")) {
				out.println("<h1 style='color:green;text-align=center;'>REGISTRATION SUCCESS</h1>");
			}else {
				out.println("<h1 style='color:red;text-align=center;'>REGISTRATION FAILED</h1>");
			}
			out.close();
		}
		
		if(request.getRequestURI().endsWith("searchform")) {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			Student student=studentService.searchStudent(Integer.parseInt(id));
		    if(student!=null) {
				out.println("<body>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>"+student.getId()+"</td></tr>");
				out.println("<tr><th>NAME</th><td>"+student.getName()+"</td></tr>");
				out.println("<tr><th>AGE</th><td>"+student.getAge()+"</td></tr>");
				out.println("<tr><th>ADDRESS</th><td>"+student.getAddress()+"</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			}else {
				out.println("<h1 style='color:red; text-align=center;'>DATA NOT AVAILABLE FOR GIVEN ID"+id+"</h1>");
			}
		}
		
		if(request.getRequestURI().endsWith("deleteform")) {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			String message=studentService.deleteStudent(Integer.parseInt(id));
			if(message.equalsIgnoreCase("success")) {
				out.println("<body>");
				out.println("<h1>RECORD DELETED SUCCESSFULLY</h1>");
				out.println("</body>");
			}else if(message.equalsIgnoreCase("failed")) {
				out.println("<body>");
				out.println("<h1>RECORD DELETION FAILED</h1>");
				out.println("</body>");
			}else {
				out.println("<body>");
				out.println("<h1>RECORD NOT FOUND FOR GIVEN ID"+id+"</h1>");
				out.println("</body>");
			}
			out.close();
		}
		
		if(request.getRequestURI().endsWith("editform")) {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			Student student=studentService.searchStudent(Integer.parseInt(id));
			if(student !=null) {
				out.println("<form method='POST' action='./controller/updateForm'>");
				out.println("<center>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>"+student.getId()+"</td></tr>");
				out.println("<input type='hidden' name='sid' value='"+student.getId()+"'>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='"+student.getName()+"'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='"+student.getAge()+"'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='"+student.getAddress()+"'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</center>");
				out.println("</table>");
				out.println("</form>");
			}else {
				out.println("<h1 style='color:red; text-align=center;'>DATA NOT FOUND FOR GIVEN ID "+id+"</h1>");
			}
			
		}
		
		if(request.getRequestURI().endsWith("updateForm")){
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String sage=request.getParameter("sage");
			String saddr=request.getParameter("saddr");
			Student s=new Student();
			s.setId(Integer.parseInt(sid));
			s.setName(sname);
			s.setAge(Integer.parseInt(sage));
			s.setAddress(saddr);
			String message=studentService.updateStudent(s);
			if(message.equalsIgnoreCase("success")) {
				out.println("<h1 style='color:green;text-align=center;'>UPDATED SUCCESSFULLY</h1>");
			}else {
				out.println("<h1 style='color:red;text-align=center;'>UPDATION FAILED</h1>");
			}
			
		}
		
		
		
	}

}
