package com.look.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.look.model.SubjectInfo;
import com.look.service.ISubjectService;
import com.look.service.impl.SubjectServiceImpl1;
import com.look.service.impl.SubjectServiceImpl4;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet(urlPatterns = { "/exam", "/exam_test", "/exam_answer", "/exam_submit" })
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Random random = new Random();
	int index = 0;// 题目编号
	int countNum = 0;// 获取题目总数
	int[] testArr = null;// 随机生成的题目数组
	SubjectInfo subject = null;
	ISubjectService subjectservice = null;
	int r = random.nextInt(100) + 1;// 生成随机考号

	int errorNum = 0;// 记录错题数
	int rightNum = 0;// 记录正确题数
	int countAnswer = 0;// 记录答题总数
	int score = 0;// 总得分
	List<Integer> choselist = new ArrayList<>();//存放提交的题目，避免重复提交
	String isTrue = null;//当前题目是否正确,T表示正确，F表示错误
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// URL // http://localhost:8080/JdbcStudent/student_list?key=123
		// URI [/student_list]
		String uri = request.getRequestURI();
		if (uri.endsWith("exam")) {
			getMsgNum(request, response);
		} else if (uri.endsWith("exam_test")) {
			getExamTest(request, response);
		} else if (uri.endsWith("exam_answer")) {
			DealExamAnswer(request, response);
		} else if (uri.endsWith("exam_submit")) {
			SubmitExamTest(request, response);
		}

	}

	/**
	 * 用户交卷处理
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void SubmitExamTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String submitNum = request.getParameter("submit_i");
		// 通过用户选择的科目计算用户的得分
		if (countNum == 100) {
			score = rightNum * 1;
		} else {
			score = rightNum * 2;
		}
		if ("200".equals(submitNum)) {
			out.append("提交成功！您的得分:" + score + "<a href=" + "exam.jsp" + ">");
			out.append("点击返回我的题库");
			out.append("</a>");
			out.close();
		}
		System.out.println(rightNum + "," + errorNum + "," + countAnswer + "," + countNum);
		// 提交之后将所有答案信息变量归零
		rightNum = 0;
		errorNum = 0;
		countAnswer = 0;
		for(int i = 0;i<choselist.size();i++){
			System.out.print(choselist.get(i)+",");
		}
		choselist.clear();//在每次交卷之后清空提交题目数据
	}

	/**
	 * 获取用户返回的答案进行处理 还需要将已经做的题目的编号存放的数组中，防止用户修改答案，重复提交答案
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws Exception
	 */
	private void DealExamAnswer(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		String strAnswer = request.getParameter("answer_i");
				
		/*
		 * int iid = testArr[index - 1]; try { if (countNum == 100) {
		 * subjectservice = new SubjectServiceImpl1(); subject =
		 * subjectservice.getSubjectById(iid); } else { subjectservice = new
		 * SubjectServiceImpl4(); subject = subjectservice.getSubjectById(iid);
		 * } } catch (Exception e) { e.printStackTrace(); }
		 */
		
		isTrue = null;//初始化isTrue的值
		// 用户的答案数目没有达到要求数目时,并且在list中不存在提交的题目编号，并且题目数目小于指定总数目，做相应的自加操作
		if (countAnswer != countNum&&!choselist.contains(index)) {
			choselist.add(index);
			countAnswer++;
			if (strAnswer.equals(subject.getAnswer())) {
				rightNum++;
				isTrue = "T";
			} else {
				errorNum++;
				isTrue = "F";
			}
		}
		//用户已经答题完毕
		if(choselist.size()>countNum){			
			PrintWriter out = response.getWriter();
			out.append("提交成功！您的得分:" + score + "<a href=" + "exam.jsp" + ">");
			out.append("点击返回我的题库");
			out.append("</a>");
			out.close();
		}
		//实现用户每做一道题自动跳转到下一题目
		String strIndex = request.getParameter("control_i");
		index = Integer.parseInt(strIndex);
		// 跳转到下一题目
		if (index >= countNum) {
			index = countNum - 1;
			requestDispatcher(request, response);
		} else {
			requestDispatcher(request, response);
		}
	}

	/**
	 * 获取指定id的题目
	 * 
	 * @param request
	 * @param response
	 */
	private void getExamTest(HttpServletRequest request, HttpServletResponse response) {
		String strIndex = request.getParameter("control_i");
		index = Integer.parseInt(strIndex);

		if (index < 1) {
			index = 0;
			requestDispatcher(request, response);
		} else if (index >= countNum) {
			index = countNum - 1;
			requestDispatcher(request, response);
		} else {
			requestDispatcher(request, response);
		}
	}

	/**
	 * 获取数据库中的必要参数
	 * 
	 * @param request
	 * @param response
	 */
	private void getMsgNum(HttpServletRequest request, HttpServletResponse response) {
				
		String strTestNum = request.getParameter("testNum");
		int testNum = Integer.parseInt(strTestNum);
		System.out.println("选择科目："+testNum);
		index = 0;//每次进入答题界面后将题目编号初始化为0
		if (testNum == 1) {// 如果选择的是科目一
			countNum = 100;// 题目数是100
			subjectservice = new SubjectServiceImpl1();
			try {
				// 获取数据库中的题目总数
				int sum = subjectservice.count();
				// 获取随机题目数组
				testArr = getNumArr(countNum, sum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (testNum == 4) {// 如果选择的是科目一
			countNum = 50;// 题目数是50
			subjectservice = new SubjectServiceImpl4();
			try {
				// 获取数据库中的题目总数
				int sum = subjectservice.count();
				testArr = getNumArr(countNum, sum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		requestDispatcher(request, response);
	}

	/**
	 * 数据初始化转发
	 * 
	 * @param request
	 * @param response
	 */
	private void requestDispatcher(HttpServletRequest request, HttpServletResponse response) {
		int iid = testArr[index];// 初始化id值对应的题号
		try {
			subject = subjectservice.getSubjectById(iid);
			request.setAttribute("r", r);
			request.setAttribute("index", index);
			request.setAttribute("countNum", countNum);
			request.setAttribute("subject", subject);
			request.setAttribute("isTrue", isTrue);
			request.getRequestDispatcher("exam_test.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成指定题目个数的随机数
	 * 
	 * @param countNum
	 *            要生成的题目个数
	 * @param sum
	 *            数据库中一共的题目个数
	 * @return
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
