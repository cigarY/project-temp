package com.tpro.look.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpro.look.model.SubjectQ1;
import com.tpro.look.model.SubjectQ4;
import com.tpro.look.service.ISubjectQ1Service;
import com.tpro.look.service.ISubjectQ4Service;

@Controller
@RequestMapping("/subjecttest")
public class SubjectTestController {

	@Autowired
	private ISubjectQ1Service subjectQ1Service;
	@Autowired
	private ISubjectQ4Service subjectQ4Service;

	int testNum = 0;// 需要生成的题目数
	int subjectcount = 0;// 题库中题目总数
	int[] testArr = null;// 题目数组
	int index = 0;// 数组下标
	Random random = new Random();
	int r = random.nextInt(100) + 1;// 生成随机考号

	int errorNum = 0;// 错题数
	int rightNum = 0;// 正确题数
	int countAnswer = 0;// 记录答题总数
	int score = 0;// 总得分
	List<Integer> choselist = new ArrayList<>();// 存放提交的题目，避免重复提交
	String isTrue = null;// 当前题目是否正确,T表示正确，F表示错误

	/**
	 * 根据科目号随机生成对应的题目，重定向到测试界面
	 * 
	 * @param request
	 * @param subjectnum
	 *            科目号
	 * @return
	 */
	@RequestMapping("/getsubjecttest")
	public String getSubjectTest(HttpServletRequest request, int subjectnum) {
		if (subjectnum == 1) {
			testNum = 100;
			subjectcount = subjectQ1Service.getPageCount();
			testArr = getNumArr(testNum, subjectcount);
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(testArr[0]);
			request.setAttribute("subject", subjectQ1);
		} else if (subjectnum == 4) {
			testNum = 50;
			subjectcount = subjectQ4Service.getPageCount();
			testArr = getNumArr(testNum, subjectcount);
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(testArr[0]);
			request.setAttribute("subject", subjectQ4);
		} else {
			request.setAttribute("msg", "不存在所选科目！");
			return "/msg";
		}
		request.setAttribute("r", r);
		request.setAttribute("index", index);
		request.setAttribute("testNum", testNum);
		return "/examtest";
	}

	/**
	 * 处理用户提交的数据
	 * 
	 * @param request
	 * @param control_i
	 * @param answer_i
	 * @return
	 */
	@RequestMapping("/dealsubjectexam")
	public String dealSubjectExam(HttpServletRequest request, int control_i, String answer_i) {
		index = control_i;		
		if (index < 1) {
			index = 0;
		} else if(index >= testNum) {
			index = testNum - 1;
		} 
		
		int tid = testArr[index];
		if (testNum == 100) {
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(tid);
			request.setAttribute("subject", subjectQ1);
			// 用户的答案数目没有达到要求数目时,并且在list中不存在提交的题目编号，并且题目数目小于指定总数目，做相应的自加操作
			if (countAnswer < testNum && !choselist.contains(index)) {
				choselist.add(index);
				countAnswer++;
				if (answer_i.equals(subjectQ1.getAnswer())) {
					rightNum++;
					isTrue = "T";
				} else {
					errorNum++;
					isTrue = "F";
				}
			}
		} else if (testNum == 50) {
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(tid);
			request.setAttribute("subject", subjectQ4);
			// 用户的答案数目没有达到要求数目时,并且在list中不存在提交的题目编号，并且题目数目小于指定总数目，做相应的自加操作
			if (countAnswer < testNum && !choselist.contains(index)) {
				choselist.add(index);
				countAnswer++;
				if (answer_i.equals(subjectQ4.getAnswer())) {
					rightNum++;
					isTrue = "T";
				} else {
					errorNum++;
					isTrue = "F";
				}
			}
		} else {
			request.setAttribute("msg", "不存在所选科目！");
			return "/msg";
		}
		request.setAttribute("r", r);
		request.setAttribute("index", index);
		request.setAttribute("testNum", testNum);
		request.setAttribute("isTrue", isTrue);
		return "/examtest";
	}
	
	/**
	 * 用于答题信息区查询题目信息
	 * @return
	 */
	@RequestMapping("getsubjectbyid")
	public String getSubjectById(HttpServletRequest request, int control_i) {
		index = control_i;
		if (testNum == 100) {
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(testArr[index]);
			request.setAttribute("subject", subjectQ1);
		} else if (testNum == 50) {
			testNum = 50;
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(testArr[index]);
			request.setAttribute("subject", subjectQ4);
		} else {
			request.setAttribute("msg", "操作错误！");
			return "/msg";
		}
		request.setAttribute("r", r);
		request.setAttribute("index", index);
		request.setAttribute("testNum", testNum);
		return "/examtest";
	}
	
	@RequestMapping("/submitsubjectexam")
	public String submitSubjectExam(HttpServletRequest request) {
		return "/msg";
	}

	/**
	 * 随机生成题目
	 * 
	 * @param countNum
	 *            需要生成的题目个数
	 * @param sum
	 *            题库中所有题目数
	 * @return 题目编号列表
	 */
	private int[] getNumArr(int countNum, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		int[] array = new int[countNum];
		int num = 0;
		for (; true;) {
			num = random.nextInt(sum) + 1;
			set.add(num);
			if (set.size() >= countNum) {
				break;
			}
		}
		int i = 0;
		for (int a : set) {
			array[i] = a;
			i++;
		}
		return array;
	}
}
