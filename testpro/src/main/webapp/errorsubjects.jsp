<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head lang="en">
<meta http-equiv="Content-Type"  content="text/html;Chartset=UTF-8" />
<title>LOOK圈——专项练习</title>
<link rel="stylesheet" type="text/css" href="../css/head_foot.css">
<link rel="stylesheet" type="text/css" href="../css/category.css">
</head>
<body>
	<!--头部-->
	<%@include file="head.jsp"%>

	<div class="contains">
		<div class="contains_show">
			<div class="title">科目一错题集</div>
			<div class="category1">
				<p class="title_c"><a href="<%=basePath%>personal/showerrorsubjects?subjectnum=${1}">>点击查看(${err1size})</a></p>
				<p class="detail">每题一分哦！</p>
			</div>
			<div class="title">科目四错题集</div>
			<div class="category2">
				<p class="title_c"><a href="<%=basePath%>personal/showerrorsubjects?subjectnum=${4}">>点击查看(${err4size })</a></p>
				<p class="detail">每题两分哦！</p>
			</div>			
		</div>
	</div>

	<!--尾部--> 
		<%@include file="foot.jsp"%>
</body>

</html>