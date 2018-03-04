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

	int testNum = 0;// ������
	String isTrue = null;// ��ǰ��Ŀ�Ƿ���ȷ,T��ʾ��ȷ��F��ʾ����
	Random random = new Random();
	int index = 0;// �����±�
	int[] subjectArr = null;// ������Ŀ������
	int subjectId = 0;// ��Ŀ���
	
	int choosesum = 0;//��ѡ����Ŀ
	int dchoosesum = 0;//��ѡ��Ŀ��
	int judgesum = 0;//�ж�����
	
	/**
	 * ��ȡ�����б���Ŀһ���ص�ѡ���ж���Ŀ������Ŀ�ķ��ص�ѡ����ѡ���ж���Ŀ��
	 * @param request
	 * @param subjectnum �û���ѡ��Ŀ
	 * @return
	 */
	@RequestMapping("/getcategory")
	public String getCategory(HttpServletRequest request,int subjectnum) {
		String strnum = null;
		String isShow = null;
		subjectId = subjectnum;
		if(subjectId == 1) {
			strnum = "һ";
			isShow = "block";
			choosesum = subjectQ1Service.findListOnlyItem3().size();
			judgesum = subjectQ1Service.findListWithoutItem3().size();
		}else if (subjectId == 4) {
			strnum = "��";
			isShow = "show";
			choosesum = subjectQ4Service.findListChoose().size();
			dchoosesum = subjectQ4Service.findListDChoose().size();
			judgesum = subjectQ4Service.findListWithoutItem3().size();
		}else {
			request.setAttribute("msg", "��Ŀѡ��ʧ�ܣ�");
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
	 * ����ѡ������������Ӧ����Ŀ
	 * @param request
	 * @param categoryId ��Ŀ����id���(category=1"��ѡ";category=2"�ж�";category=3"��ѡ")
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
				request.setAttribute("msg", "��Ŀ����ѡ�����");
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
				request.setAttribute("msg", "��Ŀ����ѡ�����");
				return "msg";
			}
			subjectArr = getSubjectArray2(subjectQ4list);
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(subjectArr[0]);
			request.setAttribute("subject", subjectQ4);
		}else {
			request.setAttribute("msg", "��Ŀѡ��ʧ�ܣ�");
			return "msg";
		}
		request.setAttribute("testNum", testNum);
		request.setAttribute("index", index);
		return "category_practice";
	}
	
	/**
	 * �����û��ύ��Ŀ��Ϣ
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
			// �û��ύ�Ĵ��ж�
			if (answer_i.equals(subjectQ1.getAnswer())) {
				isTrue = "T";
			} else if(answer_i.equals("0")||null == answer_i){
				isTrue = "N";
			}else {
				isTrue = "F";
				// ͳ�ƴ�����Ŀ��д�����ݿ�����������ϰ
				wrongnumber = subjectQ1.getWrongnumber() + 1;
				wrongid = subjectQ1.getId();
				subjectQ1Service.updateWrongNum(wrongnumber, wrongid);
			}
	
		} else if (subjectId == 4) {
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(tid);
			request.setAttribute("subject", subjectQ4);
			// �û��ύ�Ĵ��ж�
			if (answer_i.equals(subjectQ4.getAnswer())) {
				isTrue = "T";
			}else if(answer_i.equals("0")||null == answer_i){
				isTrue = "N";
			} else {
				isTrue = "F";
				// ͳ�ƴ�����Ŀ��д�����ݿ�����������ϰ
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
