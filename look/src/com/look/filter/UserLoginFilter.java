package com.look.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserLoginFilter
 */
@WebFilter("/*")
public class UserLoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;

		// 获取访问的uri地址
		String reqUri = req.getRequestURI();
		// 如果用户需要做题，检测用户是否登录，如果登录就通过，如果没有登录跳转登录界面

		Object user = req.getSession().getAttribute("UserLogin");
		if (user == null && reqUri.endsWith("/exam")) {
			rsp.sendRedirect("tologin.jsp");
			return;
		}
		chain.doFilter(req, rsp);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
