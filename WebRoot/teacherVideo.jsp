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
   <font style="font-size: 24px;font-family:幼圆 ;">
   <fieldset>
   <legend>上传视频</legend>
        <p align="center">主要内容是介绍自己所研究的专业的特点，发展前景等等，给孩子们选择专业提供一份真实可靠的建议。</p>
		<form method="post" action="teacherVideo.do" enctype="multipart/form-data">
				<table width="80%" height="100%"  border="1" cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td width="30%" align="center">选择视频</td>
						<td width="70%" align="center">
						<input type="hidden" name="tname" value="${sessionScope.teacher.tname }" />
						<input type="hidden" name="rname" value="${sessionScope.teacher.rname }" />
						<input type="file"  name="view">
						</td>
					</tr>
					<tr>
						<td align="center">视频标题</td>
						<td align="center">
						<input type="text" name="title" value="">
						</td>
					</tr>
					<tr>
						<td align="center">视频封面(一张视频截图)</td>
						<td align="center">
						<input type="file"  name="photo"/>
						</td>
					</tr>
					<tr>
					    <td></td>
						<td align="center">
						<input type="submit" value="上传视频">
						</td>
					</tr>
				</table>
		</form>
   </fieldset>
   </font>
  </body>
</html>
<script type="text/javascript">
var succeed ='<%=request.getParameter("succeed")%>';
if(succeed=='yes'){
    alert("您已上传成功，请等待审核结果！");
}
</script>