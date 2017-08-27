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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
A {
	text-decoration: NONE
}
</style>
</head>

<body bgcolor="#d0d0d0">
	<center>
	
		<HR
			style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)"
			width="80%" color=#987cb9 SIZE=1>
		<a href="messageForPerson.jsp" target=showframe><h3 style="color:black">基本信息设置</h3></a>
		<br>
		<HR
			style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)"
			width="80%" color=#987cb9 SIZE=1>
		<a href="pictureForPerson.jsp" target=showframe><h3 style="color:black">照片设置</h3></a>
		<br>
		<HR
			style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)"
			width="80%" color=#987cb9 SIZE=1>
		<br> <a href="orderForPerson.jsp" target=showframe><h3
				style="color:black">查看订单</h3></a> <br>
		
	</center>
</body>
</html>
