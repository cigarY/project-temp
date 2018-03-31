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

import com.tpro.look.model.SubjectQ4;
import com.tpro.look.service.ISubjectQ4Service;

@Controller
@RequestMapping("/subject4")
public class SubjectQ4Controller {

	@Autowired
	private ISubjectQ4Service subjectQ4Service;

	@RequestMapping("/getallsubjects")
	public String getAllSubject(HttpServletRequest request, Model model,int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();		
		int pageCount = subjectQ4Service.getPageCount();
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
		List<SubjectQ4> subjectslist = subjectQ4Service.findAll(map);
		request.setAttribute("subjects", subjectslist);
		model.addAttribute("subjects", subjectslist);
		return "/subjectlist2";
	}
	
	@RequestMapping(value="/getkeywordsubjects",method=RequestMethod.POST)
	public String getKeyWordsSubject(HttpServletRequest request, Model model, @RequestParam("keyWords") String keyWords) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keywords", keyWords);
		map.put("start", 0);
		map.put("pagesize", 15);		
		List<SubjectQ4> subjectslist = subjectQ4Service.findListByKeyWords(map);
		request.setAttribute("keywords", keyWords);
		model.addAttribute("keywords", keyWords);
		request.setAttribute("subjects", subjectslist);
		model.addAttribute("subjects", subjectslist);
		return "/subjectlist2";
	}

	@RequestMapping("/toaddsubject")
	public String toAddSubject() {
		return "/subjectadd2";
	}

	@RequestMapping("/addsubject")
	public String addSubject(SubjectQ4 subjectQ4, Model model) {
		subjectQ4Service.insert(subjectQ4);
		return "redirect:/subject4/getallsubjects";
	}

	@RequestMapping("/editsubject")
	public String updateSubject(SubjectQ4 subjectQ4, Model model, HttpServletRequest request) {
		if (subjectQ4Service.update(subjectQ4)) {
			subjectQ4 = subjectQ4Service.findById(subjectQ4.getId());
			request.setAttribute("subject", subjectQ4);
			model.addAttribute("subject", subjectQ4);
			return "redirect:/subject4/getallsubjects";
		} else {
			return "/msg";
		}
	}

	@RequestMapping("/getsubject")
	public String getSubject(int id, Model model, HttpServletRequest request) {
		request.setAttribute("subject4", subjectQ4Service.findById(id));
		model.addAttribute("subject4", subjectQ4Service.findById(id));
		return "/subjectedit2";
	}

	@RequestMapping("/delsubject")
	public void delSubject(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"msg\"}";
		if (subjectQ4Service.delete(id)) {
			result = "{\"result\":\"msg\"}";
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
