<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>管理员</title>
<style>
a{font-size:24px;}
</style>
<style type="text/css">
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-width: 100%;
	background-height: 100%;
	overflow: hidden;
}
</style>
</head>

<body>
	<br>
	<br>
	<br>
	<h1 align="center">管理员页面</h1>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<table align="center">
		<tr align="center">
			<td><a href="Wteacher.do">审核注册的指导老师</a></td>
		</tr>
		<tr align="center">
			<td><a href="Wcompany.do">审核注册的公司用户</a></td>
		</tr>
		<tr align="center">
			<td><a href="Wvideo.do">审核视频</a></td>
		</tr>
		<tr align="center">
			<td><a href="index.jsp">退出</a></td>
		</tr>
	</table>

</body>
</html>
