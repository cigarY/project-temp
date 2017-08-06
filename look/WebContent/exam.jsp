<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>LOOK理论考试练习</title>
<link rel="stylesheet" type="text/css" href="css/head_foot.css">
<link href="css/exam.css" rel="stylesheet" type="text/css">
</head>
<body>

	<!--题库页面-->
	<div id="examPage">

		<!--头部-->
		<%@include file="head.jsp"%>

		<!--内容部分-->
		<div id="content">

			<!--搜索框-->
			<div class="search">
				<form>
					<input class="search_text" type="text" name="search_con"
						placeholder="搜索你要查找的内容……" /> <input class="search_btn"
						type="submit" name="s_btn" value="搜索">
				</form>
			</div>

			<form action="exam" method="get">
				<input type="hidden" name="testNum">
				<!--科目一-->
				<div id="test1">
					<!--科目一内容显示-->
					<div class="test1_show">
						<!--科一显示内容-->
						<div class="test1_text">
							<div class="test_title">
								<a href="#">
									<p class="t_p1">2017年驾驶员理论考试最新学习资料</p>
									<p class="t_p2">科目一 基础知识理论考试</p>
								</a>
							</div>
							<div class="test_msg">
								<h3>阶段目标：</h3>
								<p class="t_p3">根据公安部123号令，学员需要了解机动车基本知识，掌握道路交通安全法律、法规及道路交通信号的规定。</p>
							</div>
							<div class="test_con">
								<ul>
									<li><a href="#"> <img src="imgs/w_01.png" />
											<p class="con_name">顺序练习</p>
											<p class="con_msg">按照顺序练习做题</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_02.png" />
											<p class="con_name">随机练习</p>
											<p class="con_msg">所有法规一个不漏</p>
									</a></li>

									<li><a href="exam?testNum=1"> <img src="imgs/w_03.png" />
											<p class="con_name">全真模拟</p>
											<p class="con_msg">真是还原考题难度</p>
									</a></li>

									<li><a href="#"> <img src="imgs/w_04.png" />
											<p class="con_name">专项练习</p>
											<p class="con_msg">分门别类重点突破</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_05.png" />
											<p class="con_name">难题攻克</p>
											<p class="con_msg">准确把握考试难点</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_06.png" />
											<p class="con_name">章节练习</p>
											<p class="con_msg">按法规章节逐步分类</p>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!--科目四-->
				<div id="test4">
					<!--科目四显示部分-->
					<div class="test4_show">
						<!--科四显示内容-->
						<div class="test4_text">
							<div class="test_title">
								<a href="#">
									<p class="t_p1">大路考后的安全文明驾驶模拟考试</p>
									<p class="t_p2">科目四 安全文明驾驶常识考试</p>
								</a>
							</div>
							<div class="test_msg">
								<h3>阶段目标：</h3>
								<p class="t_p3">了解行人、非机动车的动态特点及险情的预测和分析方法；自觉遵守交通法规，具备综合操纵车辆的能力。</p>
							</div>
							<div class="test_con">
								<ul>
									<li><a href="#"> <img src="imgs/w_01.png" />
											<p class="con_name">顺序练习</p>
											<p class="con_msg">按照顺序练习做题</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_02.png" />
											<p class="con_name">随机练习</p>
											<p class="con_msg">所有法规一个不漏</p>
									</a></li>
									<li><a href="exam?testNum=4"> <img src="imgs/w_03.png" />
											<p class="con_name">全真模拟</p>
											<p class="con_msg">真题还原考题难度</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_04.png" />
											<p class="con_name">专项练习</p>
											<p class="con_msg">分门别类重点突破</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_05.png" />
											<p class="con_name">难题攻克</p>
											<p class="con_msg">准确把握考试难点</p>
									</a></li>
									<li><a href="#"> <img src="imgs/w_06.png" />
											<p class="con_name">章节练习</p>
											<p class="con_msg">按法规章节逐步分类</p>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</form>
			<!--内容下面的讲解-->
			<div id="testMsg">

				<!--讲解显示部分-->
				<div class="testMsg_show">
					<!--三个小模块-->
					<!--考试技巧-->
					<div class="test_skills">
						<!--显示区域-->
						<div class="skills_show">
							<!--图片显示区域-->
							<div class="show_img">
								<a href="#"><img src="imgs/bg_img.jpg"></a>
							</div>
							<!--文字显示区域-->
							<div class="show_text">
								<div class="show_title">
									<p>_____________考试技巧_____________</p>
								</div>
								<ul>
									<li>12:23&nbsp;<a href="#" title="图解2017驾考新规&amp;记分标准">图解2017驾考新规&amp;记分标准</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>

								</ul>
							</div>
						</div>
					</div>
					<!--试题分析-->
					<div class="test_analyse">
						<div class="analyse_show">
							<div class="show_img">
								<a href="#"><img src="imgs/bg_img.jpg"></a>
							</div>
							<!--文字显示区域-->
							<div class="show_text">
								<div class="show_title">
									<p>_____________试题分析_____________</p>
								</div>
								<ul>
									<li>12:23&nbsp;<a href="#" title="图解2017驾考新规&amp;记分标准">图解2017驾考新规&amp;记分标准</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>

								</ul>
							</div>
						</div>
					</div>
					<!--学车视频-->
					<div class="test_video">
						<div class="video_show">
							<div class="show_img">
								<a href="#"><img src="imgs/bg_img.jpg"></a>
							</div>
							<!--文字显示区域-->
							<div class="show_text">
								<div class="show_title">
									<p>_____________学车视频_____________</p>
								</div>
								<ul>
									<li>12:23&nbsp;<a href="#" title="图解2017驾考新规&amp;记分标准">图解2017驾考新规&amp;记分标准</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>
									<li>12:53&nbsp;<a href="#" title="科目二到底怎样踩好离合？三句话让你马上学会！">科目二到底怎样踩好离合？三句话让你马上学会！</a></li>

								</ul>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>

		<%@include file="foot.jsp"%>

	</div>
</body>

<script type="text/javascript">
	function change_img(num) {
		if (num == 1) {
			document.getElementById('android_img').src = "imgs/android2.png";
		}
		if (num == 2) {
			document.getElementById('iphone_img').src = "imgs/iphone2.png";
		}
	};

	function reset_img(num) {
		if (num == 1) {
			document.getElementById('android_img').src = "imgs/android1.png";
		}
		if (num == 2) {
			document.getElementById('iphone_img').src = "imgs/iphone1.png";
		}
	};
</script>
</html>