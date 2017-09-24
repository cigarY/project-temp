package com.testsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testsystem.model.Admin;
import com.testsystem.service.IAdminService;
import com.testsystem.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminloginServlet
 */
@WebServlet("/adminlogin")
public class AdminloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminname = request.getParameter("username");
		String adminpwd = request.getParameter("password");
		
		Admin admin = new Admin(adminname, adminpwd);
		IAdminService adminservice = new AdminServiceImpl();
		
		int ret = adminservice.login(admin);

		switch (ret) {
		case IAdminService.CODE_OK:
			request.setAttribute("adminname", adminname);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
			return;
		case IAdminService.CODE_USER_NOT_EXISTS:
			request.setAttribute("msg", "用户名不存在");
			break;
		case IAdminService.CODE_PASSWORD_ERROR:
			request.setAttribute("msg", "密码错误");
			break;
		case IAdminService.CODE_DB_ERROR:
			request.setAttribute("msg", "数据库访问错�?");
			break;
		}		
		request.getRequestDispatcher("adminlogin.jsp").forward(request, response);	
	}

}
