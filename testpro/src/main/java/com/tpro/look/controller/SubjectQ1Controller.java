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

import com.tpro.look.model.SubjectQ1;
import com.tpro.look.service.ISubjectQ1Service;

@Controller
@RequestMapping("/subject1")
public class SubjectQ1Controller {

	@Autowired
	private ISubjectQ1Service subjectQ1Service;

	@RequestMapping("/getallsubjects")
	public String getAllSubject(HttpServletRequest request, Model model,int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();		
		int pageCount = subjectQ1Service.getPageCount();
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
		List<SubjectQ1> subjectslist = subjectQ1Service.findAll(map);
		request.setAttribute("subjects", subjectslist);
		model.addAttribute("subjects", subjectslist);
		return "/subjectlist";
	}
	
	@RequestMapping(value="/getkeywordsubjects",method=RequestMethod.POST)
	public String getKeyWordsSubject(HttpServletRequest request, Model model, @RequestParam("keyWords") String keyWords) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keywords", keyWords);		
		List<SubjectQ1> subjectslist = subjectQ1Service.findListByKeyWords(map);
		request.setAttribute("keywords", keyWords);
		model.addAttribute("keywords", keyWords);
		request.setAttribute("subjects", subjectslist);
		model.addAttribute("subjects", subjectslist);
		return "/subjectlist";
	}

	@RequestMapping("/toaddsubject")
	public String toAddSubject() {
		return "/subjectadd";
	}

	@RequestMapping("/addsubject")
	public String addSubject(SubjectQ1 subjectQ1, Model model) {
		subjectQ1Service.insert(subjectQ1);
		return "redirect:/subject1/getallsubjects";
	}

	@RequestMapping("/editsubject")
	public String updateSubject(SubjectQ1 subjectQ1, Model model, HttpServletRequest request) {
		if (subjectQ1Service.update(subjectQ1)) {
			subjectQ1 = subjectQ1Service.findById(subjectQ1.getId());
			request.setAttribute("subject1", subjectQ1);
			model.addAttribute("subject1", subjectQ1);
			return "redirect:/subject1/getallsubjects";
		} else {
			return "/error";
		}
	}

	@RequestMapping("/getsubject")
	public String getSubject(int id, Model model, HttpServletRequest request) {
		request.setAttribute("subject1", subjectQ1Service.findById(id));
		model.addAttribute("subject1", subjectQ1Service.findById(id));
		return "/subjectedit";
	}

	@RequestMapping("/delsubject")
	public void delSubject(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (subjectQ1Service.delete(id)) {
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
