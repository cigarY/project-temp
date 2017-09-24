package com.testsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testsystem.model.User;
import com.testsystem.service.IUserService;
import com.testsystem.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/regist")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String besurepwd = request.getParameter("besurepwd");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String code = request.getParameter("code");
		
		
		String codeInSession = (String) request.getSession().getAttribute("code");

		//�?验验证码是否正确
		if (!codeInSession.equalsIgnoreCase(code)) {
			request.setAttribute("msg", "验证码错�?");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		//�?查密码是否正�?
		if(!password.equals(besurepwd)){
			request.setAttribute("msg", "密码不正确！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		
		User user = new User(name, sex, email, password);
		IUserService userservice = new UserServiceImpl();
		try {
			boolean result = userservice.add(user);
			if(!result){
				request.setAttribute("msg", "注册失败，稍后重�?");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			out.append("<div style="+"height: 30px; width: 300px;font-size:22px;margin:80px auto;"+">");
			out.append("注册成功�?<a href="+"login.jsp"+">");
			out.append("点击进入登录页面");
			out.append("</a></div>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
