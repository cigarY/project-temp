package com.tpro.look.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tpro.look.model.Admin;
import com.tpro.look.model.User;
import com.tpro.look.service.IAdminService;
import com.tpro.look.service.IUserService;


@Controller
@RequestMapping("/user")
public class LoginRegisterController {
	
	@Autowired
	IUserService userService;
	@Autowired
	IAdminService adminService;
	
	/**
	 * 管理员登录
	 * @param request
	 * @param adminname
	 * @param adminpwd
	 * @return
	 */
	@RequestMapping(value="/doadminlogin",method=RequestMethod.POST)
	public String doAdminLogin(HttpServletRequest request,@RequestParam("adminname") String adminname,@RequestParam("adminpwd") String adminpwd) {
		Admin admin = new Admin();
		admin = adminService.findByName(adminname);
		if(null!=admin) {
			String pwd = admin.getAdminpwd(); 
			if(adminpwd.equals(pwd)) {
				request.setAttribute("adminname", adminname);
				return "/admin";
			}else {
				request.setAttribute("msg", "用户名或密码错误！");
				return "/adminlogin";
			}		
		}else{
			request.setAttribute("msg", "用户名或密码错误！");
			return "/adminlogin";
		}
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doUserLogin(HttpServletRequest request,@RequestParam("username") String username,@RequestParam("password") String password) {
		HttpSession session = request.getSession();
		User user = new User();
		user = userService.findByName(username);
		if(null!=user) {
			String pwd = user.getPassword(); 
			if(password.equals(pwd)) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("uid", user.getUid());
				//获取登录时间
				Date day=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				user.setLogTime(df.format(day));
				userService.updateTime(user); 
				return "/index";
			}else {
				request.setAttribute("msg", "用户名或密码错误！");
				return "/login";
			}		
		}else{
			request.setAttribute("msg", "用户名或密码错误！");
			return "/login";
		}
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param username
	 * @param password
	 * @param email
	 * @param sex
	 * @param besurepwd
	 * @return
	 */
	@RequestMapping(value="/doregister",method=RequestMethod.POST)
	public String doRegister(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("sex") String sex,
			@RequestParam("besurepwd") String besurepwd) {
		if(password.equals(besurepwd)) {
			User user = new User(username, password, sex, email);
			userService.insert(user);
		}else {
			request.setAttribute("msg", "两次密码输入不一致！");
			return "/register";
		}		
		return "/login";
	}
}
