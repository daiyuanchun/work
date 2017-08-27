<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/video-js.min.css" rel="stylesheet">
    <script src="js/video.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
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
    <style type="text/css">
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
</style>
</head>

<body>
    <c:import url="header.jsp" />
    <center>
    <BR><br><br><br>
	<font style="font-size: 26px;font-family:幼圆 ;">
	<c:choose>
	   <c:when test="${empty sessionScope.vid}">
	        <script type="text/javascript">
	          alert("该指导老师没有视频学习！");
	          delayURL("counselorInformation.jsp",10);
                function delayURL(url, time) {
                    setTimeout("location.href='" + url + "'", time);
                }
	        </script>
	   </c:when>
	   <c:otherwise>
	        <c:forEach items="${sessionScope.videoList}" var="video">
			<table width="80%" height="85%" border="1" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td height="80" width="32%" align="center">标题</td>
					<td width="68%" align="center">${video.title }</td>
				</tr>
				<tr>
					<td height="80" align="center">视频</td>
					<td align="center"><video id="example_video_1"
							class="video-js vjs-default-skin" controls preload="none"
							width="550" height="270" poster="videoes/${video.photo }"
							data-setup="{}"> 
							<source src="videoes/${video.video }" type='video/mp4' />
							</td>
				</tr>
			</table><br><br><br>
			</c:forEach>
	   </c:otherwise>
	</c:choose>
	</font>
    </center>
</body>
</html>
