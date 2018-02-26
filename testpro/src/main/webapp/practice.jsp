<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type"  content="text/html;Chartset=UTF-8" />
	<title>LOOK圈——测试练习</title>
	<link rel="stylesheet" type="text/css" href="../css/head_foot.css">
	<link rel="stylesheet" type="text/css" href="../css/practice.css">
</head>
<body>

		<!--头部-->
		<%@include file="head.jsp"%>

        <div class="contains">
        	<div class="contains_show">
        		<div class="contains_top">
        			<div class="contains_top_l">
        				<div class="text_question">
							<i>${index+1}.</i>
							<p class="question">${subject.question }&nbsp;(${index+1}/${testNum })</p>
						</div>
						<p>A、${subject.item1 }</p>
						<p>B、${subject.item2 }</p>
						<p id="itemdisplay1">C、${subject.item3 }</p>
						<p id="itemdisplay2">D、${subject.item4 }</p>
        			</div>
        			<div class="contains_top_r">
        				<div class="text_content_rshow">
							<img src="${subject.url }"><span><a href="${subject.url }" target="_blank" id="s_img">查看大图</a></span>
						</div>
        			</div>
        		</div>
        		<div class="contains_buttom">
        			<div class="right_answer">
        				<p>答案：<span id="is_right"></span>&nbsp;&nbsp;<span id="true_answer"></span></p>
        			</div>
        			<div class="text_content_choose">
						<span>请选择：</span>
						<a href="<%=basePath%>subjectpractice/dealpractice?control_i=${index}&answer_i=${1}"><button class="choose" type="button">A</button></a>
						<a href="<%=basePath%>subjectpractice/dealpractice?control_i=${index}&answer_i=${2}"><button class="choose" type="button">B</button></a>
						<a href="<%=basePath%>subjectpractice/dealpractice?control_i=${index}&answer_i=${3}"><button class="choose" type="button" id="itemdisplay3">C</button></a>
						<a href="<%=basePath%>subjectpractice/dealpractice?control_i=${index}&answer_i=${4}"><button class="choose" type="button" id="itemdisplay4">D</button></a>
					</div>
        		</div>
        		<div class="test_information">
        			<div class="information_l">
        				<details>
							<summary>点击查看解析</summary>
							<p>${subject.explains }</p>
						</details>
        			</div>
        			<div class="submit_answer">					
						<a href="<%=basePath%>subjectpractice/dealpractice?control_i=${index-1 }&answer_i=${0}"><button class="prev">上一题</button></a>
						<a href="<%=basePath%>subjectpractice/dealpractice?control_i=${index+1 }&answer_i=${0}"><button class="next">下一题</button></a>
					</div>
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
		<input type="hidden" name="answer_show" value="${subject.answer }" id="get_answer">
		
</body>
<script type="text/javascript">
	
	onload=function(){
		var setItem = document.getElementById("getItem").value;
		var isShow1 = document.getElementById("itemdisplay1"); 
		var isShow2 = document.getElementById("itemdisplay2");
		var isShow3 = document.getElementById("itemdisplay3");
		var isShow4 = document.getElementById("itemdisplay4");
		var showmsg = document.getElementById("is_right");
		var seturl = document.getElementById("geturl").value;
		var showanswer = document.getElementById("get_answer").value;
		var trueanswer = document.getElementById("true_answer");
		
		if(setItem == ""){
			isShow1.style.display = "none";
			isShow2.style.display = "none";
			isShow3.style.display = "none";
			isShow4.style.display = "none";
		}
		
		if(seturl == ""){
			document.getElementById("s_img").style.display = "none";
		}
		
		
		var isTrue = document.getElementById("li_show").value;
		var which_li = document.getElementById("li_choose").value;
		var which_next = document.getElementById("li_next").value;
		
		if(isTrue == "T"){
			showmsg.innerText = "正确";
			showmsg.style.color = "#499afd";
		}else if(isTrue == "F"){
			showmsg.innerText = "错误";
			showmsg.style.color = "#ff0000";
			if(showanswer == "1"){
				trueanswer.innerText = "正确答案为：A";
			}else if(showanswer == "2"){
				trueanswer.innerText = "正确答案为：B";
			}else if(showanswer == "3"){
				trueanswer.innerText = "正确答案为：C";
			}else if(showanswer == "4"){
				trueanswer.innerText = "正确答案为：D";
			}
		}
		
	}
	
</script>
</html>