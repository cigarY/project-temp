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
<title>LOOK圈——个人中心</title>
<link rel="stylesheet" type="text/css" href="../css/personal.css">
<link rel="stylesheet" type="text/css" href="../css/head_foot.css">
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
</head>
<body>

	<!-- 获取图表参数 -->
	<%
		int[] errornum1 = (int[]) request.getAttribute("errornum1");
		int[] rightnum1 = (int[]) request.getAttribute("rightnum1");
		String[] time1 = (String[]) request.getAttribute("time1");
		int[] errornum4 = (int[]) request.getAttribute("errornum4");
		int[] rightnum4 = (int[]) request.getAttribute("rightnum4");
		String[] time4 = (String[]) request.getAttribute("time4");
	%>
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
                            <li class="li1"><a href="<%=basePath%>index.jsp">首页</a></li>
                            <li class="li2"><a href="<%=basePath%>exam.jsp" target="_blank">在线测试</a></li>
                            <li class="li3"><a href="<%=basePath%>subjecttest/getsubjecttest?subjectnum=${1}" target="_blank">科目一</a></li>
                            <li class="li4"><a href="<%=basePath%>subjecttest/getsubjecttest?subjectnum=${4}" target="_blank">科目四</a></li>
                            <li class="li5"><a href="<%=basePath%>personal/personalinfo" style="color: #499afd">个人中心</a></li>              
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
	<div class="head">
		<div class="options">
			<div class="option">
				<a href="">查看错题&nbsp;|</a> <a href="">修改信息</a>
			</div>
		</div>
		<div class="msg">
			<div class="img">
				<img src="<%=basePath%>imgs/login.jpg">
			</div>
			<div class="info">
				<span>${user.username}</span> <span>${user.sex}</span> <span>${user.email}</span>
			</div>
		</div>
	</div>
	<div class="subject_choose">
		<ul>
			<li class="c1">科目一</li>
			<li class="c2">科目四</li>
		</ul>
	</div>
	<div class="contains">
		<div class="sub_score">
			<div class="r_score"></div>
			<div class="e_score"></div>
		</div>
		<div class="h_score">成绩统计</div>
	</div>

	<!--尾部-->
	<%@include file="foot.jsp"%>
</body>

<script type="text/javascript">
	$(".c1").click(function() {
		$(".c1").css("background-color", "#ffffff");
		$(".c1").css("color", "#000000");
		$(".c2").css("background-color", "#499afd");
		$(".c2").css("color", "#ffffff");
	});
	$(".c2").click(function() {
		$(".c2").css("background-color", "#ffffff");
		$(".c2").css("color", "#000000");
		$(".c1").css("background-color", "#499afd");
		$(".c1").css("color", "#ffffff");
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		getEcharts1();
		$(".c1").click(function() {
			getEcharts1();
		});
		$(".c2").click(function() {
			getEcharts2();
		});
	});

	function getEcharts1() {
		// 基于准备好的dom，初始化echarts实例
		var r_score = document.getElementsByClassName("r_score");
		var r_scoreChart = echarts.init(r_score[0]);
		var e_score = document.getElementsByClassName("e_score");
		var e_scoreChart = echarts.init(e_score[0]);
		var h_score = document.getElementsByClassName("h_score");
		var h_scoreChart = echarts.init(h_score[0]);

		// 指定图表的配置项和数据
		var option_r = {
			title : {
				text : '正确题目数统计'
			},
			tooltip : {},
			legend : {
				data : [ '正确题目数' ]
			},
			color : [ '#499afd' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					// 坐标轴指示器，坐标轴触发有效
					type : 'shadow'
				// 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ `<%=time1[0] %>`,
					`<%=time1[1] %>`, 
					`<%=time1[2] %>`,
					`<%=time1[3] %>`,
					`<%=time1[4] %>`,
					`<%=time1[5] %>`,
					`<%=time1[6] %>` ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '正确题目数',
				type : 'bar',
				barWidth : '60%',
				data : [ <%=rightnum1[0] %>,
					<%=rightnum1[1] %>,
					<%=rightnum1[2] %>,
					<%=rightnum1[3] %>,
					<%=rightnum1[4] %>,
					<%=rightnum1[5] %>,
					<%=rightnum1[6] %> ]
			} ]
		};

		var option_e = {
			title : {
				text : '错误题目数统计'
			},
			tooltip : {},
			legend : {
				data : [ '错误题目数' ]
			},
			color : [ '#499afd' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					// 坐标轴指示器，坐标轴触发有效
					type : 'shadow'
				// 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ `<%=time1[0] %>`,
					`<%=time1[1] %>`, 
					`<%=time1[2] %>`,
					`<%=time1[3] %>`,
					`<%=time1[4] %>`,
					`<%=time1[5] %>`,
					`<%=time1[6] %>` ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '错误题目数',
				type : 'bar',
				barWidth : '60%',
				data : [ <%=errornum1[0] %>,
					<%=errornum1[1] %>,
					<%=errornum1[2] %>,
					<%=errornum1[3] %>,
					<%=errornum1[4] %>,
					<%=errornum1[5] %>,
					<%=errornum1[6] %> ]
			} ]
		};

		var option_h = {
			title : {
				text : '近期成绩统计',
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'cross'
				}
			},
			toolbox : {
				show : true,
				feature : {
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [`<%=time1[0] %>`,
					`<%=time1[1] %>`, 
					`<%=time1[2] %>`,
					`<%=time1[3] %>`,
					`<%=time1[4] %>`,
					`<%=time1[5] %>`,
					`<%=time1[6] %>` ],
			},
			yAxis : {
				type : 'value',
				axisLabel : {
					formatter : '{value}'
				},
				axisPointer : {
					snap : true
				}
			},
			visualMap : {
				show : false,
				dimension : 0,
				pieces : [ {
					lte : 6,
					color : 'green'
				}, {
					gt : 6,
					lte : 8,
					color : 'red'
				}, {
					gt : 8,
					lte : 14,
					color : 'green'
				}, {
					gt : 14,
					lte : 17,
					color : 'red'
				}, {
					gt : 17,
					color : 'green'
				} ]
			},
			series : [ {
				name : '成绩',
				type : 'line',
				smooth : true,
				data : [ <%=rightnum1[0] %>,
					<%=rightnum1[1] %>,
					<%=rightnum1[2] %>,
					<%=rightnum1[3] %>,
					<%=rightnum1[4] %>,
					<%=rightnum1[5] %>,
					<%=rightnum1[6] %> ],
				markArea : {
					data : [ [ {
						name : '不及格',
						yAxis : '0'
					}, {
						yAxis : '90'
					} ] ]
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		r_scoreChart.setOption(option_r);
		e_scoreChart.setOption(option_e);
		h_scoreChart.setOption(option_h);
	}

	function getEcharts2() {
		// 基于准备好的dom，初始化echarts实例
		var r_score = document.getElementsByClassName("r_score");
		var r_scoreChart = echarts.init(r_score[0]);
		var e_score = document.getElementsByClassName("e_score");
		var e_scoreChart = echarts.init(e_score[0]);
		var h_score = document.getElementsByClassName("h_score");
		var h_scoreChart = echarts.init(h_score[0]);

		// 指定图表的配置项和数据
		var option_r = {
			title : {
				text : '正确题目数统计'
			},
			tooltip : {},
			legend : {
				data : [ '正确题目数' ]
			},
			color : [ '#499afd' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					// 坐标轴指示器，坐标轴触发有效
					type : 'shadow'
				// 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ `<%=time4[0] %>`,
					`<%=time4[1] %>`, 
					`<%=time4[2] %>`,
					`<%=time4[3] %>`,
					`<%=time4[4] %>`,
					`<%=time4[5] %>`,
					`<%=time4[6] %>`],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '正确题目数',
				type : 'bar',
				barWidth : '60%',
				data : [ <%=rightnum4[0] %>,
					<%=rightnum4[1] %>,
					<%=rightnum4[2] %>,
					<%=rightnum4[3] %>,
					<%=rightnum4[4] %>,
					<%=rightnum4[5] %>,
					<%=rightnum4[6] %> ]
			} ]
		};

		var option_e = {
			title : {
				text : '错误题目数统计'
			},
			tooltip : {},
			legend : {
				data : [ '错误题目数' ]
			},
			color : [ '#499afd' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					// 坐标轴指示器，坐标轴触发有效
					type : 'shadow'
				// 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ `<%=time4[0] %>`,
					`<%=time4[1] %>`, 
					`<%=time4[2] %>`,
					`<%=time4[3] %>`,
					`<%=time4[4] %>`,
					`<%=time4[5] %>`,
					`<%=time4[6] %>` ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '错误题目数',
				type : 'bar',
				barWidth : '60%',
				data : [ <%=errornum4[0] %>,
					<%=errornum4[1] %>,
					<%=errornum4[2] %>,
					<%=errornum4[3] %>,
					<%=errornum4[4] %>,
					<%=errornum4[5] %>,
					<%=errornum4[6] %> ]
			} ]
		};

		var option_h = {
			title : {
				text : '近期成绩统计',
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'cross'
				}
			},
			toolbox : {
				show : true,
				feature : {
					saveAsImage : {}
				}
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [ `<%=time4[0] %>`,
					`<%=time4[1] %>`, 
					`<%=time4[2] %>`,
					`<%=time4[3] %>`,
					`<%=time4[4] %>`,
					`<%=time4[5] %>`,
					`<%=time4[6] %>` ],
			},
			yAxis : {
				type : 'value',
				axisLabel : {
					formatter : '{value}'
				},
				axisPointer : {
					snap : true
				}
			},
			visualMap : {
				show : false,
				dimension : 0,
				pieces : [ {
					lte : 6,
					color : 'green'
				}, {
					gt : 6,
					lte : 8,
					color : 'red'
				}, {
					gt : 8,
					lte : 14,
					color : 'green'
				}, {
					gt : 14,
					lte : 17,
					color : 'red'
				}, {
					gt : 17,
					color : 'green'
				} ]
			},
			series : [ {
				name : '成绩',
				type : 'line',
				smooth : true,
				data : [ <%=rightnum4[0]*2 %>,
					<%=rightnum4[1]*2 %>,
					<%=rightnum4[2]*2 %>,
					<%=rightnum4[3]*2 %>,
					<%=rightnum4[4]*2 %>,
					<%=rightnum4[5]*2 %>,
					<%=rightnum4[6]*2 %> ],
				markArea : {
					data : [ [ {
						name : '不及格',
						yAxis : '0'
					}, {
						yAxis : '90'
					} ] ]
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		r_scoreChart.setOption(option_r);
		e_scoreChart.setOption(option_e);
		h_scoreChart.setOption(option_h);
	}
</script>
</html>