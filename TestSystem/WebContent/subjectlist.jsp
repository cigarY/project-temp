<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/subjectlist.css">
</head>
<body>
<center>
	<h3>题目列表</h3>
	<form action="subjectlist" method="post">
	<input type="text" name="key" value="${key }"/>
	<input type="submit" value="查询" />&nbsp;<a href="subjectadd" target="myIframe">添加题目</a>
	</form>
	<table border="1" cellpadding="0" cellspacing="0" align="center" width="940px">
		<tr>
			<th class="error">操作</th>
			<th class="titlenum">题目编号</th>
			<th class="subject">题目</th>
			<th class="answer">答案</th>
			<th class="item1">选项1</th>
			<th class="item2">选项2</th>
			<th class="item3">选项3</th>
			<th class="item4">选项4</th>
			<th class="explains">解释</th>
			<th class="pic">图片</th>
			<th class="error">错题数</th>			
		</tr>
		<c:forEach items="${subjects }" var="subject">
		<tr>
			<td style="height: 30px; width: 100px">
				<a href="subjectedit?id=${subject.id }" target="myIframe">编辑</a>
				<a href="subjectdelete?id=${subject.id }" onclick="return confirmDel();">删除</a>
			</td>
			<td>${subject.id }</td>
			<td>${subject.question }</td>
			<td>${subject.answer }</td>
			<td>${subject.item1 }</td>
			<td>${subject.item2 }</td>
			<td>${subject.item3 }</td>
			<td>${subject.item4 }</td>
			<td>${subject.explains }</td>
			<td>${subject.url }</td>
			<td>${subject.wrongnumber }</td>			
		</tr>
		</c:forEach>
		<tr>
			<td colspan="11" align="center">
			<a href="?pageNo=1">首页</a>
			<a href="?pageNo=${param.pageNo>1?param.pageNo-1:1 }">上一页</a>
			<a href="?pageNo=${param.pageNo<pageCount?param.pageNo+1:pageCount }">下一页</a>
			<a href="?pageNo=${pageCount }">末页</a>
			</td>
		</tr>
	</table>
</center>
</body>
<script type="text/javascript">
function confirmDel() {
	var res = confirm("您确定要删除指定的数据吗？");
	if (res) {
		return true;
	}
	return false;
}
</script>
</html>