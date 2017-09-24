package com.testsystem.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidCodeServlet
 */
@WebServlet("/code")
public class ValidCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 随机生成验证�?
		Random random = new Random(System.currentTimeMillis());
		// 可�?�：0~9a~zA~Z
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int num = random.nextInt(62);
			if (num < 10) {
				builder.append(num);			
			} else if (num < 36) {
				char ch = (char)((num - 10) + 'a');
				builder.append(ch);
			} else {
				char ch = (char)((num - 36) + 'A');
				builder.append(ch);
			}
		}
		String code = builder.toString();
		System.out.println(code);
		// 2. 验证码放入session
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		// 3. 生成验证码图�?
		BufferedImage img = new BufferedImage(80, 30,  BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Times Roman", Font.BOLD, 20));
		g.drawString(code,8, 20);
		g.dispose();
		// 4. 输出图片到客户端
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		ImageIO.write(img, "JPG", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		System.out.println("收到Code�?" + code);
		
		PrintWriter out = response.getWriter();
		
		String codeInSession = (String)request.getSession().getAttribute("code");
		if (codeInSession.equalsIgnoreCase(code)) {
			out.write("ok");
		} else {
			out.write("error");
		}
		out.close();
	}

}
