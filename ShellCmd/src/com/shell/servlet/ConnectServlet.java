package com.shell.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.shell.model.ConnectInfo;
import com.shell.model.MsgCode;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/connectserver")
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		System.out.println("get information from client");
		//get information from client
		String host = request.getParameter("host");
		String port = request.getParameter("port");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int i_port = Integer.parseInt(port);
		
		//port must bigger than 0
		if(i_port<=0){
			i_port = 22;
		}
		
		//init connection information
		ConnectInfo coninfo = new ConnectInfo(username, password, host, i_port);
		System.out.println(coninfo.getusername()+ coninfo.getHost()+ coninfo.getport());
				
		int result = getConnection(coninfo);
		switch (result) {
		case 200:
			response.sendRedirect("success.jsp");
			break;
		case 201:
			request.setAttribute("msg", "Connection time out!");
			request.getRequestDispatcher("index_con.jsp").forward(request, response);;
			break;
		default:
			break;
		}
	}

	private int getConnection(ConnectInfo coninfo) {
		
		JSch jsch = new JSch();
		Session session;
		try {
			System.out.println(coninfo.getusername()+ coninfo.getHost()+ coninfo.getport());
			session = jsch.getSession(coninfo.getusername(), coninfo.getHost(), coninfo.getport());
			session.setPassword(coninfo.getPassword());
			UserInfo userInfo = new UserInfo() {
				@Override
				public String getPassphrase() {
					System.out.println("getPassphrase");
					return null;
				}

				@Override
				public String getPassword() {
					System.out.println("getPassword");
					return null;
				}

				@Override
				public boolean promptPassword(String s) {
					System.out.println("promptPassword:" + s);
					return false;
				}

				@Override
				public boolean promptPassphrase(String s) {
					System.out.println("promptPassphrase:" + s);
					return false;
				}

				@Override
				public boolean promptYesNo(String s) {
					System.out.println("promptYesNo:" + s);
					return true;// notice here!
				}

				@Override
				public void showMessage(String s) {
					System.out.println("showMessage:" + s);
				}
			};
			session.setUserInfo(userInfo);
			session.connect(30000); // making a connection with timeout.
			Channel channel = session.openChannel("shell");
			channel.setInputStream(System.in);
			channel.setOutputStream(System.out);
			channel.connect(3 * 1000);
			
			return MsgCode.CONNECTION_OK;
			
		} catch (JSchException e) {
			return MsgCode.CONNECTION_TIME_OUT;			
		}	
	}

}
