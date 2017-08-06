<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	 <div id="head">

            <!--头部上面的定位栏-->
            <div id="headTop">

                <!--定位栏内容显示-->
                <div class="headTop_show">

                    <!--定位-->
                    <!--定位图片-->
                    <div class="location_img">
                        <img src="imgs/location.png">
                    </div>
                    <!--定位的文字-->
                    <div class="location_text">
                        <p style="color: #ffffff">成都
                            <a href="#" style="color: #499afd">[切换]</a>
                        </p>
                    </div>

                    <!--手机二维码-->
                    <div class="phone_text">
                        <a href="#" style="color: #ffffff">手机端查看</a>
                    </div>

                </div>
            </div>

            <!--导航部分-->
            <div id="headnav">

                <!--导航部分显示内容区域-->
                <div class="headnav_show">
                    <!--logo-->
                    <div class="logo">
                        <img src="imgs/logo.png"/>
                    </div>

                    <!--导航条-->
                    <div class="navbar">
                        <ul>
                            <li><a href="index.jsp" style="color: #499afd">首页</a></li>
                            <li><a href="#">我要学车</a></li>
                            <li><a href="exam.jsp">理论题库</a></li>
                            <li><a href="#">经验论坛</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#">在线咨询</a></li>
                        </ul>
                    </div>

                    <!--登录注册-->
                    <div class="login">
                        <a href="#" style="color: #000000">
                        	<%
                        		String showtext;
                        		Object name = session.getAttribute("UserLogin");
                        		if(name == null){
                        			showtext = "登录";
                        		}else{
                        			showtext = "hello!"+(String)name;
                        		}
                        	%>
                        	<%=showtext %>
                        </a>
                        &nbsp;|&nbsp;
                        <a href="#" style="color: #499afd">注册</a>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
</body>
</html>