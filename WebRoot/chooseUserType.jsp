<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选择注册用户类型</title>
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
	<h1 align="center">请选择您要注册的用户类型</h1>
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
			<td><a href="personRegist.jsp">个人用户注册</a></td>
		</tr>
		<tr align="center">
			<td><a href="companyRegist.jsp">企业用户注册</a></td>
		</tr>
		<tr align="center">
			<td><a href="teacherRegist.jsp">指导老师注册</a></td>
		</tr>
		<tr align="center">
			<td><a href="login.jsp">退出</a></td>
		</tr>
	</table>
  </body>
</html>
