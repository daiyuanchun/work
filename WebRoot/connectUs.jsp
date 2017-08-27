<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>

<title>
联系我们
</title>
</head>
<frameset rows="13.2%,86.8%">
		<!--导航栏 -->
		<frame src="header1.jsp" noresize="noresize" frameborder="0"/>
		<frameset cols="20%,80%"">
			<frame src="list.jsp" noresize="noresize" frameborder="0"/>
			<frame src="connectionInformation.jsp" name="showframe" frameborder="0"/>
		</frameset>
	</frameset>
		
</html>