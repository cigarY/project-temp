<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LOOK圈——全真模拟考试</title>
<link rel="stylesheet" type="text/css" href="css/head_foot.css">
<link rel="stylesheet" type="text/css" href="css/exam_test.css">
</head>
<body>
		
	<div class="exam_testpage">
		<!--头部-->
		<%@include file="head.jsp"%>
		
		<input type="hidden" name="control_i">
		<input type="hidden" name="answer_i">
		<input type="hidden" name="submit_i">
					
		<div class="content">
			<div class="content_show">
				<div class="test_contain">
					<div class="test_contain_left">
						<div class="theory_test">
							<fieldset class="local_info">
								<legend>理论考试</legend>
								<span>第${r }考台</span>
							</fieldset>
						</div>
						<div class="candidate_msg">
							<fieldset class="candidate_info">
								<legend>考生信息</legend>
								<div class="photo">
									<img src="">
								</div>
								<div class="msg_text">
									<p>考生姓名：</p>
									<p>考试题数：100题</p>
									<p>考试时间：45分钟</p>
									<p>合格标准：满分100分</p>
									<p>90分及格</p>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="test_contain_right">
						<fieldset class="test_name">
							<legend>考试题目</legend>
							<div class="text_content_con">
								<div class="text_content_top">
									<div class="text_content_left">
										<div class="text_content_lshow">
											<div class="text_question">
												<i>${index+1}.</i>
												<p class="question">${subject.question }</p>
											</div>
											<p>A、${subject.item1 }</p>
											<p>B、${subject.item2 }</p>
											<p id="itemdisplay1">C、${subject.item3 }</p>
											<p id="itemdisplay2">D、${subject.item4 }</p>
										</div>
									</div>
									<div class="text_content_right">
										<div class="text_content_rshow">
											<img src="${subject.url }"> <span><a href="${subject.url }" target="_blank" id="s_img">查看大图</a></span>
										</div>
									</div>
								</div>
								<div class="text_content_btom">
									<div class="text_content_choose">
										<span>请选择：</span>
										<a href="exam_answer?control_i=${index+1 }&answer_i=${1}"><button class="choose" type="button">A</button></a>
										<a href="exam_answer?control_i=${index+1 }&answer_i=${2}"><button class="choose" type="button">B</button></a>
										<a href="exam_answer?control_i=${index+1 }&answer_i=${3}"><button class="choose" type="button" id="itemdisplay3">C</button></a>
										<a href="exam_answer?control_i=${index+1 }&answer_i=${4}"><button class="choose" type="button" id="itemdisplay4">D</button></a>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="test_information">
					<div class="test_information_left">
						<fieldset class="time_less">
							<legend>剩余时间</legend>
							<span>12:00</span>
						</fieldset>
					</div>
					<div class="test_information_right">
						<fieldset class="tishi_msg">
							<legend>提示信息</legend>
							<span id="tishi_span"></span>
						</fieldset>
					</div>
					
					<div class="submit_answer">					
						<a href="exam_test?control_i=${index-1 }&answer_i=${0}"><button class="prev">上一题</button></a>
						<a href="exam_test?control_i=${index+1 }&answer_i=${0}"><button class="next">下一题</button></a>
						<a href="exam_submit?submit_i=${200 }"><button class="hand_test" type="button">交卷</button></a>
					</div>
				</div>
				<div class="test_answer">
					<fieldset class="answer_msg">
						<legend>答题信息</legend>
						<ul>
						<c:forEach var="s"  begin="1" end="${countNum }">
							<li class="tab${s }" id="c_li${s }" onclick="chooseIt(${s })" ><a href="exam_test?control_i=${s-1}">${s }</a></li>
						</c:forEach>
						</ul>
					</fieldset>				
				</div>
			</div>
		</div>

		<!--尾部-->
		<%@include file="foot.jsp"%>
		
		<input type="hidden" name="item3" value="${subject.item3 }" id="getItem">
		<input type="hidden" name="url" value="${subject.url }" id="geturl">
		<input type="hidden" name="isTrue" value="${isTrue }" id="li_show">
		<input type="hidden" name="idx" value="${index }" id="li_choose">
		<input type="hidden" name="idx_next" value="${index+1 }" id="li_next">
	</div>
</body>
<script type="text/javascript">
	
	onload=function(){
		var setItem = document.getElementById("getItem").value;
		var isShow1 = document.getElementById("itemdisplay1"); 
		var isShow2 = document.getElementById("itemdisplay2");
		var isShow3 = document.getElementById("itemdisplay3");
		var isShow4 = document.getElementById("itemdisplay4");
		var showmsg = document.getElementById("tishi_span");
		var seturl = document.getElementById("geturl").value;
				
		if(setItem == ""){
			isShow1.style.display = "none";
			isShow2.style.display = "none";
			isShow3.style.display = "none";
			isShow4.style.display = "none";
			showmsg.innerText = "判断题，请判断对错！对的选A，错的选B";
		}else{
			showmsg.innerText = "选择题，请选择你的答案！";
		}
		if(seturl == ""){
			document.getElementById("s_img").style.display = "none";
		}
		
		var isTrue = document.getElementById("li_show").value;
		var which_li = document.getElementById("li_choose").value;
		var which_next = document.getElementById("li_next").value;
		var setColor = document.getElementById("c_li"+which_li);
		if(isTrue == "T"){
			setColor.style.background = "#499afd";
		}else if(isTrue == "F"){
			setColor.style.background = "#ff0000";
		}else{
			setColor.style.background = "#999999";
		}
		document.getElementById("c_li"+(which_next)).style.background = "#999999";
	}
	
</script>
</html>