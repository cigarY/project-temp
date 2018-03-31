<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>LOOK圈用户注册</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/head_foot.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/register.css">
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

                    <div class="register_title">
                   		欢迎免费注册!
                   	</div>

                </div>
            </div>

        </div>


		<form action="<%=basePath%>user/doregister" method="post">
		
		<div class="content">
			<div class="msg">
				${msg}
			</div>
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
				<li class="zhuce">
					<input type="submit" name="" value="立即注册">
				</li >
				<li class="zhuce">
					<span>点击立即注册表示您已接受<a href="#">用户协议</a></span>
				</li>
			</ul>
		</div>

		</form>

         <div class="foot">
            <div class="foot_show">
                <p>&nbsp;</p>
                <p class="p1"><a href="#">移动开放平台 | 服务协议 | 权利声明 | 版本更新 | 帮助中心 | 版权投诉</a></p>
                <p class="p2"><a href="#">@2017 All Copyright Reserved By class3 yangxuejia</a></p>
            </div>
        </div>
</body>
</html>