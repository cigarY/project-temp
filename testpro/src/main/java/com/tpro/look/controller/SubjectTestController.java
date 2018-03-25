package com.tpro.look.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpro.look.model.Record;
import com.tpro.look.model.SubjectQ1;
import com.tpro.look.model.SubjectQ4;
import com.tpro.look.service.IRecordService;
import com.tpro.look.service.ISubjectQ1Service;
import com.tpro.look.service.ISubjectQ4Service;

@Controller
@RequestMapping("/subjecttest")
public class SubjectTestController {

	@Autowired
	private ISubjectQ1Service subjectQ1Service;
	@Autowired
	private ISubjectQ4Service subjectQ4Service;
	
	private IRecordService recordService;

	int testNum = 0;// 需要生成的总题数
	int testchooseNum = 0;// 需要生成的单选题目数
	int testdchooseNum = 0;// 需要生成的多选题目数
	int testjudgeNum = 0;// 需要生成的判断题目数
	
	//数组里面存放题目的id号
	int[] testArr = null;//分类合成后的数组
	int[] testchooseArr = null;// 单选题目数组
	int[] testdchooseArr = null;// 多选题目数组
	int[] testjudgeArr = null;// 判断题目数组
	
	Random random = new Random();
	int index = 0;// 数组下标	
	int r = random.nextInt(100) + 1;// 生成随机考号

	int errorNum = 0;// 错题数
	int rightNum = 0;// 正确题数
	int countAnswer = 0;// 记录答题总数
	int score = 0;// 总得分
	List<Integer> choselist = new ArrayList<>();// 存放提交的题目，避免重复提交
	String isTrue = null;// 当前题目是否正确,T表示正确，F表示错误
	List<Integer> errorlist = new ArrayList<>();//存放错误题目
	int subjectId = 0;// 科目

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
		index = 0;
		subjectId = subjectnum;
		r = random.nextInt(100) + 1;// 生成随机考号
		if (subjectnum == 1) {			
			testNum = 100;
			testjudgeNum = 40;
			testchooseNum = 60;
			//单选题题目列表
			List<SubjectQ1> chooselist = subjectQ1Service.findListOnlyItem3();
			//判断题题目列表
			List<SubjectQ1> judgelist = subjectQ1Service.findListWithoutItem3();			
			testjudgeArr = getNumArr1(testjudgeNum, judgelist);
			testchooseArr = getNumArr1(testchooseNum, chooselist);
			testArr = connectArr1(testjudgeArr,testchooseArr);
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(testArr[0]);
			request.setAttribute("subject", subjectQ1);
		} else if (subjectnum == 4) {
			testNum = 50;
			testjudgeNum = 20;
			testchooseNum = 20;
			testdchooseNum = 10;
			List<SubjectQ4> chooselist = subjectQ4Service.findListChoose();
			List<SubjectQ4> dchooselist = subjectQ4Service.findListDChoose();
			List<SubjectQ4> judgelist = subjectQ4Service.findListWithoutItem3();
			testjudgeArr = getNumArr2(testjudgeNum, judgelist);
			testchooseArr = getNumArr2(testchooseNum, chooselist);
			testdchooseArr = getNumArr2(testdchooseNum, dchooselist);
			testArr = connectArr2(testjudgeArr, testchooseArr, testdchooseArr);
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
		int wrongnumber = 0;
		int wrongid = 0;
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
					//统计错题数目，写入数据库用于难题练习
					wrongnumber = subjectQ1.getWrongnumber()+1;
					wrongid = subjectQ1.getId();
					errorlist.add(tid);
					subjectQ1Service.updateWrongNum(wrongnumber, wrongid);
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
					//统计错题数目，写入数据库用于难题练习
					wrongnumber = subjectQ4.getWrongnumber()+1;
					wrongid = subjectQ4.getId();
					errorlist.add(tid);
					subjectQ4Service.updateWrongNum(wrongnumber, wrongid);
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
	@RequestMapping("/getsubjectbyid")
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
	
	/**
	 * 用户交卷处理
	 * @param request
	 * @param submit_i
	 * @return
	 */
	@RequestMapping("/submitsubjectexam")
	public String submitSubjectExam(HttpServletRequest request) {
		// 通过用户选择的科目计算用户的得分
		if (testNum == 100) {
			score = rightNum * 1;
		} else {
			score = rightNum * 2;
		}
		request.setAttribute("msg", "您的得分："+score);
		
		//将用户信息加入到成绩数据库
		//获取登录时间
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//从session中获取uid
		HttpSession session = request.getSession();
		String struid = session.getAttribute("uid").toString();
		if(null == struid) {
			struid = "";
		}else {
			int uid = Integer.parseInt(struid);
			Record record = new Record(uid, errorNum, rightNum, subjectId, df.format(day), errorlist.toString());
			recordService.insert(record);
		}
		
		// 清空答题信息记录
		index = 0;
		rightNum = 0;
		errorNum = 0;
		countAnswer = 0;
		choselist.clear();
		return "/msg";
	}

	/**
	 * 随机生成题目
	 * 
	 * @param countNum
	 *            需要生成的题目个数
	 * @param sum
	 *            要生成的题目
	 * @return 题目编号列表
	 */
	private int[] getNumArr1(int countNum, List<SubjectQ1> sumlist) {
		Set<SubjectQ1> set = new HashSet<SubjectQ1>();
		int[] array = new int[countNum];
		int num = 0;
		while(true) {
			num = random.nextInt(sumlist.size()) + 1;
			set.add(sumlist.get(num));
			if (set.size() >= countNum) {
				break;
			}
		}
		int i = 0;
		for (SubjectQ1 a : set) {
			array[i] = a.getId();
			i++;
		}
		return array;
	}
	
	private int[] getNumArr2(int countNum, List<SubjectQ4> sumlist) {
		Set<SubjectQ4> set = new HashSet<SubjectQ4>();
		int[] array = new int[countNum];
		int num = 0;
		while(true) {
			num = random.nextInt(sumlist.size()) + 1;
			set.add(sumlist.get(num));
			if (set.size() >= countNum) {
				break;
			}
		}
		int i = 0;
		for (SubjectQ4 a : set) {
			array[i] = a.getId();
			i++;
		}
		return array;
	}


	
	/**
	 * 将分类选出的题库整合到一个新的数组
	 * @param Arr1
	 * @param Arr2
	 * @return
	 */
	private int[] connectArr1(int[] Arr1, int[] Arr2) {
		int[] tempArr = new int[Arr1.length+Arr2.length];
		int i=0;
		if(i<tempArr.length) {
			for(int m:Arr1) {
				tempArr[i] = m;
				i++; 
			}
			for(int n:Arr2) {
				tempArr[i]=n;
				i++;
			}
		}
		return tempArr;
	}
	private int[] connectArr2(int[] Arr1, int[] Arr2,int[] Arr3) {
		int[] tempArr = new int[Arr1.length+Arr2.length+Arr3.length];
		int i=0;
		if(i<tempArr.length) {
			for(int m:Arr1) {
				tempArr[i] = m;
				i++;
			}
			for(int n:Arr2) {
				tempArr[i] = n;
				i++;
			}
			for(int n:Arr3) {
				tempArr[i] = n;
				i++;
			}
		}
		return tempArr;
	}
}
