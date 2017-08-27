<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
    
   </head>
   <frameset rows="13.2%,86.8%">
		<!--导航栏 -->
		<frame src="header1.jsp" noresize="noresize" frameborder="0"/>
		<frameset cols="20%,80%">
			<frame src="teacherList.jsp" noresize="noresize" frameborder="0"/>
			<frame src="teacherPhoto.jsp" name="showframe" frameborder="0"/>
		</frameset>
	
	</frameset>
</html>
