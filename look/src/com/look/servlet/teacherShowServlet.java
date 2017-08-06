package com.look.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.look.dao.impl.T_PowerDao;
import com.look.model.TeacherPower;



/**
 * Servlet implementation class teacherShowServlet
 */
@WebServlet("/teacherShowServlet")
public class teacherShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   List<TeacherPower> list = new ArrayList<TeacherPower>();
		   list =  new T_PowerDao().getAll();
		   request.getSession().setAttribute("TeacherPower", list);
		//   request.setAttribute("TeacherPower", list);
		   System.out.println(list.size());
		  response.sendRedirect("teacherShow.jsp");
	}

}
