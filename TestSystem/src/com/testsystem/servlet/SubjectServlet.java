package com.testsystem.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.testsystem.model.SubjectInfo;
import com.testsystem.service.ISubjectService;
import com.testsystem.service.impl.SubjectServiceImpl1;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet(urlPatterns = { "/subjectlist", "/subjectadd", "/subjectedit", "/subjectdelete" })
@MultipartConfig
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// URL // http://localhost:8080/JdbcStudent/student_list?key=123
		// URI [/student_list]
		String uri = request.getRequestURI();
		if (uri.endsWith("subjectlist")) {
			doSearchSubject(request, response);
		} else if (uri.endsWith("subjectdelete")) {
			doDeleteSubject(request,response);
		}else if(uri.endsWith("subjectadd")){
			doAddSubject(request,response);
		}else if(uri.endsWith("subjectedit")){
			doEditSubject(request,response);
		}
	}

	/**
	 * 编辑题目信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doEditSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid = request.getParameter("id");   // 取学�?
		int id = Integer.parseInt(strid);
		ISubjectService subjectService = new SubjectServiceImpl1();
		try {
			SubjectInfo subjectinfo = subjectService.getSubjectById(id);
			if (subjectinfo == null) {
				request.setAttribute("msg", "找不到指定的题目");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			request.setAttribute("subjectinfo", subjectinfo);
			request.getRequestDispatcher("subjectedit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * 添加学生信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doAddSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("subjectadd.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} 
	}

	/**
	 * 删除题库信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doDeleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid = request.getParameter("id");
		int id = Integer.parseInt(strid);
		ISubjectService subjectService = new SubjectServiceImpl1();
		SubjectInfo subjectinfo = new SubjectInfo();
		subjectinfo.setId(id);
		try {
			boolean ret = subjectService.delete(subjectinfo);
			if (!ret) {
				request.setAttribute("msg", "删除失败");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			response.sendRedirect("subjectlist");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * 查询题库信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doSearchSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = (String) request.getSession().getAttribute("key");

		// 获取传入的页码数
		String strPageNo = request.getParameter("pageNo");
		ISubjectService subjectservice1 = new SubjectServiceImpl1();
		try {
			// 设置查询关键�?
			SubjectInfo condition = new SubjectInfo();
			condition.setQuestion(key);
			int pageNo = 1;// 页数
			if (strPageNo != null && !"".equals(strPageNo)) {
				pageNo = Integer.parseInt(strPageNo);
			}
			// 执行查询
			// 获取总页�?
			int pageCount = subjectservice1.getPageCount(condition, 15);
			System.out.println(pageCount);
			List<SubjectInfo> subjects = subjectservice1.search(condition, 15, pageNo);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("subjects", subjects);
			request.getRequestDispatcher("subjectlist.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// URL // http://localhost:8080/JdbcStudent/student_list?key=123
		// URI [/student_list]
		String uri = request.getRequestURI();
		if (uri.endsWith("subjectlist")) {
			String key = request.getParameter("key");
			request.getSession().setAttribute("key", key);
			doGet(request, response);
		}else if(uri.endsWith("subjectadd")){
			doSubjectAdd(request,response);
		}else if(uri.endsWith("subjectedit")){
			doSubjectEdit(request,response);
		}
	}

	/**
	 * 编辑题目信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doSubjectEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid = request.getParameter("id");
		String question = request.getParameter("question");
		String item1 = request.getParameter("item1");
		String item2 = request.getParameter("item2");
		String item3 = request.getParameter("item3");
		String item4 = request.getParameter("item4");
		String answer = request.getParameter("answer");
		String explains = request.getParameter("explains");
		String strwrongnum = request.getParameter("wrongnumber");
		
		int id = Integer.parseInt(strid);
		int wrongnumber = Integer.parseInt(strwrongnum);
		String path;
		try {
			Part filePart = request.getPart("url");
			if(filePart == null){
				path="";
			}else{
				String fileName = getFileName(filePart);
				path = "upload/imgs/" + fileName;
				// 取绝对路�?
				//String realPath = request.getServletContext().getRealPath(path);
				// 存盘
				//filePart.write(realPath);
			}			
			SubjectInfo subjectinfo = new SubjectInfo(id, question, answer, item1, item2, item3, item4, explains, path, wrongnumber);
			ISubjectService subjectService = new SubjectServiceImpl1();
			boolean ret = subjectService.add(subjectinfo);
			if (ret) {
				response.sendRedirect("subjectlist");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "修改题目错误");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	/**
	 * 添加学生信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doSubjectAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid = request.getParameter("id");
		String question = request.getParameter("question");
		String item1 = request.getParameter("item1");
		String item2 = request.getParameter("item2");
		String item3 = request.getParameter("item3");
		String item4 = request.getParameter("item4");
		String answer = request.getParameter("answer");
		String explains = request.getParameter("explains");
		String strwrongnum = request.getParameter("wrongnumber");
		
		int id = Integer.parseInt(strid);
		int wrongnumber = Integer.parseInt(strwrongnum);
		String path;
		try {
			Part filePart = request.getPart("url");
			System.out.println(filePart);
			if(filePart == null){
				path="";
			}else{
				String fileName = getFileName(filePart);
				path = "upload/imgs/" + fileName;
				// 取绝对路�?
				//String realPath = request.getServletContext().getRealPath(path);
				// 存盘
				//filePart.write(realPath);
			}			
			SubjectInfo subjectinfo = new SubjectInfo(id, question, answer, item1, item2, item3, item4, explains, path, wrongnumber);
			ISubjectService subjectService = new SubjectServiceImpl1();
			boolean ret = subjectService.add(subjectinfo);
			if (ret) {
				response.sendRedirect("subjectlist");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "添加题目错误");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	/**
	 * 获取上传的文件名
	 * @param filePart
	 * @return
	 */
	private String getFileName(Part filePart) {
		if (filePart.getContentType() == null) {
			return null;
		}
		String disposition = filePart.getHeader("content-disposition");
		//content-disposition: form-data; name="域名"; filename="abc.txt"
		int index = disposition.indexOf("filename");
		if (index < 0) {
			return null;
		}
		String filename = disposition.substring(index + 9);
		filename = filename.replace("\"", "");
		// 生成随机文件�?
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
		java.util.Date now = new java.util.Date();
		Random random = new Random();
		int num = random.nextInt(10000);
		String timeName = format.format(now) + num;  // 201705092007181234
		String extName = filename.substring(filename.lastIndexOf('.'));
		
		return timeName + extName;
	}

}
