<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<style type="text/css">
div#container {
	width: 100%;
}

div#header {
	background-color: #99bbbb;
	height: 90px;
}

div#menu {
	background-color: #EEEEEE;
	top: 10%;
	height: 500px;
	width: 45%;
	float: left;
	float: left;
}

div#content {
	background-color: #EEEEEE;
	height: 500px;
	width: 55%;
	float: left;
}

h1 {
	margin-bottom: 0;
}

h2 {
	margin-bottom: 0;
	font-size: 18px;
}

ul {
	margin: 0;
}

li {
	list-style: none;
}
</style>

<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-1.11.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/jquery.enplaceholder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/base.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/sea.js"></script>
<script type="text/javascript" src="js/base(1).js"></script>
<script src="js/MD5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-validate-1.12.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/validate-common.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="js/check_reg.js"></script>

</head>
<body>
	<center>
		<div id="container">
			<div id="header">
				<c:import url="header.jsp" />
			</div>
			<font style="font-size: 18px;font-family:幼圆 ;">
			<div id="menu">
			<br><br>
					<img src="upimg/${sessionScope.wteacherInformation.rimg}"
						border="0" height="400px" width="400px" float:left;/>
			</div>

			<div id="content">
			        <br/>
			        <br/>
					<br />
					<br /> 姓名：${sessionScope.wteacherInformation.rname}<br />
					<br /> 专业：${sessionScope.wteacherInformation.major}<br />
					<br /> 学校：${sessionScope.wteacherInformation.school}<br />
					<br />
					<br />
			</font> <font style="font-size:24px;font-family:幼圆 ;"> <c:if
					test="${sessionScope.wteacherInformation.wayId.id  eq 3}">
					<a href="videostudy.do"><ins>视频学习</ins></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="form1.jsp"><ins>网上交流</ins></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="form2.jsp"><ins>面对面交流</ins></a>
				</c:if> <c:if test="${sessionScope.wteacherInformation.wayId.id  eq 1}">
				    <a href="videostudy.do"><ins>视频学习</ins></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="form1.jsp"><ins>网上交流</ins></a>
				</c:if> <c:if test="${sessionScope.wteacherInformation.wayId.id  eq 2}">
				    <a href="videostudy.do"><ins>视频学习</ins></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="form2.jsp"><ins>面对面交流</ins></a>
				</c:if>
		  </div>
		
		</font>
	</div>
	</center>
</body>
</html>


