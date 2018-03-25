package com.tpro.look.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpro.look.model.Record;
import com.tpro.look.model.User;
import com.tpro.look.service.IRecordService;
import com.tpro.look.service.IUserService;

@Controller
@RequestMapping("/personal")
public class PersonalPageController {
	
	@Autowired
	IUserService userService;
	@Autowired
	IRecordService recordService;
	
	@RequestMapping("/personalinfo")
	public String showPersonalInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String struid = "";
		try {
			struid = session.getAttribute("uid").toString();
		}catch (Exception e) {
			struid = "";
		}	
		if("" == struid) {
			return "/tologin";
		}else {
			int uid = Integer.parseInt(struid);
			User user = userService.findById(uid);
			List<Record> recordslist1 = null;
			List<Record> recordslist4 = null;
			int[] errornum1 = null;
			int[] rightnum1 = null;
			String[] time1 = null;
			int[] errornum4 = null;
			int[] rightnum4 = null;
			String[] time4 = null;
			int length = 0;
			try {
				recordslist1 = recordService.findByIdAndSubject(uid, 1);
			} catch (Exception e) {
				recordslist1 = null;
			}
			if(recordslist1.size() == 0) {
				length = 7;
				errornum1 = new int[length];
				rightnum1 = new int[length];
				time1 = new String[length];
			}else {
				length = recordslist1.size();
				errornum1 = new int[length];
				rightnum1 = new int[length];
				time1 = new String[length];
				for(int i = 0; i<length;i++) {
					Record record = recordslist1.get(i);
					errornum1[i] = record.getErrornum();
					rightnum1[i] = record.getRightnum();
					time1[i] = record.getTest_time();
				}
			}			
			
			try {
				recordslist4 = recordService.findByIdAndSubject(uid, 4);
			} catch (Exception e) {
				recordslist4 = null;
			}
			if(recordslist4.size() == 0) {
				length = 7;
				errornum4 = new int[length];
				rightnum4 = new int[length];
				time4 = new String[length];
			}else {
				length = recordslist4.size();
				errornum4 = new int[length];
				rightnum4 = new int[length];
				time4 = new String[length];
				for(int i = 0; i<length;i++) {
					Record record = recordslist4.get(i);
					errornum4[i] = record.getErrornum();
					rightnum4[i] = record.getRightnum();
					time4[i] = record.getTest_time();
				}
			}
			
			
			request.setAttribute("user", user);
			request.setAttribute("errornum1", errornum1);
			request.setAttribute("rightnum1", rightnum1);
			request.setAttribute("time1", time1);
			request.setAttribute("errornum4", errornum4);
			request.setAttribute("rightnum4", rightnum4);
			request.setAttribute("time4", time4);
		}
		
		return "/personal";
	}
}
