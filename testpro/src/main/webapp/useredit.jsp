<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="../css/edit.css">
</head>
<body>
	<div class="edit_box">
		<div class="ehead">
			<h3>编辑用户信息</h3>
		</div>
		<form action="<%=basePath%>user/edituser" method="post"
			target="myIframe" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${user.uid }">
			<div class="econtent">
				<ul>
					<li>
						<div class="tleft">
							<p>用户编号：</p>
						</div>
						<div class="tright">
							<p>${user.uid }</p>
						</div>
					</li>
					<li style="height: 95px; width: inherit;">
						<div class="tleft">
							<p>用户姓名：</p>
						</div>
						<div class="tright">
							<textarea rows="6" cols="40" name="question">${user.username }</textarea>
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>性别：</p>
						</div>
						<div class="tright">
							<input type="text" name="item1" value="${user.sex }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>邮箱：</p>
						</div>
						<div class="tright">
							<input type="text" name="item2" value="${user.email }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>登录时间：</p>
						</div>
						<div class="tright">
							<input type="text" name="item3" value="${user.logTime }">
						</div>
					</li>					
					<li><input
						style="width: inherit; height: inherit; background-color: #499adf; color: #ffffff; border: none;"
						type="submit" value="确认提交"></li>
				</ul>
			</div>
		</form>

	</div>
</body>
</html>