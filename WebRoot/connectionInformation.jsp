<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<STYLE TYPE="text/css">  
    BODY {margin: 50pt}  
    .lianxixinxi{ margin-top: 4px;width: 100px;height: 33px;background: #65c294;border-radius: 10px;}
    .lianxixinxi-line{margin-top: -2px;}
    .message{position: absolute;margin-top: 35px;}
    .message-1{margin-left: 90px;}
    .qq-erweima{margin-top: -180px;margin-left: 390px;}
    .weixin-erweima{margin-top: -180px;margin-left: 640px;}
</STYLE>  
<BODY TOPMARGIN=30 LEFTMARGIN=30 MARGINWIDTH=30 MARGINHEIGHT=30>  
    <div class="lianxixinxi"> <h2><font face="楷体" size="5" color="white">联系信息</font></div></h2>
    <hr class="lianxixinxi-line" color="#65c294" size="2"/>
    <br><br>
    <tr>
    <div class="message">
    	<div class="message-1">
	        <p><font face="宋体" size="4">联系人：代元春</font></p>
	        <p><font face="宋体" size="4">咨询电话：17862925489</font></p>
	        <p><font face="宋体" size="4">Email:265912725@163.com</font></p>
	        <p><font face="宋体" size="4">qq:2065912725</font></p>
	        <p><font face="宋体" size="4">微信：dai2065912725</font></p>
	    </div>
	    <div class="qq-erweima">
	    	<img src="images/QQ.jpg" height="130" width="130" />
	    	<p> <font face="仿宋" size="4">扫我加QQ~</font></p>
	    </div>
	    <div class="weixin-erweima">
	    	<img src="images/weixin.jpg" height="130" width="130" />
	    	<p><font face="仿宋" size="4">扫我加微信~</font></p>
	    </div>
    </div>
</body>
</html>