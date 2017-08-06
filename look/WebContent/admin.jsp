<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>新闻发布管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
	<div class="head"> 
		<div class="head_show">
			<div class="logo">
				<img src="images/logo.png">
			</div>
			<div class="head_title">
				<p class="title_p">新闻发布管理系统</p>
			</div>
			<div class="login">
				<p class="login_p">管理员：admin</p>
			</div>
		</div>
	</div>

	
	<div class="content">
		<div class="content_show">
			<div class="content_left">
				<ul>
					<a href="admin.jsp"><li>首页</li></a>
					<a href="subjectlist" target="myIframe"><li>查看题库1</li></a>
					<a href="subjectlist2" target="myIframe"><li>查看题库4</li></a>
					<a href="#"><li>用户信息</li></a>
					<a href="#"><li>管理员信息</li></a>
					<a href="#"><li>个人中心</li></a>
				</ul>
			</div>
			<div class="content_right">
				<iframe src="" frameborder=”no” border=”0″ name="myIframe"></iframe>
			</div>
		</div>		
	</div>
	</form>
	<div class="foot">
		<p>@2017 All Copyright Reserved By class3 yangxuejia</p>
	</div>
</body>
</html>