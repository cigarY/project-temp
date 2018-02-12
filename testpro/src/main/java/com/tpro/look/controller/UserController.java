package com.tpro.look.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tpro.look.model.User;
import com.tpro.look.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/getallusers")
	public String getAllUsers(HttpServletRequest request, Model model,int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();		
		int pageCount = userService.getPageCount();
		int endPage = 0;
		if(pageCount%15 == 0) {
			endPage = pageCount/15;
		}else {
			endPage = pageCount/15+1;
		}		
		int start = 0;
		int pagesize = 15;
		if (pageNo <= 0) {
			pageNo = 1;
			start = 0;
		} else if (pageNo < endPage && pageNo > 1) {			
			start = (pageNo-1)*15;
		} else if (pageNo >= endPage) {
			start = (endPage-1)*15;
			pagesize = pageCount-start;
		}		
		request.setAttribute("pageNo", pageNo);
		model.addAttribute("pageNo", pageNo);
		request.setAttribute("endPage", endPage);
		model.addAttribute("endPage", endPage);
		map.put("start", start);
		map.put("pagesize", pagesize);
		List<User> userlist = userService.findAll(map);
		request.setAttribute("users", userlist);
		model.addAttribute("users", userlist);
		return "/userlist";
	}
	
	@RequestMapping(value="/getkeywordusers",method=RequestMethod.POST)
	public String getKeyWordsSubject(HttpServletRequest request, Model model, @RequestParam("keyWords") String keyWords) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keywords", keyWords);
		map.put("start", 0);
		map.put("pagesize", 15);		
		List<User> userslist = userService.findListByKeyWords(map);
		request.setAttribute("keywords", keyWords);
		model.addAttribute("keywords", keyWords);
		request.setAttribute("users", userslist);
		model.addAttribute("users", userslist);
		return "/userlist";
	}

	@RequestMapping("/edituser")
	public String updateUser(User user, Model model, HttpServletRequest request) {
		if (userService.update(user)) {
			user = userService.findById(user.getUid());
			request.setAttribute("uesrs", user);
			model.addAttribute("users", user);
			return "redirect:/user/getallusers";
		} else {
			return "/error";
		}
	}

	@RequestMapping("/getuser")
	public String getUser(int id, Model model, HttpServletRequest request) {
		request.setAttribute("user", userService.findById(id));
		model.addAttribute("user", userService.findById(id));
		return "/useredit";
	}

	@RequestMapping("/deluser")
	public void delUser(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (userService.delete(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
