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

	int testNum = 0;// ������
	String isTrue = null;// ��ǰ��Ŀ�Ƿ���ȷ,T��ʾ��ȷ��F��ʾ����
	Random random = new Random();
	int index = 0;// �����±�
	int[] subjectArr = null;// ������Ŀ������
	int subjectId = 0;// ��Ŀ���
	
	@RequestMapping("/getcategory")
	public String getCategory(HttpServletRequest request,int subjectnum) {
		if(subjectnum == 1) {
			
		}else if (subjectnum == 4) {
			
		}
		return "/category";
	}
}
