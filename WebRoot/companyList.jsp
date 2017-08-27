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
         <a href="companyPhoto.jsp" target=showframe>
         <h3>照片</h3>
         </a>
         <HR>
         <a href="companyBasic.jsp" target=showframe>
         <h3>企业信息</h3>
         </a>
         <HR>
         <a href="companyRecord.do" target=showframe>
         <h3>订单</h3></a>
         <HR>
         <a href="companyPosition.jsp" target=showframe>
         <h3>岗位设置</h3>
         </a>
         <HR>
         <a href="see.do"  target=showframe>
         <h3>查看岗位</h3>
         </a>
         <HR>
         </center>
         </font>
</div>
</body>
  </body>
</html>
