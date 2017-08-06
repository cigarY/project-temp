<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="foot">

            <div class="foot_bg">
                <div class="foot_links">
                    <span>友情链接：</span>
                    <p>
                        <span><a href="#">LOOK圈</a></span>
                        <span><a href="#">汽车之家</a></span>
                        <span><a href="#">成都驾校之家</a></span>
                        <span><a href="#">成都二手车交易市场</a></span>
                        <span><a href="#">腾讯汽车</a></span>
                        <span><a href="#">易车网</a></span>
                        <span><a href="#">阿里巴巴</a></span>
                        <span><a href="#">违章查询</a></span>
                        <span><a href="#">车主之家</a></span>
                        <span><a href="#">微软官网</a></span>
                        <span><a href="#">新浪微博</a></span>
                    </p>
                    <p>
                        <span><a href="#">网易</a></span>
                        <span><a href="#">小米官网</a></span>
                        <span><a href="#">百度</a></span>
                        <span><a href="#">新浪汽车</a></span>
                        <span><a href="#">买车网</a></span>
                        <span><a href="#">汽车报价</a></span>
                        <span><a href="#">搜狐</a></span>
                    </p>
                </div>
                <div class="foot_con">
                    <div class="foot_logo">
                        <img src="imgs/logo_foot.png">
                        <p>LOOK圈专注驾考服务</p>
                        <p>提供找教练，练题，技术交流的平台</p>
                        <p>LOOK圈团队期待你们的加入！</p>
                    </div>
                    <div class="about_msg">
                        <span>关于我们</span>
                        <p><a href="#">关于LOOK</a></p>
                        <p><a href="#">加入LOOK</a></p>
                        <p><a href="#">联系我们</a></p>
                    </div>
                    <div class="tel_msg">
                        <span>联系我们</span>
                        <p>地址：乐山师范学院计算机科学与技术专业软件工程</p>
                        <p>电话：123456789</p>
                        <p>Email：123456@163.com</p>
                    </div>
                    <div class="pc_login">
                        <span>LOOK客户端</span>
                        <p class="pc_img">
                            <a href="">
                                <img id="android_img" src="imgs/android1.png" onmouseover="change_img(1)" onmouseout="reset_img(1)">
                                <img id="iphone_img" src="imgs/iphone1.png" onmouseover="change_img(2)" onmouseout="reset_img(2)">
                            </a>
                        </p>
                        <p class="pc_text">
                            <span class="s1">android端</span>
                            <span class="s2">iphone端</span>
                        </p>
                    </div>
                </div>
            </div>

            <div class="foot_right">
                <span>@2017 All Copyright Reserved By LOOKquan.com</span>
            </div>

        </div>
</body>
<script type="text/javascript">
	function change_img(num){
		if(num == 1){
			document.getElementById('android_img').src = "imgs/android2.png";
		}
		if(num == 2){
			document.getElementById('iphone_img').src = "imgs/iphone2.png"
		}
	};

	function reset_img(num){
		if(num == 1){
			document.getElementById('android_img').src = "imgs/android1.png";
		}
		if(num == 2){
			document.getElementById('iphone_img').src = "imgs/iphone1.png";
		}
	};
</script>
</html>