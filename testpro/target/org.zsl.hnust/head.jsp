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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	 <!--头部-->
        <div id="head">

            <!--导航部分-->
            <div id="headnav">

                <!--导航部分显示内容区域-->
                <div class="headnav_show">
                    <!--logo-->
                    <div class="logo">
                        <img src="<%=basePath%>imgs/logo.png"/>
                    </div>

                    <!--导航条-->
                    <div class="navbar">
                        <ul>
                            <li><a href="<%=basePath%>index.jsp" style="color: #499afd">首页</a></li>
                            <li><a href="<%=basePath%>exam.jsp">在线测试</a></li>
                            <li><a href="<%=basePath%>subjecttest/getsubjecttest?subjectnum=${1}">科目一</a></li>
                            <li><a href="<%=basePath%>subjecttest/getsubjecttest?subjectnum=${4}">科目四</a></li>
                            <li><a href="#">个人中心</a></li>              
                        </ul>
                    </div>

                    <!--登录注册-->
                    <div class="login">
                        <a href="login.jsp"><button class="btn1" type="button">登录</button></a>
                        <a href="register.jsp"><button class="btn2" type="button">注册</button></a>
                    </div>


                    <div class="clear">${user.username }</div>
                </div>
            </div>

        </div>
</body>
</html>