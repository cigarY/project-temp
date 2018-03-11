<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>LOOK圈登录界面</title>
	<link rel="stylesheet" type="text/css" href="css/head_foot.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>	
		<form action="<%=basePath%>user/dologin" method="post">
        <div class="content">
        	<div class="content_show">
				<div class="login_box">
					<div class="login_box_show">
						<p>用户密码登录<span>${msg }</span></p>
						<div class="name"><input type="text" name="username" placeholder="用户名"></div>
						<div class="pwd"><input type="password" name="password" placeholder="密码"></div>
						<div class="tijiao"><button type="submit">确认登录</button></div>
						<div class="reg"><a href="register.jsp">免费注册</a></div>
					</div>
				</div>
        	</div>
        </div>
        </form>
</body>
</html>