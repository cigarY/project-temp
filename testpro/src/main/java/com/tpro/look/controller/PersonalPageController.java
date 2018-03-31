package com.tpro.look.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpro.look.model.Record;
import com.tpro.look.model.SubjectQ1;
import com.tpro.look.model.SubjectQ4;
import com.tpro.look.model.User;
import com.tpro.look.service.IRecordService;
import com.tpro.look.service.ISubjectQ1Service;
import com.tpro.look.service.ISubjectQ4Service;
import com.tpro.look.service.IUserService;

@Controller
@RequestMapping("/personal")
public class PersonalPageController {
	
	@Autowired
	IUserService userService;
	@Autowired
	IRecordService recordService;
	
	@Autowired
	private ISubjectQ1Service subjectQ1Service;
	@Autowired
	private ISubjectQ4Service subjectQ4Service;
	
	int[] numarr1 = null;//科目一错题集
	int[] numarr4 = null;//科目四错题集
	
	String isTrue = null;// 当前题目是否正确,T表示正确，F表示错
	int index = 0;// 数组下标
	int subjectId = 0;//科目
	int testNum = 0;
	
	
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
			//初始化
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
	
	@RequestMapping("/searcherror")
	public String geterrorsubjects(HttpServletRequest request,Integer uid) {
		
		//科目一错题集
		List<String> errlist1 = recordService.findes1ByUid(uid);
		List<Integer> errnumlist1 = new ArrayList<>();
		for(int i=0;i<errlist1.size();i++) {
			String errarr = errlist1.get(i);//[1,2,3]
			String errstr1 = errarr.replaceAll("\\[","");
			String errstr2 = errstr1.replaceAll("\\]","");	
			String[] errornumstr = errstr2.split(",");
			for(int j=0;j<errornumstr.length;j++) {
				String str = errornumstr[j];
				String str1 = str.replaceAll(" +","");	
				int num1 = Integer.parseInt(str1);
				if (!errnumlist1.contains(num1)) {
					errnumlist1.add(num1);
				}
			}
		}
		numarr1 = new int[errnumlist1.size()];
		for(int i=0;i<numarr1.length;i++) {
			numarr1[i] = errnumlist1.get(i);
		}
		
		//科目四错题集
		List<String> errlist4 = recordService.findes4ByUid(uid);
		List<Integer> errnumlist4 = new ArrayList<>();
		for(int i=0;i<errlist4.size();i++) {
			String errarr = errlist4.get(i);//[1,2,3]
			String errstr1 = errarr.replaceAll("\\[","");
			String errstr2 = errstr1.replaceAll("\\]","");	
			String[] errornumstr = errstr2.split(",");
			for(int j=0;j<errornumstr.length;j++) {
				String str = errornumstr[j];
				String str1 = str.replaceAll(" +","");	
				int num4 = Integer.parseInt(str1);
				if (!errnumlist4.contains(num4)) {
					errnumlist4.add(num4);
				}
			}
		}
		numarr4 = new int[errnumlist4.size()];
		for(int i=0;i<numarr4.length;i++) {
			numarr4[i] = errnumlist4.get(i);
		}
		/*request.setAttribute("errsubjects1", numarr1);
		request.setAttribute("errsubjects4", numarr4);*/
		request.setAttribute("err1size", numarr1.length);
		request.setAttribute("err4size", numarr4.length);
		return "/errorsubjects";
	}
	
	@RequestMapping("/showerrorsubjects")
	public String showERSubjects(HttpServletRequest request,int subjectnum) {
		if(subjectnum == 1) {
			testNum = numarr1.length;
			subjectId = subjectnum;
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(numarr1[0]);
			request.setAttribute("subject", subjectQ1);
			request.setAttribute("practicename", "科目一错题练习");
		}else if(subjectnum == 4){
			testNum = numarr4.length;
			subjectId = subjectnum;
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(numarr4[0]);
			request.setAttribute("subject", subjectQ4);
			request.setAttribute("practicename", "科目四错题练习");
		}else {
			request.setAttribute("msg","生成题目错误！");
			return "/msg";
		}
		request.setAttribute("testNum", testNum);
		request.setAttribute("index", index);
		return "/errortest";
	}
	
	@RequestMapping("/dealerrorsubjects")
	public String dealSubjectPractice(HttpServletRequest request, int control_i, String answer_i) {
		index = control_i;
		int wrongnumber = 0;
		int wrongid = 0;

		if (subjectId == 1) {
			testNum = numarr1.length;
			request.setAttribute("practicename", "科目一错题练习");
			if (index<1) {
				index = 0;
			}else if(index>testNum){
				index = numarr1.length-1;
			}
			int tid = numarr1[index];
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(tid);
			request.setAttribute("subject", subjectQ1);
			// 用户提交的答案判断
			if (answer_i.equals(subjectQ1.getAnswer())) {
				isTrue = "T";
			} else if (answer_i.equals("0") || null == answer_i) {
				isTrue = "N";
			} else {
				isTrue = "F";
				// 统计错题数目，写入数据库用于难题练习
				wrongnumber = subjectQ1.getWrongnumber() + 1;
				wrongid = subjectQ1.getId();
				subjectQ1Service.updateWrongNum(wrongnumber, wrongid);
			}

		} else if (subjectId == 4) {
			testNum = numarr4.length;
			request.setAttribute("practicename", "科目四错题练习");
			if (index<1) {
				index = 0;
			}else if(index>testNum){
				index = testNum-1;
			}
			int tid = numarr4[index];
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(tid);
			request.setAttribute("subject", subjectQ4);
			// 用户提交的答案判断
			if (answer_i.equals(subjectQ4.getAnswer())) {
				isTrue = "T";
			} else if (answer_i.equals("0") || null == answer_i) {
				isTrue = "N";
			} else {
				isTrue = "F";
				// 统计错题数目，写入数据库用于难题练习
				wrongnumber = subjectQ4.getWrongnumber() + 1;
				wrongid = subjectQ4.getId();
				subjectQ4Service.updateWrongNum(wrongnumber, wrongid);
			}
		}
		request.setAttribute("testNum", testNum);
		request.setAttribute("index", index);
		request.setAttribute("isTrue", isTrue);
		return "/errortest";
	}
	
}
