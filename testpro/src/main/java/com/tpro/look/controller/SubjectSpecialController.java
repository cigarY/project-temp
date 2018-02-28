package com.tpro.look.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpro.look.service.ISubjectQ1Service;
import com.tpro.look.service.ISubjectQ4Service;

@Controller
@RequestMapping("/subjectspecial")
public class SubjectSpecialController {
	
	@Autowired
	private ISubjectQ1Service subjectQ1Service;
	@Autowired
	private ISubjectQ4Service subjectQ4Service;

	int testNum = 0;// 总题数
	String isTrue = null;// 当前题目是否正确,T表示正确，F表示错误
	Random random = new Random();
	int index = 0;// 数组下标
	int[] subjectArr = null;// 生成题目的数组
	int subjectId = 0;// 科目编号
	
	@RequestMapping("/getcategory")
	public String getCategory(HttpServletRequest request,int subjectnum) {
		if(subjectnum == 1) {
			
		}else if (subjectnum == 4) {
			
		}
		return "/category";
	}
}
