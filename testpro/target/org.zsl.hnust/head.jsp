<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String username = "";
	try{
		username = session.getAttribute("username").toString();
	}catch(Exception e){
		username = "none";
	}
		
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
                            <li class="li1"><a href="<%=basePath%>index.jsp" style="color: #499afd">首页</a></li>
                            <li class="li2"><a href="<%=basePath%>exam.jsp" target="_blank">在线测试</a></li>
                            <li class="li3"><a href="<%=basePath%>subjecttest/getsubjecttest?subjectnum=${1}" target="_blank">科目一</a></li>
                            <li class="li4"><a href="<%=basePath%>subjecttest/getsubjecttest?subjectnum=${4}" target="_blank">科目四</a></li>
                            <li class="li5"><a href="<%=basePath%>personal/personalinfo">个人中心</a></li>              
                        </ul>
                    </div>

                    <!--登录注册-->
                    <div class="login" id="login">
                        <a href="<%=basePath%>login.jsp"><button class="btn1" type="button">登录</button></a>
                        <a href="<%=basePath%>register.jsp"><button class="btn2" type="button">注册</button></a>
                    </div>


                    <div class="clear"></div>
                </div>
            </div>

        </div>
</body>
<script type="text/javascript">
	var name = `<%=username%>`;
	var login_show = document.getElementById("login");
	if(null!=name&&name!="none"){
		login_show.innerHTML = "Hi~"+name;
		login_show.style.color = "#499adf";
	}
</script>
</html>