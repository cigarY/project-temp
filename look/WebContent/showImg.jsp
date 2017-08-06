<%@ page import="java.io.*"%>
<%@ page import="java.sql.*, javax.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String  id =null ;
	String value = null;
	  if( request.getParameter("id").equals("sid"))
	  {
		  id = request.getParameter("id");
		  value = request.getParameter("sid");
	  }
	  else 
	  {
		  id = id = request.getParameter("id");
		value  = request.getParameter("tid");
	  }
	    String photoname = request.getParameter("photoname");
	    String db =request.getParameter("db");
	    out.print("**"+photoname);
		//mysql连接 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String URL = "jdbc:mysql://localhost:3306/look?user=root&password=123456";
		Connection con = DriverManager.getConnection(URL);

		//oracle连接 
		//String URL="jdbc:oracle:thin@localhost:1521:orcl2"; 
		//user="system"; 
		//password="manager"; 
		//Connection con = DriverManager.getConnection(URL,user,password); 

		try {
			// 准备语句执行对象 
			Statement stmt = con.createStatement();
			String sql = " SELECT * FROM "+db+" WHERE "+id+"=" + value;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				
				Blob b = rs.getBlob(photoname);
				long size = b.length();
				//out.print(size); 
				byte[] bs = b.getBytes(1, (int) size);
				response.setContentType("image/jpeg");
				OutputStream outs = response.getOutputStream();
				outs.write(bs);
				outs.flush();
				rs.close();
			} else {
				rs.close();
				response.sendRedirect("error.jsp");
			}
		} finally {
			con.close();
		}
	%>
</body>
</html>