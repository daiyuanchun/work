<%@page import="com.sdcj.domain.Wvideo"%>
<%@page import="com.sdcj.biz.WvideoBiz"%>
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

<title>审核视频</title>
<link href="css/video-js.min.css" rel="stylesheet">
<script src="js/video.min.js"></script>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}
html, body {
	width: 100%;
	height: 100%;
	overflow: hidden;
}
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-width: 100%;
	background-height: 100%;
	overflow: hidden;
}
#Div1 {
	position: absolute;
	left: 20%;
	top: 2%;
	width: 60%;
	height: 100%;
	border: 1px solid #000;
}
#Div2{
    position: absolute;
	left: 0%;
	top: 0%;
	width: 100%;
	height: 90%;
	border: 1px solid #000;
}
#Div3{
    position: absolute;
	left: 0%;
	top: 90%;
	width: 100%;
	height: 10%;
	text-align: center;
	line-height: 56px;
	border: 1px solid #000;
}
</style>
<script type="text/javascript">
	function save() {
		WvideoForm.action = "WvideoAgree.do";
		WvideoForm.submit();
	}
	function tell() {
		WvideoForm.action = "WvideoDisagree.do";
		WvideoForm.submit();
	}
</script>
</head>
<body>
	<div id="Div1">
		<form id="WvideoForm" method="post" action="">
		    <%
		    	WvideoBiz wvideoBIZ=new WvideoBiz();
		    	List<Wvideo> wvideoList=wvideoBIZ.findAll();
		    	if(wvideoList.size()==0){
		    %>
		    <script type="text/javascript">
				alert("您已经审核完视频了！");
				delayURL("admView.jsp", 20);
				function delayURL(url, time) {
					setTimeout("location.href='" + url + "'", time);
				}
			</script>
		    <%
		    	}else{
		    	      Wvideo wvideo=wvideoList.get(0);
		    	      session.setAttribute("wvideo", wvideo);
		    %>
			<div id="Div2">
				<table width="100%" height="100%" border="1" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="80" width="32%" align="center">视频标题</td>
						<td width="68%" align="center"><%=wvideo.getTname() %></td>
					</tr>
					<tr>
						<td height="80" align="center">指导老师</td>
						<td align="center"><%=wvideo.getRname() %></td>
					</tr>
					<tr>
						<td height="80" align="center">视频标题</td>
						<td align="center"><%=wvideo.getTitle() %></td>
					</tr>
					<tr>
						<td align="center">要审核的视频</td>
						<td align="center">
						<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="550" height="270"
      poster="videoes/<%=wvideo.getPhoto()%>"
      data-setup="{}">
    <source src="videoes/<%=wvideo.getVideo()%>" type='video/mp4' />
						</td>
					</tr>
				</table>
			</div>
			<div id="Div3">
				<input type="button" value="同意" onclick="save()"> 
				<input type="button" value="不同意" onclick="tell()"> 
				<a href="admView.jsp">退出</a>
			</div>
			<%} %>
		</form>
	</div>
</body>