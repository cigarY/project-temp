<%@page import="java.util.List"%>
<%@page import="com.look.model.StudentJudge"%>
<%@page import="com.look.model.TeacherIntroduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="UTF-8">
<head>
<title>教练介绍</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="./css/teacherIntroduStyles.css">
<link rel="stylesheet" type="text/css" href="./css/head_foot.css">
</head>
<body>
	<!--<div class="jkpt-header-top"></div>-->
	<!--<div class="jkpt-header-bar" style="width: 100%;"></div>-->
	<!--<div class="jkpt-header-nav"></div>-->
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
						<p style="color: #ffffff">
							成都 <a href="#" style="color: #499afd">[切换]</a>
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
						<img src="imgs/logo.png" />
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
						<a href="#" style="color: #000000">登录</a> &nbsp;|&nbsp; <a
							href="#" style="color: #499afd">注册</a>
					</div>


					<div class="clear"></div>
				</div>
			</div>

		</div>
		<%
			TeacherIntroduce intro = (TeacherIntroduce) request.getSession().getAttribute("introduce");
		%>
		<div class="jkpt-content-container">
			<div class="jkpt-location">
				<div class="jkpt-location-content"></div>
			</div>
			<div class="jkpt-content">
				<div class="jkpt-index-left">
					<div class="jkpt-te-header">
						<div class="jkpt-te-content">
							<div class="jkpt-pull-left">
								<img src="showImg.jsp?id=tid&tid=<%=intro.getTid()%>&photoname=timg&db=t_introduce"
									title="<%=intro.getTname()%>教练">
							</div>
							<div class="jkpt-pull-center">
								<dl>
									<dt>

										<h1 class="jkpt-te-name"><%=intro.getTname()%></h1>
										<img src="./images/cer-icon.png"><span class="age"><%=intro.getTage()%>年教龄</span>
									</dt>
									<dd class="jkpt-te-price">
										<span class="strong">￥<b><%=intro.getTprice()%></b>起
										</span>
									</dd>
									<dd class="jkpt-te-icon">
										<span class="star"><i style="width: 100%"></i></span>
									</dd>
									<dd class="te-tel">
										<span><i>联系电话：</i><b><%=intro.getTphone()%></b></span> <span><i>所属学校：</i><a
											target="_blank" href="/school/14041/"><%=intro.getTschool()%></a></span>
									</dd>
									<dd class="te-advisory">
										<a class="button" href="#">报名咨询</a>
									</dd>
								</dl>
							</div>
							<div style="height: 0; clear: both;"></div>
						</div>

					</div>
					<div class="jkpt-tab-bar">
						<ul id="tab-bar">

						</ul>

					</div>
					<div style="height: 0; clear: both;"></div>
					<div class="jkpt-tab-content">
						<ul>
							<li class="jkpt-tab-content-introduce" id="t0">
								<div class="tab-content-introheader">
									<h2>教练简介</h2>
								</div>
								<div class="jkpt-tab-content-detail">
									<%=intro.getTsummary()%>
								</div>
							</li>
							<li class="jkpt-tab-content-course" id="t1">
								<div class="course-header">
									<h2>教练班型费用</h2>
								</div>
								<div class="content-detail">
									<table cellpadding="0" cellspacing="0">
										<thead>
											<tr>
												<td style="width: 15%;">课程名称</td>
												<td style="width: 15%;">教学类型</td>
												<td style="width: 15%;">学车费用</td>
												<td style="width: 25%;">备注</td>
											</tr>
										</thead>
										<tbody>
											<tr class="last">
												<td>普通班</td>
												<td>C1</td>
												<td class="course-price">￥4500</td>
												<td class="last"><p>暂无</p></td>
											</tr>
										</tbody>
									</table>
								</div>
							</li>
							<li class="jkpt-tab-content-photos" id="t2">
								<div class="photos-header">
									<h2>教练教学环境</h2>
								</div>
								<div class="photos-details">
									<ul>
										<li><img
											src="showImg.jsp?id=tid&tid=<%=intro.getTid()%>&photoname=tenver1&db=t_introduce"></a>
										</li>
										<li><img
											src="showImg.jsp?id=tid&tid=<%=intro.getTid()%>&photoname=tenver2&db=t_introduce"></a>
										</li>
										<li><img
											src="showImg.jsp?id=tid&tid=<%=intro.getTid()%>&photoname=tenver3&db=t_introduce"></a>
										</li>
										<li><img
											src="showImg.jsp?id=tid&tid=<%=intro.getTid()%>&photoname=tenver4&db=t_introduce"></a>
										</li>
									</ul>
								</div>
							</li>
							<li style="height: 0; clear: both;"></li>
							<li class="jkpt-tab-content-comment" id="t3">
								<div class="comment-header">
									<h2>学员评价</h2>
								</div>
								<div class="comment-detail">
									<div class="comment-detail-header">
										<div class="jkpt-pull-left comment-list-score">
											<dl>
												<dt>
													<span class="strong">5.0</span>分
												</dt>
												<dd>
													<span class="s-score-star"><i class="star5"></i></span>
												</dd>
												<dd>
													共<span class="strong">514</span>人评价
												</dd>
											</dl>

										</div>

										<div class="jkpt-pull-left comment-list-score-detail">

											<ul>
												<li><span class="strong">教学态度</span><span
													class="s-score-star s-score-sm"><i class="star5"></i>
												</span> <span>5分</span></li>
												<li><span class="strong">学车收费</span><span
													class="s-score-star s-score-sm"><i class="star5"></i></span>
													<span>5分</span></li>
												<li><span class="strong">教学技术</span><span
													class="s-score-star s-score-sm"><i class="star5"></i>
												</span><span>5分</span></li>
												<li style="height: 0; clear: both;"></li>
											</ul>
										</div>
										<div style="height: 0; clear: both;"></div>
									</div>
									<div class="jkpt-comment-list">
										<ul>
										<%
										List<StudentJudge> list =(List<StudentJudge>)request.getSession().getAttribute("judges");
										for(StudentJudge judge :list){
										%>
											<li>
												<div>
													<div class="comment-avatar  pull-left">
														<img alt="<%=judge.getSname() %>" src="showImg.jsp?id=sid&sid=<%=judge.getSid()%>&photoname=timg&db=t_judge">
													</div>

													<div class=" comment-content  pull-left">
														<p>
															<span class="c-nickname"><%=judge.getSname() %></span>
														</p>
														<p class="comment-content-detail"><%=judge.getScon() %></p>
														<p class="comment-time"><%=judge.getStime() %></p>
													</div>
													<div style="height: 0; clear: both;"></div>
												</div>
											</li>
											<%} %>
										
										</ul>
									</div>
								</div>
							</li>
						</ul>

					</div>
				</div>
			</div>
			<script type="text/javascript" src="./js/intro.js"></script>
</body>
</html>