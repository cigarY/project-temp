<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOOK圈——驾考服务平台</title>

    <link href="css/index.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="css/animate.min.css" rel="stylesheet" media="all">
    <!-- Bootstrap bootstrap-touch-slider Slider Main Style Sheet -->
    <link href="css/bootstrap-touch-slider.css" rel="stylesheet" media="all">
    <!--<script src="js/index.js"></script>-->
    <link href="css/img_show.css" rel="stylesheet" type="text/css">
</head>
<body>
    <!--首页-->
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
                            <li><a href="#" style="color: #499afd">首页</a></li>
                            <li><a href="teacherShowServlet">我要学车</a></li>
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
                        <img src="images/b1.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>

                        <div class="container">
                            <div class="row">
                                <!-- Slide Text Layer -->
                                <div class="slide-text slide_style_left">
                                    <h1 data-animation="animated zoomInRight">一个驾考服务平台</h1>
                                    <p data-animation="animated fadeInLeft">打造良好的学车环境，更优质的服务</p>
                                    <a href="#" target="_blank" class="btn btn-default" data-animation="animated fadeInLeft">点击查看</a>
                                    <a href="#" target="_blank"  class="btn btn-primary" data-animation="animated fadeInRight">注册报名</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End of Slide -->

                    <!-- Second Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="images/b2.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_center">
                            <h1 data-animation="animated flipInX">高效安全拿驾驶证</h1>
                            <p data-animation="animated lightSpeedIn">一个你值得拥有的LOOK驾考平台</p>
                            <a href="#" target="_blank" class="btn btn-default" data-animation="animated fadeInUp">点击查看</a>
                            <a href="#" target="_blank"  class="btn btn-primary" data-animation="animated fadeInDown">注册报名</a>
                        </div>
                    </div>
                    <!-- End of Slide -->

                    <!-- Third Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="images/p3.jpg" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_right">
                            <h1 data-animation="animated zoomInLeft">找教练、练题、交流</h1>
                            <p data-animation="animated fadeInRight">LOOK可以帮你做到</p>
                            <a href="#" target="_blank" class="btn btn-default" data-animation="animated fadeInLeft">点击查看</a>
                            <a href="#" target="_blank" class="btn btn-primary" data-animation="animated fadeInRight">注册报名</a>
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
                            <a href="#">
                                <img src="imgs/lc_02.png">
                                <p class="exam_num">科目一</p>
                                <p class="exam_des">驾驶员理论考试</p>
                            </a>
                        </div>
                        <div class="exam_2">
                            <a href="#">
                                <img src="imgs/lc_01.png">
                                <p class="exam_num">科目二</p>
                                <p class="exam_des">场地驾驶技能考试</p>
                            </a>
                        </div>
                        <div class="exam_3">
                            <a href="#">
                                <img src="imgs/lc_04.png">
                                <p class="exam_num">科目三</p>
                                <p class="exam_des">机动车驾驶人道路考试</p>
                            </a>
                        </div>
                        <div class="exam_4">
                            <a href="#">
                                <img src="imgs/lc_05.png">
                                <p class="exam_num">科目四</p>
                                <p class="exam_des">安全文明驾驶常识考试</p>
                            </a>
                        </div>
                    </div>

                </div>
            </div>

            <!--LOOK教练排行榜-->
            <div id="teacher">

                <!--显示部分-->
                <div class="teacher_show">
                    <!--标题-->
                    <div class="teacher_title">
                        <p>LOOK排行榜</p>
                        <hr class="teacher_line">
                    </div>

                    <!--内容部分-->
                    <div class="teacher_content">

                        <!--口碑排行-->
                        <div class="talk">
                            <div class="t_title">
                                <p>口碑排行榜<a href="#">更多></a></p>
                            </div>
                            <div class="talk_con">
                                <ul>
                                    <li class="list_top">
                                        <div class="list_num1">1</div>
                                        <div class="list_pic">
                                            <a href="#">
                                                <img src="imgs/bg_img.jpg"/>
                                            </a>
                                         </div>
                                        <div class="list_text">
                                           <a href="#"><p class="text_name">民众驾校</p></a>
                                           <p class="text_p">总学员数：558人</p>
                                           <p class="text_p">地址：乐山师范学院</p>
                                        </div>
                                    </li>
                                    <li class="list_center">
                                        <div class="list_num1">2</div>
                                        <div class="center_name"><a href="#">三和驾校</a></div>
                                        <div class="center_count">118人</div>
                                    </li>
                                    <li class="list_center">
                                        <div class="list_num1">3</div>
                                        <div class="center_name"><a href="#">三和驾校</a></div>
                                        <div class="center_count">118人</div>
                                    </li>
                                    <li class="list_center">
                                        <div class="list_num2">4</div>
                                        <div class="center_name"><a href="#">三和驾校</a></div>
                                        <div class="center_count">118人</div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <!--权威排行-->
                        <div class="power">
                            <div class="t_title">
                                <p>教练权威榜<a href="#">更多></a></p>
                            </div>
                            <div class="pt_con">
                                <ul>
                                    <li>
                                        <div class="pt_num1">1</div>
                                        <div class="pt_img">
                                            <a href="#">
                                                <img src="imgs/bg_img.jpg">
                                            </a>
                                        </div>
                                        <div class="pt_center">
                                            <a href="#"><p class="t_name">黄小明</p></a>
                                            <p class="t_text">学员：90<span class="t_star">xxxxxx</span></p>
                                        </div>
                                    </li>
                                    <li></li>
                                    <li></li>
                                    <li>
                                        <div class="pt_num2">4</div>
                                        <div class="pt_img">
                                            <a href="#">
                                                <img src="imgs/bg_img.jpg">
                                            </a>
                                        </div>
                                        <div class="pt_center">
                                            <a href="#"><p class="t_name">黄小明</p></a>
                                            <p class="t_text">学员：90<span class="t_star">xxxxxx</span></p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <!--综合排行-->
                        <div class="total">
                            <div class="t_title">
                                <p>教练综合榜<a href="#">更多></a></p>
                            </div>
                            <div class="pt_con">
                                <ul>
                                    <li>
                                        <div class="pt_num1">1</div>
                                        <div class="pt_img">
                                            <a href="#">
                                                <img src="imgs/bg_img.jpg">
                                            </a>
                                        </div>
                                        <div class="pt_center">
                                            <a href="#"><p class="t_name">黄小明</p></a>
                                            <p class="t_text">学员：90<span class="t_star">好评：900+</span></p>
                                        </div>
                                    </li>
                                    <li></li>
                                    <li></li>
                                    <li>
                                        <div class="pt_num2">4</div>
                                        <div class="pt_img">
                                            <a href="#">
                                                <img src="imgs/bg_img.jpg">
                                            </a>
                                        </div>
                                        <div class="pt_center">
                                            <a href="#"><p class="t_name">黄小明</p></a>
                                            <p class="t_text">学员：90<span class="t_star">好评：900+</span></p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!--LOOK分享-->
            <div id="about">
                <!--展示框-->
                <div class="about_show">
                    <!--标题-->
                    <div class="about_title">
                        <p>LOOK图片分享</p>
                        <hr class="about_line">
                    </div>
                    <!--内容-->
                    <div class="about_content">
                        <ul id="demo">
                            <li class="active"> <a href="#"><img src="images/1.png"  /></a>
                                <div><a href="#">Picture information1</a></div>
                            </li>
                            <li> <a href="#"><img src="images/2.png"  /></a>
                                <div><a href="#">Picture information2</a></div>
                            </li>
                            <li> <a href="#"><img src="images/3.png"  /></a>
                                <div><a href="#">Picture information3</a></div>
                            </li>
                            <li> <a href="#"><img src="images/4.png"  /></a>
                                <div><a href="#">Picture information4</a></div>
                            </li>
                            <li> <a href="#"><img src="images/5.png"  /></a>
                                <div><a href="#">Picture information5</a></div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <!--LOOK热点话题-->
            <div id="topic">
                <!--显示部分-->
                <div class="topic_show">
                    <!--标题-->
                    <div class="topic_title">
                        <p>LOOK热点话题</p>
                        <hr class="topic_line">
                    </div>
                    <!--内容-->
                    <div class="topic_content">
                        <!--展示的话题-->
                        <div class="topic_display">
                            <ul>
                                <li>
                                    <div class="display_img">
                                        <a href="#"><img src="imgs/bg_img.jpg"/></a>
                                    </div>
                                    <div class="display_text">
                                        <a href="#">
                                            <p class="display_title">我有问题要问？进入环岛用不用开转向灯？</p>
                                        </a>
                                        <div class="display_con">
                                            <div class="display_con_left">
                                                <div class="left_img">
                                                    <img src="imgs/bg_img.jpg">
                                                </div>
                                                <div class="left_text">
                                                    青春已去，我们是否依然！
                                                </div>
                                            </div>
                                            <div class="display_con_right">
                                                <img src="imgs/reply.png" alt="">
                                                <span>1</span>
                                                <img src="imgs/zan.png" alt="">
                                                <span>2</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li></li>
                                <li></li>
                                <li></li>
                                <div class="see_more">
                                    <a href="#">
                                        更多>
                                    </a>
                                </div>
                            </ul>
                        </div>

                    </div>
                </div>

             </div>

        </div>
		
		<%@ include file="foot.jsp"%> 
    </div>
</body>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.touchSwipe.min.js"></script>
<script src="js/bootstrap-touch-slider.js"></script>
<script type="text/javascript">
    $('#bootstrap-touch-slider').bsTouchSlider();
</script>
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.indexSlidePattern.js"></script>
<script language="javascript">
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