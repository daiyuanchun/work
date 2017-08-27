<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>		

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>遇见网</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel='stylesheet' href='css/meet.css' />
<style type="text/css">
#apDiv2 {
	position: absolute;
	left: 14px;
	top: 14px;
	width: 141px;
	height: 45px;
	z-index: 1;
	background-image: url(images/static/2.jpg);
}

#apDiv1 {
	position: absolute;
	left: 487px;
	top: 30px;
	width: 221px;
	height: 30px;
	z-index: 2;
}

#apDiv3 {
	position: absolute;
	left: 735px;
	top: 31px;
	width: 76px;
	height: 35px;
	z-index: 3;
}

#apDiv4 {
	position: absolute;
	left: 896px;
	top: 25px;
	width: 44px;
	height: 41px;
	z-index: 4;
}

#apDiv5 {
	position: absolute;
	left: 1082px;
	top: 24px;
	width: 46px;
	height: 43px;
	z-index: 5;
}

#apDiv6 {
	position: absolute;
	left: 1141px;
	top: 39px;
	width: 78px;
	height: 26px;
	z-index: 6;
}

.odiv {
	margin-left: 100px;
}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<!-- 导入JQuert-->
<script type="text/javascript" src="js/my.js"></script>
<!-- 导入js代码-->
</head>

<body>
	<!-- LOGO-->
	<!-- 搜索代码结束-->
	<!-- 邮箱代码-->
	<!--用户头像代码-->
	<!-- 用户登录代码-->
	<div class="warp">
		<!--外套-->
		<script type="text/javascript">
			function fun() {
				alert("您好，请您先登录！")
			}
		</script>
		<div class="head">
			<!--导航栏-->
			<div class="logo">
				<img id="img1" src="images/static/logo.png" width="110" height="50" />
			</div>
			<ul>
				<c:if
					test="${(empty  sessionScope.person)&&(empty  sessionScope.teacher)&&(empty  sessionScope.company)}">
					<li><a style="text-decoration:none" href="index.jsp">首页</a></li>
					<li><a style="text-decoration:none" href="#" onclick="fun()">公司排名</a></li>
					<li><a style="text-decoration:none" href="#" onclick="fun()">指导老师</a></li>
					<li><a style="text-decoration:none" href="#" onclick="fun()">个人专区</a></li>
					<li><a style="text-decoration:none" href="pay.jsp">支付平台</a></li>
					<li><a style="text-decoration:none" href="connectUs.jsp">联系我们</a></li>
				</c:if>
				<c:if
					test="${(not empty  sessionScope.person)||(not empty  sessionScope.teacher)||(not empty  sessionScope.company)}">
					<li><a style="text-decoration:none" href="index.jsp">首页</a></li>
					<li><a style="text-decoration:none" href="searchvo.do">公司排名</a></li>
					<li><a style="text-decoration:none" href="search.do">指导老师</a></li>
					<c:if test="${not empty sessionScope.person }">
						<li><a style="text-decoration:none" href="province.do">我的专区</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.teacher }">
						<li><a style="text-decoration:none" href="teacherUpdate.do">我的专区</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.company }">
						<li><a style="text-decoration:none" href="companyUpdate.do">我的专区</a></li>
					</c:if>
					<li><a style="text-decoration:none" href="pay.jsp">支付平台</a></li>
					<li><a style="text-decoration:none" href="connectUs.jsp">联系我们</a></li>
				</c:if>

				<li
					style="width:100px; margin-left:100px; float:left; margin-top:-2px;">
					<a style="text-decoration:none" href="login.jsp">登录</a>| <a
					style="text-decoration:none" href="chooseUserType.jsp">注册</a>
				</li>
			</ul>
			<hr class="daohanglan-fengexian" color="#65C294" size="2" />
		</div>


		<div class="odiv" id="div1">
			<!-- 图片轮播开始-->
			<div id="oImg1">
				<img class="oImg2" src='images/static/slide1.jpg' width='1100px'
					height='550px' style="display:none;" /> <img class="oImg2"
					src='images/static/slide2.jpg' width='1100px' height='550px'
					style="display:none;" /> <img class="oImg2"
					src='images/static/slide3.jpg' width='1100px' height='550px'
					style="display:none;" /> <img class="oImg2"
					src='images/static/slide4.jpg' width='1100px' height='550px'
					style="display:none;" />
			</div>
			<div class="zuo"><</div>
			<div class="you">></div>
			<!-- 图片轮播结束-->


			<div class="div1-xz">
				<!-- 左边选项开始-->
				<div class="div1-xz1">
					<font color="white" face="微软雅黑" size="4">经济学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz1-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">金融数学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">会计学</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">金融学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">财政学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">信用与管理</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验:</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">会计职业体验：<a
									href="index.jsp">公司出纳、收银</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">信用与管理职业体验：<a
									href="index.jsp">保险客服经理、理财管理</a></font>
							</p>
						</div>

					</div>
				</div>
				<hr color="white" size="1" />
				<div class="div1-xz2">
					<font color="white" face="微软雅黑" size="4">法学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz2-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">法学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">法律事务学</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">禁毒学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">社会学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">国际事务与国际关系</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验:</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">法律事务职业体验：<a
									href="index.jsp">模拟案例分析</a></font>
							</p>
						</div>

					</div>
				</div>
				<hr color="white" size="1" />
				<div class="div1-xz3">
					<font color="white" face="微软雅黑" size="4">工学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz3-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">机械设计及其自动化</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">汽车服务工程</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">计算机科学与技术</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">土木工程</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">工程造价</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验:</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">机械制造及其自动化职业体验：<a
									href="index.jsp">车工、钳工</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">汽车服务工程职业体验：<a
									href="index.jsp">汽车销售</a></font>
							</p>

						</div>

					</div>
				</div>
				<hr color="white" size="1" />
				<div class="div1-xz4">
					<font color="white" face="微软雅黑" size="4">理学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz4-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">应用心理学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">资源环境与城市规划管理</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">应用数学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">统计学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">电子信息科学与技术</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验:</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">应用心理学职业体验：<a
									href="index.jsp">心理咨询师</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">电子信息与科学技术职业体验：<a
									href="index.jsp">电脑销售</a></font>
							</p>
						</div>

					</div>
				</div>
				<hr color="white" size="1" />
				<div class="div1-xz5">
					<font color="white" face="微软雅黑" size="4">医学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz5-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">护理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">助产</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.hjsp">中药</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">西药</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">医疗器械维修</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验:</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">护理职业体验：<a
									href="index.jsp">见习护士</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">中药职业体验：<a
									href="index.jsp">药店中药营业员</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">医疗器械维修职业体验：<a
									href="index.jsp">医疗器械维修</a></font>
							</p>
						</div>
					</div>
				</div>
				<hr color="white" size="1" />
				<div class="div1-xz6">
					<font color="white" face="微软雅黑" size="4">文学/哲学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz6-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">播音与主持</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">编辑出版学</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">汉语言文学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">西方哲学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">表演学</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验:</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">编辑出版学职业体验：<a
									href="index.jsp">报社排版员</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">播音与主持职业体验：<a
									href="index.jsp">活动主持</a></font>
							</p>
						</div>
					</div>
				</div>
				<hr color="white" size="1" />
				<div class="div1-xz7">
					<font color="white" face="微软雅黑" size="4">教育&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&raquo;</font>
					<div class="div1-xz7-1">
						<div class="subject-guide">
							<p class="subject-guide-text">
								<font face="微软雅黑" size="4" color="#000000">专业指导:</font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">学前教育</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">特殊教育</a></font>
							</p>
							<p class="subject-guide-text1">
								<font face="楷体" color="#000000" size="4"><a
									href="index.jsp">运动人体科学</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">运动体育</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="index.jsp">教育学</a></font>
							</p>
						</div>
						<div class="job-experience">
							<p class="job-experience-text">
								<font face="微软雅黑" size="4" color="#000000">职业体验：</font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">学前教育职业体验：<a
									href="index.jsp">见习幼儿指导</a></font>
							</p>
							<p class="job-experience-text1">
								<font face="楷体" color="#000000" size="4">特殊教育职业体验：<a
									href="index.jsp">见习特殊儿童辅助</a></font>
							</p>
						</div>
					</div>
				</div>

			</div>
			<!-- 左边选项结束-->


			<div class="div-yuan1">
				<!-- 图片轮播圆点开始-->
				<div class="div-yuan2 div-yuan1-ys"></div>
				<div class="div-yuan2"></div>
				<div class="div-yuan2"></div>
				<div class="div-yuan2"></div>
			</div>
			<!-- 图片轮播圆点结束-->
		</div>

		<div class="lianxiwomen">
			<!--客服悬浮框-->
			<a href="indexjsp" target="new" title="点击联系客服"><img
				src="images/static/server.jpg" class="kefu" width="80px"
				height="75px"></img></a> <a href="index.jsp" target="new" title="点击联系客服"><img
				src="images/static/dianhua.jpg" class="kefu" width="80px"
				height="75px"></img></a> <a href="index.jsp" target="new" title="点击联系客服"><p
					class="kefu-text">
					<font face="楷体" color="white" size="4">联系客服</font>
				</p></a>
		</div>

		<div class="announcement-freeVidio">
			<!--通知公告，免费视频体验区-->
			<div class="announcement-text">
				<br />
				<p>
					<font face="微软雅黑" color="white" size="4">&nbsp;&nbsp;通</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="4">&nbsp;&nbsp;知</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="4">&nbsp;&nbsp;公</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="4">&nbsp;&nbsp;告</font>
				</p>
			</div>
			<div class="announcement">
				<!--通知公告-->
				<ul>
					<li>·<a href="#">关于本网站招聘信息文件以及报名方式</a></li>
					<li>·<a href="#">请大家认准官方网站，以免造成不必要的损失</a></li>
					<li>·<a href="#">有关职业体验注意事项</a></li>
					<li>·<a href="#">新手必备：新手秘籍</a></li>
					<li>·<a href="#">关于导师专业指导的说明</a></li>
					<li>·<a href="#">请注意网站文明，禁止传播不文明的信息</a></li>
					<li style="text-align:right"><a href="#">更多</a><</li>
				</ul>
			</div>
			<div class="freeVidio-text">
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;免</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;费</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;视</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;频</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;体</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;验</font>
				</p>
				<p>
					<font face="微软雅黑" color="white" size="3">&nbsp;&nbsp;区</font>
				</p>
			</div>
			<div class="freeVidio">
				<!--免费视频体验区-->
				<ul>
					<li>·<a href="#">2016最新专业前景分析</a></li>
					<li>·<a href="#">金融行业专业就业汇总</a></li>
					<li>·<a href="#">有关志愿选择的技巧</a></li>
					<li>·<a href="#">未来有无限可能，未来遇见更好的你</a></li>
					<li>·<a href="#">就是要站在巨人的肩膀上</a></li>
					<li>·<a href="#">我说你行，你就行！</a></li>
					<li style="text-align:right"><a href="#">更多</a><</li>
					<!--点击更多出现搜索页面-->
				</ul>
			</div>
		</div>
		<!--通知公告，免费视频体验区结束-->


		<div class='div-zy'>
			<!-- 推荐视频-->
			<hr color="#65c294" size="3" />
			<div class="vidio-text">
				<p>
					<font color="white" face="楷体" size="4">视频推荐</font>
				</p>
			</div>
			<div class="div-zy-tp">
				<a href="shipin1.html" target="new"><img
					src="images/static/shipin1.jpg" width="180px" height="120px"
					title="点击观看"> </img></a> <a href="shipin1.html" class="vidio1-text"
					target="new"><font face="微软雅黑" size="3">大学专业介绍及志愿填报</font></a>
			</div>
			<div class="div-zy-tp">
				<a href="shipin2.html" target="new"><img
					src="images/static/shipin2.jpg" width="180px" height="120px"
					title="点击观看"> </img></a> <a href="shipin2.html" class="vidio1-text"
					target="new"><font face="微软雅黑" size="3">高考志愿填报和大学规划</font></a>
			</div>
			<div class="div-zy-tp">
				<a href="shipin3.html" target="new"><img
					src="images/static/shipin3.jpg" width="180px" height="120px"
					title="点击观看"> </img></a> <a href="shipin3.html" class="vidio1-text"
					target="new"><font face="微软雅黑" size="3">天津理工大学专业介绍</font></a>
			</div>
			<div class="div-zy-tp">
				<a href="shipin4.html" target="new"><img
					src="images/static/shipin4.jpg" width="180px" height="120px"
					title="点击观看"> </img></a> <a href="shipin4.html" class="vidio1-text"
					target="_blank"><font face="微软雅黑" size="3">填报志愿的智慧</font></a>
			</div>
		</div>
		<!-- 推荐视频结束-->
		<div class="link">
		    <hr color="#65c294" size="3" />
			<div class="vidio-text">
				<p>
					<font color="white" face="楷体" size="4">公司推荐</font>
				</p>
			</div>
			<p class="link-text">
				<font face="微软雅黑" size="4" color="#999999"> &bull;&nbsp;<a
					href="http://talent.baidu.com/external/baidu/index.html">百度招聘</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull;&nbsp;<a
					href="https://job.alibaba.com/zhaopin/index.htm">阿里巴巴</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull;&nbsp;<a
					href="http://job.10086.cn/">中国移动</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull;&nbsp;<a
					href="http://career.cmbchina.com/">招商银行</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull;&nbsp;<a
					href="http://hr.tencent.com/">腾讯招聘</a>
				</font>
			</p>

		</div>
</body>
</html>
