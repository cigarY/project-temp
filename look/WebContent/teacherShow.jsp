<%@page import="com.look.model.TeacherPower"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="UTF-8">
<head>
	<title>权威教练</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/teacherShowStyles.css">
    <link rel="stylesheet" type="text/css" href="./css/head_foot.css">
</head>
<body>
       <!-- <div id="simple-container"></div> -->
       <!--<div class="jkpt-header-top"></div>-->
       <!--<div class="jkpt-header-bar" style="width: 100%;"></div>-->
       <!--<div class="jkpt-header-nav"></div>-->
       <!--<div class="jkpt-nav-switch"></div>-->
       <div id="firstPage">

           <!--头部-->
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
                           <a href="#" style="color: #000000">登录</a>
                           &nbsp;|&nbsp;
                           <a href="#" style="color: #499afd">注册</a>
                       </div>


                       <div class="clear"></div>
                   </div>
               </div>

           </div>
       <div class="tacher-list">
           <ul class="ul-list">
            <%
              List<TeacherPower> list =  (List<TeacherPower>)request.getSession().getAttribute("TeacherPower");
         
            	  
              for(TeacherPower teacher : list ){  
            %> 
             <li>
                 <div class="jkpt-list-left"><a target="_blank" href="/coach/239179/"><img src="showImg.jsp?id=tid&tid=<%=teacher.getTid()%>&photoname=timg&db=t_power" title="<%=teacher.getTname()%>"></a>
                 </div>
                 <div class="jkpt-list-center">
                     <div class="title"><a href="teacherIntroduServlet?tid=<%=teacher.getTid()%>"><%=teacher.getTname() %></a><span class="age">教龄<%=teacher.getTage()%>年</span></div>
                     <div class="address"><span>驾校距离我<%=teacher.getTdistance()%>km</span></div>
                     <div class="jtaddress"><span><%=teacher.getTschool() %></span></div>
                     <div class="score"><span><%=teacher.getTgrade() %></span></div>
                 </div>
                 <div class="jkpt-list-pirce ">
                       <p><strong><i>￥</i>"<%=teacher.getTprice() %>"</strong><span>起</span></p>
                 </div>
             <div style="height:0; clear:both;" ></div>
                   
             </li>

             <%
            }
             %>
            
               <li >
                  <div class="jkpt-list-left"><a target="_blank" href="/coach/239179/"><img src="./images/teacher03.jpg" title="陈万利"></a>
                 </div>
                 <div class="jkpt-list-center">
                     <div class="title">陈万利<span class="age">教龄8年</span></div>
                     <div class="address"><span>驾校距离我25.0km</span></div>
                     <div class="jtaddress"><span>四川驾校</span></div>
                     <div class="score"><span>5分</span></div>
                 </div>
                 <div class="jkpt-list-pirce ">
                       <p><strong><i>￥</i>"4200"</strong><span>起</span></p>
                 </div>
                 <div style="height:0; clear:both;" ></div>
               </li>
               <li >
                  <div class="jkpt-list-left"><a target="_blank" href="/coach/239179/"><img src="./images/teacher04.jpg" title="鞠文权"></a>
                 </div>
                 <div class="jkpt-list-center">
                     <div class="title">鞠文权<span class="age">教龄9年</span></div>
                     <div class="address"><span>驾校距离我1.6km</span></div>
                     <div class="jtaddress"><span>四川驾校</span></div>
                     <div class="score"><span>5分</span></div>
                 </div>
                 <div class="jkpt-list-pirce ">
                       <p><strong><i>￥</i>"4300"</strong><span>起</span></p>
                 </div>
                 <div style="height:0; clear:both;" ></div>
               </li>
               <li >
                  <div class="jkpt-list-left"><a target="_blank" href="/coach/239179/"><img src="./images/01.png" title="黄志刚"></a>
                 </div>
                 <div class="jkpt-list-center">
                     <div class="title">黄志刚<span class="age">教龄12年</span></div>
                     <div class="address"><span>驾校距离我1.6km</span></div>
                     <div class="jtaddress"><span>四川驾校</span></div>
                     <div class="score"><span>5分</span></div>
                 </div>
                 <div class="jkpt-list-pirce ">
                       <p><strong><i>￥</i>"4500"</strong><span>起</span></p>
                 </div>
                 <div style="height:0; clear:both;" ></div>
               </li>
                <li style="height:0; clear:both;border-bottom:none;"></li>
           </ul>
       </div>
</body>
</html>