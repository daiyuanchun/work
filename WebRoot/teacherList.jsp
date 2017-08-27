<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style>
A {text-decoration: NONE} 
</style>
<style type="text/css">
font{
font-size: 24px;
font-family:幼圆 ;
}
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-width: 100%;
	background-height: 100%;
	overflow: hidden;
}
.div1{
    position: absolute;
	left: 0%;
	top: 25%;
	width: 100%;
	height: 100%;
}
.div1 HR{
    FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10);
    width:80%;
    color:#987cb9; 
    SIZE:8;
}
.div1 h3{
   color:black;
}
</style>
</head>

<body>
<div class="div1">
         <center>
         <HR>
         <a href="teacherPhoto.jsp" target=showframe>
         <h3>照片</h3>
         </a>
         <HR>
         <a href="teacherBasic.jsp" target=showframe>
         <h3>基本信息</h3>
         </a>
         <HR>
         <a href="teacherRecord.do" target=showframe>
         <h3>订单</h3></a>
         <HR>
         <a href="teacherVideo.jsp" target=showframe>
         <h3>上传视频</h3>
         </a>
         <HR>
         <a href="lookVideo.jsp" target=showframe>
         <h3>查看视频</h3>
         </a>
         <HR>
         </center>
         </font>
</div>
</body>
  </body>
</html>
