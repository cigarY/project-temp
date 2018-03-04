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
@RequestMapping("/subjectpractice")
public class SubjectPracticeController {

	@Autowired
	private ISubjectQ1Service subjectQ1Service;
	@Autowired
	private ISubjectQ4Service subjectQ4Service;

	int testNum = 0;// ��Ҫ���ɵ�������
	String isTrue = null;// ��ǰ��Ŀ�Ƿ���ȷ,T��ʾ��ȷ��F��ʾ����
	Random random = new Random();
	int index = 0;// �����±�
	int[] subjectArr = null;// ������Ŀ������
	int subjectId = 0;// ��Ŀ���

	/**
	 * ���ɶ�Ӧ��Ŀ
	 * 
	 * @param request
	 * @param subjectnum
	 * @param dealId
	 * @return
	 */
	@RequestMapping("/getpractice")
	public String getSubjectPractice(HttpServletRequest request, int subjectnum, int dealId) {
		index = 0;
		subjectId = subjectnum;
		if (subjectId == 1) {
			// �Ѷ�
			if (dealId == 5) {
				List<SubjectQ1> subjectQ1slist = subjectQ1Service.getHardTop100();
				testNum = subjectQ1slist.size();
				for (int i = 0; i < testNum; i++) {
					subjectArr[i] = subjectQ1slist.get(i).getId();
				}
			} else {
				testNum = subjectQ1Service.getPageCount();
				subjectArr = getSubjectArr(testNum, dealId);
			}
			SubjectQ1 subjectQ1 = subjectQ1Service.findById(subjectArr[0]);
			request.setAttribute("subject", subjectQ1);
		} else if (subjectId == 4) {
			if (dealId == 5) {
				List<SubjectQ4> subjectQ4slist = subjectQ4Service.getHardTop100();
				testNum = subjectQ4slist.size();
				for (int i = 0; i < subjectQ4slist.size(); i++) {
					subjectArr[i] = subjectQ4slist.get(i).getId();
				}
			} else {
				testNum = subjectQ4Service.getPageCount();
				subjectArr = getSubjectArr(testNum, dealId);
			}
			SubjectQ4 subjectQ4 = subjectQ4Service.findById(subjectArr[0]);
			request.setAttribute("subject", subjectQ4);
		} else {
			request.setAttribute("msg", "������Ŀʧ��!");
			return "/msg";
		}
		request.setAttribute("index", index);
		request.setAttribute("testNum", testNum);
		return "/practice";
	}

	/**
	 * �����û�ѡ����Ϣ
	 * 
	 * @param request
	 * @param control_i
	 * @param answer_i
	 * @return
	 */
	@RequestMapping("/dealpractice")
	public String dealSubjectPractice(HttpServletRequest request, int control_i, String answer_i) {
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
			} else if (answer_i.equals("0") || null == answer_i) {
				isTrue = "N";
			} else {
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
			} else if (answer_i.equals("0") || null == answer_i) {
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
		return "/practice";
	}

	/**
	 * ��ȡ�����ŵ�����
	 * 
	 * @param testnum
	 * @param dealnum
	 * @param subjectlist
	 * @return
	 */
	private int[] getSubjectArr(int testnum, int dealnum) {
		int[] arr = null;
		// ˳��
		if (dealnum == 1) {
			arr = new int[testnum];
			for (int i = 0; i < testnum; i++) {
				arr[i] = i + 1;
			}
		}
		// ���
		if (dealnum == 2) {
			List<Integer> list = new ArrayList<>();
			arr = new int[testnum];
			while (true) {
				int temp = random.nextInt(testnum) + 1;
				if (list.size() <= testnum && !list.contains(temp)) {
					list.add(temp);
				} else {
					break;
				}
			}
			int i = 0;
			for (int a : list) {
				arr[i] = a;
				i++;
			}
		}
		return arr;
	}

}
