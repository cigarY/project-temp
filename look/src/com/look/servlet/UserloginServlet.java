package com.look.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.look.model.User;
import com.look.service.IUserService;
import com.look.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserloginServlet
 */
@WebServlet("/userlogin")
public class UserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserloginServlet() {
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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(name, password);
		HttpSession session = request.getSession();
		session.setAttribute("UserLogin", name);
		
		IUserService userservice = new UserServiceImpl();
		
		int ret = userservice.login(user);

		switch (ret) {
		case IUserService.CODE_OK:
			request.setAttribute("name", name);
			request.getRequestDispatcher("exam.jsp").forward(request, response);
			return;
		case IUserService.CODE_USER_NOT_EXISTS:
			request.setAttribute("msg", "用户名不存在");
			break;
		case IUserService.CODE_PASSWORD_ERROR:
			request.setAttribute("msg", "密码错误");
			break;
		case IUserService.CODE_DB_ERROR:
			request.setAttribute("msg", "数据库访问错误");
			break;
		}		
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}

}
