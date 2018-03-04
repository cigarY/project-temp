package com.tpro.look.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpro.look.model.SubjectQ1;
import com.tpro.look.model.SubjectQ4;
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
	
	int choosesum = 0;//单选题数目
	int dchoosesum = 0;//多选题目数
	int judgesum = 0;//判断题数
	
	/**
	 * 获取分类列表，科目一返回单选和判断题目数，科目四返回单选、多选、判断题目数
	 * @param request
	 * @param subjectnum 用户所选科目
	 * @return
	 */
	@RequestMapping("/getcategory")
	public String getCategory(HttpServletRequest request,int subjectnum) {
		String strnum = null;
		String isShow = null;
		subjectId = subjectnum;
		if(subjectId == 1) {
			strnum = "一";
			isShow = "block";
			choosesum = subjectQ1Service.findListOnlyItem3().size();
			judgesum = subjectQ1Service.findListWithoutItem3().size();
		}else if (subjectId == 4) {
			strnum = "四";
			isShow = "show";
			choosesum = subjectQ4Service.findListChoose().size();
			dchoosesum = subjectQ4Service.findListDChoose().size();
			judgesum = subjectQ4Service.findListWithoutItem3().size();
		}else {
			request.setAttribute("msg", "科目选择失败！");
			return "/msg";
		}
		request.setAttribute("choosesum", choosesum);
		request.setAttribute("dchoosesum", dchoosesum);
		request.setAttribute("judgesum", judgesum);
		request.setAttribute("subjecttag", isShow);
		request.setAttribute("subjectnum", strnum);
		return "/category";
	}
	
	/**
	 * 根据选择类型生成相应的题目
	 * @param request
	 * @param categoryId 题目类型id编号(category=1"单选";category=2"判断";category=3"多选")
	 * @return
	 */
	@RequestMapping("/choosecategory")
	public String chooseCategory(HttpServletRequest request, int categoryId) {
		index = 0;
		List<SubjectQ1> subjectQ1list = new ArrayList<>();
		List<SubjectQ4> subjectQ4list = new ArrayList<>();
		if(subjectId == 1) {
			if(categoryId == 1) {
				testNum = choosesum;
				subjectQ1list = subjectQ1Service.findListOnlyItem3();				
			}else if (categoryId == 2) {
				testNum = judgesum;
				subjectQ1list = subjectQ1Service.findListWithoutItem3();
			}else {
				request.setAttribute("msg", "题目类型选择错误！");
				return "msg";
			}
			subjectArr = getSubjectArray1(subjectQ1list);
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(subjectArr[0]);
			request.setAttribute("subject", subjectQ1);
		}else if (subjectId == 4) {
			if(categoryId == 1) {
				testNum = choosesum;
				subjectQ4list = subjectQ4Service.findListChoose();
			}else if (categoryId == 2) {
				testNum = judgesum;
				subjectQ4list = subjectQ4Service.findListWithoutItem3();
			}else if (categoryId == 3) {
				testNum = dchoosesum;
				subjectQ4list = subjectQ4Service.findListDChoose();
			}else {
				request.setAttribute("msg", "题目类型选择错误！");
				return "msg";
			}
			subjectArr = getSubjectArray2(subjectQ4list);
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(subjectArr[0]);
			request.setAttribute("subject", subjectQ4);
		}else {
			request.setAttribute("msg", "科目选择失败！");
			return "msg";
		}
		request.setAttribute("testNum", testNum);
		request.setAttribute("index", index);
		return "category_practice";
	}
	
	/**
	 * 处理用户提交题目信息
	 * @param request
	 * @param control_i
	 * @param answer_i
	 * @return
	 */
	@RequestMapping("/dealcategory")
	public String dealSubjectCategory(HttpServletRequest request, int control_i, String answer_i) {
		index = control_i;
		int wrongnumber = 0;
		int wrongid = 0;
		if (index < 1) {
			index = 0;
		} else if (index >= testNum) {
			index = testNum - 1;
		}
		int tid = subjectArr[index];
		if (subjectId == 1) {
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(tid);
			request.setAttribute("subject", subjectQ1);
			// 用户提交的答案判断
			if (answer_i.equals(subjectQ1.getAnswer())) {
				isTrue = "T";
			} else if(answer_i.equals("0")||null == answer_i){
				isTrue = "N";
			}else {
				isTrue = "F";
				// 统计错题数目，写入数据库用于难题练习
				wrongnumber = subjectQ1.getWrongnumber() + 1;
				wrongid = subjectQ1.getId();
				subjectQ1Service.updateWrongNum(wrongnumber, wrongid);
			}
	
		} else if (subjectId == 4) {
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(tid);
			request.setAttribute("subject", subjectQ4);
			// 用户提交的答案判断
			if (answer_i.equals(subjectQ4.getAnswer())) {
				isTrue = "T";
			}else if(answer_i.equals("0")||null == answer_i){
				isTrue = "N";
			} else {
				isTrue = "F";
				// 统计错题数目，写入数据库用于难题练习
				wrongnumber = subjectQ4.getWrongnumber() + 1;
				wrongid = subjectQ4.getId();
				subjectQ4Service.updateWrongNum(wrongnumber, wrongid);
			}
		}
		request.setAttribute("index", index);
		request.setAttribute("testNum", testNum);
		request.setAttribute("isTrue", isTrue);
		return "/category_practice";
	}

	private int[] getSubjectArray1(List<SubjectQ1> subjectQ1list) {
		int[] temparr = new int[subjectQ1list.size()];
		for(int i=0;i<temparr.length;i++) {
			temparr[i] = subjectQ1list.get(i).getId();
		}
		return temparr;
	}

	private int[] getSubjectArray2(List<SubjectQ4> subjectQ4list) {
		int[] temparr = new int[subjectQ4list.size()];
		for(int i=0;i<temparr.length;i++) {
			temparr[i] = subjectQ4list.get(i).getId();
		}
		return temparr;
	}
}
