<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOOK圈——跳转登录</title>
<style type="text/css">
	*{
		padding: 0;
		margin: 0;
	}
	.tishi{
		width:500px;
		height: 300px;
		text-align: center;
		font-size: 22px;
		margin: 260px auto; 
	}
	span{
		color: #499afd;
		font-size: 26px;
	}
	p{
		margin: 20px auto;
	}
	a{
		text-decoration: none;
		color: #499afd;
		font-size: 18px;
	}
</style>
</head>
<body>
	<div class="tishi">
		您还没有登录哦！<span id="second">1</span>秒后跳转到登录界面……
		<p><a href="<%=basePath %>login.jsp">立即登录</a></p>
	</div>
</body>
<script type="text/javascript">
	//设定倒数秒数  
	var t = 10;  
	//显示倒数秒数  
	function showTime(){  
    	t -= 1;  
    	document.getElementById('second').innerHTML= t;  
    	if(t==0){  
        	location.href='<%=basePath %>login.jsp';  
    	}  
    	//每秒执行一次,showTime()  
    	setTimeout("showTime()",1000);  
	}    
	//执行showTime()  
	showTime();  
</script>
</html>