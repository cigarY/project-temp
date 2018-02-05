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
<link rel="stylesheet" type="text/css" href="css/edit.css">
</head>
<body>
	<div class="edit_box">
		<div class="ehead">
			<h3>编辑题目</h3>
		</div>
		<form action="<%=basePath%>subject1/editsubject" method="post"
			target="myIframe" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${subject.id }">
			<div class="econtent">
				<ul>
					<li>
						<div class="tleft">
							<p>题目编号：</p>
						</div>
						<div class="tright">
							<p>${subject.id }</p>
						</div>
					</li>
					<li style="height: 95px; width: inherit;">
						<div class="tleft">
							<p>题目：</p>
						</div>
						<div class="tright">
							<textarea rows="6" cols="40" name="question">${subject.question }</textarea>
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>选项1：</p>
						</div>
						<div class="tright">
							<input type="text" name="item1" value="${subject.item1 }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>选项2：</p>
						</div>
						<div class="tright">
							<input type="text" name="item2" value="${subject.item2 }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>选项3：</p>
						</div>
						<div class="tright">
							<input type="text" name="item3" value="${subject.item3 }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>选项4：</p>
						</div>
						<div class="tright">
							<input type="text" name="item4" value="${subject.item4 }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>答案：</p>
						</div>
						<div class="tright">
							<input type="text" name="answer" value="${subject.answer }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>解释：</p>
						</div>
						<div class="tright">
							<input type="text" name="explains"
								value="${subject.explains }">
						</div>
					</li>
					<li>
						<div class="tleft">
							<p>图片：</p>
						</div>
						<div class="tright">
							<input type="file" name="url" value="${subject.url }">
						</div>
					</li>
					<input type="hidden" name="wrongnumber" value="0">
					<li><input
						style="width: inherit; height: inherit; background-color: #499adf; color: #ffffff; border: none;"
						type="submit" value="确认提交"></li>

				</ul>
			</div>
		</form>

	</div>
</body>
</html>