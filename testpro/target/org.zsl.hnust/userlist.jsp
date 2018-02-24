<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/subjectlist.css">
</head>
<body>
	<center>
		<h3>用户列表</h3>
		<form action="<%=basePath%>user/getkeywordusers" method="post">
			<input type="text" name="keyWords" /> &nbsp;<input type="submit" value="查询" />
		</form>
		<table border="1" cellpadding="0" cellspacing="0" align="center"
			width="940px">
			<tr>
				<th class="error">操作</th>
				<th class="titlenum">用户编号</th>
				<th class="subject">用户名称</th>
				<th class="answer">性别</th>
				<th class="item1">邮箱</th>
				<th class="item2">登录时间</th>
			</tr>
			<c:if test="${!empty users }">
				<c:forEach items="${users }" var="user">
					<tr>
						<td style="height: 30px; width: 100px"><a
							href="<%=basePath%>user/getuser?id=${user.uid}"
							target="myIframe">编辑</a> <a
							href="<%=basePath%>user/deluser?id=${user.uid}">删除</a></td>
						<td>${user.uid }</td>
						<td>${user.username }</td>
						<td>${user.sex }</td>
						<td>${user.email }</td>
						<td>${user.logTime }</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="6" align="center">
				<a href="<%=basePath%>user/getallusers?pageNo=${1}">首页</a>
				<a href="<%=basePath%>user/getallusers?pageNo=${pageNo-1}">上一页</a>
				<a href="<%=basePath%>user/getallusers?pageNo=${pageNo+1}">下一页</a>
				<a href="<%=basePath%>user/getallusers?pageNo=${endPage}">末页</a></td>
			</tr>
		</table>
	</center>
</body>
<script type="text/javascript">  
    function del(id){  
        $.get("<%=basePath%>user/deluser?id=" + id, function(data) {
			if ("success" == data.result) {
				alert("删除成功");
				window.location.reload();
			} else {
				alert("删除失败");
			}
		});
	}
</script>
</html>