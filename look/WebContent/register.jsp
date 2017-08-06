<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>LOOK圈用户注册</title>	
	<link rel="stylesheet" type="text/css" href="css/head_foot.css">
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>

	<%@ include file="head.jsp"%>
		<form action="regist" method="post">
				
		<div class="content">
			<div class="msg">${msg }</div>
			<ul>
				<li>
					<div class="point_msg"><span>用户名：</span></div>
					<div class="input_box"><input type="text" name="username" required></div>
				</li>
				<li>
					<div class="point_msg"><span>密码：</span></div>
					<div class="input_box"><input type="password" name="password" required></div>
				</li>				
				<li>					
					<div class="point_msg"><span>确认密码：</span></div>
					<div class="input_box"><input type="password" name="besurepwd" required></div>
				</li>
				<li>
					<div class="point_msg"><span>邮箱：</span></div>
					<div class="input_box"><input type="email" name="email" required></div>
				</li>
				<li>
					<div class="point_msg"><span>性别：</span></div>
					<div class="radio_box">
						<input class="sex1" type="radio" name="sex" checked value="男">
						<span>男</span>
						<input class="sex2" type="radio" name="sex" value="女">
						<span>女</span>
					</div>
				</li>
				<li>
					<div class="point_msg"><span>验证码：</span></div>
					<div class="code_box">
					<input name="code" onkeyup="return sendValidCode(this.value);"/>
					<span id="result"></span>
					<img src="code"/>
					</div>
				</li>
				<li class="zhuce">
					<input type="submit" name="code" value="立即注册">
				</li >
				<li class="zhuce">
					<span>点击立即注册表示您已接受<a href="#">用户协议</a></span>
				</li>
			</ul>
		</div>

		</form>

        <%@ include file="foot.jsp"%>

</body>
<script type="text/javascript">
var xmlHttpRequest;

function createHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		//alert("OK IE");
	} else if (window.XMLHttpRequest) {
		xmlHttpRequest = new window.XMLHttpRequest();
		//alert("OK not IE");
	} else {
		alert("Cannot Create HttpRequest");
		return;
	}
}

function doResult() {
	if (xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200) {
		var rsp = xmlHttpRequest.responseText;
		var result = document.getElementById("result");
		if (rsp=="ok") {
			result.innerHTML = "<font color='green'>OK</font>";
		} else {
			result.innerHTML = "<font color='red'>ERROR</font>";
		}
	}
}

function sendCodeToServer(code) {
	xmlHttpRequest.onreadystatechange=doResult;
	xmlHttpRequest.open("POST", "code?code=" + code);
	xmlHttpRequest.send();
}

function sendValidCode(code) {
	if (code.length==5) {
		sendCodeToServer(code);
	}
}

createHttpRequest();
</script>
</html>