<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path1 = request.getContextPath();
	String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path1 + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOOK圈驾考模拟测试平台</title>

    <link href="<%=basePath1%>css/index.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath1%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath1%>css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="<%=basePath1%>css/animate.min.css" rel="stylesheet" media="all">
    <!-- Bootstrap bootstrap-touch-slider Slider Main Style Sheet -->
    <link href="<%=basePath1%>css/bootstrap-touch-slider.css" rel="stylesheet" media="all">
    <link href="<%=basePath1%>css/img_show.css" rel="stylesheet" type="text/css">
</head>
<body>
    <!--首页-->
    <div id="firstPage">

        <!--头部-->
		<%@include file="head.jsp"%>

        <!--内容-->
        <div id="content">

            <!--banner-->
            <div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="5000" >

                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper For Slides -->
                <div class="carousel-inner" role="listbox">

                    <!-- Third Slide -->
                    <div class="item active">

                        <!-- Slide Background -->
                        <img src="<%=basePath1%>images/b1.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>

                        <div class="container">
                            <div class="row">
                                <!-- Slide Text Layer -->
                                <div class="slide-text slide_style_left">
                                    <h1 data-animation="animated zoomInRight">驾考理论模拟测试平台</h1>
                                    <p data-animation="animated fadeInLeft">题库的相似度90%，还原真实考场做题环境</p>
                                    <a href="#" target="_blank" class="btn btn-default" data-animation="animated fadeInLeft">点击查看</a>
                                    <a href="<%=basePath1%>exam.jsp" target="_blank"  class="btn btn-primary" data-animation="animated fadeInRight">我要做题</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End of Slide -->

                    <!-- Second Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="<%=basePath1%>images/b2.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_center">
                            <h1 data-animation="animated flipInX">基础知识理论考试</h1>
                            <p data-animation="animated lightSpeedIn">2017年驾驶员理论考试最新学习资料</p>
                            <a href="#" target="_blank" class="btn btn-default" data-animation="animated fadeInUp">点击查看</a>
                            <a href="<%=basePath%>exam.jsp" target="_blank"  class="btn btn-primary" data-animation="animated fadeInDown">我要练题</a>
                        </div>
                    </div>
                    <!-- End of Slide -->

                    <!-- Third Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="<%=basePath1%>images/p3.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_right">
                            <h1 data-animation="animated zoomInLeft">安全文明驾驶常识考试</h1>
                            <p data-animation="animated fadeInRight">大路考后的安全文明驾驶模拟考试</p>
                            <a href="#" target="_blank" class="btn btn-default" data-animation="animated fadeInLeft">点击查看</a>
                            <a href="<%=basePath%>exam.jsp" target="_blank" class="btn btn-primary" data-animation="animated fadeInRight">我要练题</a>
                        </div>
                    </div>
                    <!-- End of Slide -->


                </div><!-- End of Wrapper For Slides -->

                <!-- Left Control -->
                <a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev">
                    <span class="fa fa-angle-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>

                <!-- Right Control -->
                <a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next">
                    <span class="fa fa-angle-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>

            </div> <!-- End  bootstrap-touch-slider Slider -->


            <!--考试-->
            <div id="exam">

                <!--理论考试显示部分-->
                <div class="exam_show">
                    <!--标题-->
                    <div class="exam_title">
                        <p>LOOK驾驶考试</p>
                        <hr class="exam_line">
                    </div>

                    <!--内容-->
                    <div class="exam_content">
                        <div class="exam_1">
                            <a href="<%=basePath%>subjectpractice/getpractice?subjectnum=${1}&dealId=${1}" target="_blank"">
                                <img src="<%=basePath%>imgs/lc_02.png">
                                <p class="exam_num">科目一</p>
                                <p class="exam_des">驾驶员理论考试</p>
                            </a>
                        </div>
                        <div class="exam_text">
                            <div class="exam_text_1">
                                <a href="<%=basePath%>subjectpractice/getpractice?subjectnum=${1}&dealId=${2}" target="_blank">
                                    <p class="exam_text_p1">科目一</p>
                                    <p class="exam_text_p2">根据公安部123号令，学员需要了解机动车基本知识，掌握道路交通安全法律、法规及道路交通信号的规定。</p>
                                </a>
                            </div>
                            <div class="exam_text_4">
                                <a href="<%=basePath%>subjectpractice/getpractice?subjectnum=${4}&dealId=${2}" target="_blank">
                                    <p class="exam_text_p1">科目四</p>
                                    <p class="exam_text_p2">学员需要掌握安全文明驾驶知识，具备对车辆综合控制能力；熟练掌握一般道路和夜间驾驶方法。</p>
                                </a>
                            </div>
                        </div>
                        
                        <div class="exam_4">
                            <a href="<%=basePath%>subjectpractice/getpractice?subjectnum=${4}&dealId=${1}" target="_blank">
                                <img src="<%=basePath%>imgs/lc_05.png">
                                <p class="exam_num">科目四</p>
                                <p class="exam_des">安全文明驾驶常识考试</p>
                            </a>
                        </div>
                    </div>

                </div>
            </div>
   
        </div>


        <div class="foot">
            <div class="foot_show">
                <p>&nbsp;</p>
                <p class="p1"><a href="#">移动开放平台 | 服务协议 | 权利声明 | 版本更新 | 帮助中心 | 版权投诉</a></p>
                <p class="p2"><a href="#">@2017 All Copyright Reserved By class3 yangxuejia</a></p>
            </div>
        </div>

    </div>
</body>
<script src="<%=basePath1%>js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="<%=basePath1%>js/bootstrap.min.js"></script>
<script src="<%=basePath1%>js/jquery.touchSwipe.min.js"></script>
<script src="<%=basePath1%>js/bootstrap-touch-slider.js"></script>
<script type="text/javascript">
    $('#bootstrap-touch-slider').bsTouchSlider();
</script>
<script src="<%=basePath1%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath1%>js/jquery.indexSlidePattern.js"></script>
<script type="text/javascript">
    $(document).ready(function(e){
        var opt	=	{
            "speed"	:	"normal"		,	//变换速度,三速度可选 slow,normal,fast;
            "by"	:	"mouseover"		,	//触发事件,click或者mouseover;
            "auto"	:	true		,	//是否自动播放;
            "sec"	:	3000	 		//自动播放间隔;
        };
        $("#demo").IMGDEMO(opt);
    });
</script>
</html>