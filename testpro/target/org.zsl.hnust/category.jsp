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
			<div class="title">科目${subjectnum}专项练习</div>
			<div class="category1">
				<p class="title_c"><a href="<%=basePath%>subjectspecial/choosecategory?categoryId=${1}">>单项选择题(${choosesum})</a></p>
				<p class="detail">四个选项中只有一个选项为正确选项，选择你认为正确的一项</p>
			</div>
			<div class="category2">
				<p class="title_c"><a href="<%=basePath%>subjectspecial/choosecategory?categoryId=${2}">>判断题(${judgesum })</a></p>
				<p class="detail">判断题目描述是否正确，正确选择A，错误选择B</p>
			</div>
			<div class="category3" id="category3">
				<p class="title_c"><a href="<%=basePath%>subjectspecial/choosecategory?categoryId=${3}">>多项选择题(${dchoosesum })</a></p>
					<p class="detail">选项中有两项及以上满足题目要求，选择你认为正确的选项
				</p>
			</div>
		</div>
	</div>

	<input type="hidden" value="${subjecttag }" id="tag">
	<!--尾部-->
		<%@include file="foot.jsp"%>
</body>
<script type="text/javascript">
	var subject_tag = document.getElementById("tag").value;
	var c3 = document.getElementById("category3");
	if(subject_tag == "block"){
		c3.style.display = "none";
	}
</script>
</html>