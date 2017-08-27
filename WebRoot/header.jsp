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

</head>
<body>
	<!--头部-->
	<div class="header">
		<div class="wrap clearfix">
			<div class="">
				<h1 class="logo" style="margin:0;">
					<span></span>
				</h1>
			</div>
			<div class="client_side fl">
				<ul class="main_nav clearfix">

					<c:choose>
						<c:when  test="${empty sessionScope.person}&&${empty sessionScope.teacher }&&${empty sessionScope.company }">
							<li class="fl"><a href="index.jsp">首页</a></li>
							<li class="fl" id="xmdj"><a href="javascript:void(0);">公司排名</a></li>
							<li class="fl" id="irp"><a href="javascript:void(0);">指导老师</a></li>
							<li class="fl"><a href="javascript:void(0);">我的专区</a></li>
							<li class="fl" id="zcxc"><a href="pay.jsp">支付平台</a></li>
							<li class="fl" id="dai"><a href="connectUs.jsp">联系我们</a></li>
						</c:when>
						<c:otherwise>
							<li class="fl"><a href="index.jsp">首页</a></li>
							<li class="fl" id="xmdj"><a href="searchvo.do">公司排名</a></li>
							<li class="fl" id="irp"><a href="search.do">指导老师</a></li>
							<c:if test="${not empty sessionScope.person }">
								<li class="fl"><a href="province.do">我的专区</a></li>
							</c:if>
							<c:if test="${not empty sessionScope.teacher }">
								<li class="fl"><a href="teacherUpdate.do">我的专区</a></li>
							</c:if>
							<c:if test="${not empty sessionScope.company }">
								<li class="fl"><a href="companyUpdate.do">我的专区</a></li>
							</c:if>
							<li class="fl" id="zcxc"><a href="pay.jsp">支付平台</a></li>
							<li class="fl" id="dai"><a href="connectUs.jsp">联系我们</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
			<div class="client_login fl">
				<c:if test="${not empty sessionScope.person }">
					<span class="ueser_box fl"><i class="photo"></i> 
					<c:choose>
					<c:when test="${empty sessionScope.personAdd.pimg}">
					<img class="header_img" src="upimg/head-default-img.png"
						width="32" height="32"> 
					</c:when>
					<c:otherwise>
					<img class="header_img" src="upimg/${sessionScope.personAdd.pimg}"
						width="32" height="32"> 
					</c:otherwise>
					</c:choose>
					</span>
					<p class="fl ueser_cnt">
						<a href="javascript:void(0);">${sessionScope.person.pname}</a>
						&nbsp;&nbsp; <a href="exit.do">退出</a>
					</p>
				</c:if>
				<c:if test="${not empty sessionScope.teacher }">
					<span class="ueser_box fl"> <i class="photo"></i> <img
						class="header_img" src="upimg/${sessionScope.teacher.timg}"
						width="32" height="32">
					</span>
					<p class="fl ueser_cnt">
						<a href="javascript:void(0);">${sessionScope.teacher.tname}</a>
						&nbsp;&nbsp; <a href="exit.do">退出</a>
					</p>
				</c:if>
				<c:if test="${not empty sessionScope.company }">
					<span class="ueser_box fl"> <i class="photo"></i> <img
						class="header_img" src="upimg/${sessionScope.company.cimg}"
						width="32" height="32">
					</span>
					<p class="fl ueser_cnt">
						<a href="javascript:void(0);">${sessionScope.company.cname}</a>
						&nbsp;&nbsp; <a href="exit.do">退出</a>
					</p>
				</c:if>
				<c:if
					test="${empty sessionScope.person &&empty sessionScope.teacher &&empty sessionScope.company }">
					<span class="ueser_box fl"><i class="photo"></i> <img
						class="header_img" src="upimg/head-default-img.png" width="32"
						height="32"> </span>
					<p class="fl ueser_cnt">
						<a href="login.jsp">登录</a> <span>|</span> <a
							href="chooseUserType.jsp">注册</a>
					</p>
				</c:if>

			</div>
			<div class="client_search fl">
		</div>
		</div>
	</div>
	</div>
	<!--end 头部-->
</body>
</html>
