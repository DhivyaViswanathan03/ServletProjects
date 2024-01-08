package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Request URI is:"+request.getRequestURI());
		System.out.println("Path Info is:"+request.getPathInfo());
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		
		if(request.getRequestURI().endsWith("addform")) {
			Student s=new Student();
			s.setName(request.getParameter("sname"));
			s.setAge(Integer.parseInt(request.getParameter("sage")));
			s.setAddress(request.getParameter("saddr"));
			PrintWriter out=response.getWriter();
			String message=studentService.addStudent(s);
			RequestDispatcher rd=null;
			if(message.equalsIgnoreCase("success")) {
				request.setAttribute("status", message);
				rd=request.getRequestDispatcher("../insertresult.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("status", message);
				rd=request.getRequestDispatcher("../insertresult.jsp");
				rd.forward(request, response);
			}
			out.close();
		}
		
		if(request.getRequestURI().endsWith("searchform")) {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			Student student=studentService.searchStudent(Integer.parseInt(id));
		    RequestDispatcher rd=null;
		    request.setAttribute("student", student);
		    rd=request.getRequestDispatcher("../display.jsp");
		    rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith("deleteform")) {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			String message=studentService.deleteStudent(Integer.parseInt(id));
			RequestDispatcher rd=null;
			if(message.equalsIgnoreCase("success")) {
				request.setAttribute("status", message);
				rd=request.getRequestDispatcher("../deleteresult.jsp");
				rd.forward(request, response);
			}else if(message.equalsIgnoreCase("failed")) {
				request.setAttribute("status", message);
				rd=request.getRequestDispatcher("../deleteresult.jsp");
				rd.forward(request, response);
			}else {
				rd=request.getRequestDispatcher("../deleteresult.jsp");
				rd.forward(request, response);
			}
			out.close();
		}
		
		if(request.getRequestURI().endsWith("editform")) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			Student student=studentService.searchStudent(Integer.parseInt(id));
			RequestDispatcher rd=null;
	        request.setAttribute("student", student);
			rd=request.getRequestDispatcher("../updateform.jsp");
			rd.forward(request, response);
			
		
		}
		
		
		if(request.getRequestURI().endsWith("updateRecord")){
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String sage=request.getParameter("sage");
			String saddr=request.getParameter("saddr");
			
			System.out.println(sid+","+sname+","+sage+","+saddr);
			Student s=new Student();
			s.setId(Integer.parseInt(sid));
			s.setName(sname);
			s.setAge(Integer.parseInt(sage));
			s.setAddress(saddr);
			String message=studentService.updateStudent(s);
			RequestDispatcher rd=null;
			if(message.equalsIgnoreCase("success")) {
				System.out.println(message);
				request.setAttribute("status", message);
				rd=request.getRequestDispatcher("../../updateresult.jsp");
				rd.forward(request, response);
			}else {
				System.out.println(message);
				request.setAttribute("status", message);
				rd=request.getRequestDispatcher("../updateresult.jsp");
				rd.forward(request, response);
			}
			out.close();
		}
		
		
		
	}
	

}
