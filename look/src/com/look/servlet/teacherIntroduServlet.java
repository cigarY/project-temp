package com.look.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.look.dao.impl.T_PowerDao;
import com.look.model.StudentJudge;
import com.look.model.TeacherIntroduce;


/**
 * Servlet implementation class teacherIntroduServlet
 */
@WebServlet("/teacherIntroduServlet")
public class teacherIntroduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int tid = Integer.parseInt(request.getParameter("tid"));
		TeacherIntroduce introduce  = new T_PowerDao().getOne(tid);
		//System.out.println(introduce);
		request.getSession().setAttribute("introduce", introduce);
		//System.out.println(introduce);
		List<StudentJudge> list = new T_PowerDao().getJudge(tid);
		request.getSession().setAttribute("judges", list);
		response.sendRedirect("teacherIntrodu.jsp");
	}

}
