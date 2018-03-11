package com.tpro.look.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tpro.look.model.User;
import com.tpro.look.service.IUserService;


@Controller
@RequestMapping("/user")
public class LoginRegisterController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doUserLogin(HttpServletRequest request,@RequestParam("username") String username,@RequestParam("password") String password) {
		HttpSession session = request.getSession();
		User user = userService.findByName(username);
		if(null!=user) {
			String pwd = user.getPassword(); 
			if(password.equals(pwd)) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
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
	
	@RequestMapping(value="/doregister",method=RequestMethod.POST)
	public String doRegister(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("sex") String sex) {
		
		return "";
	}
}
