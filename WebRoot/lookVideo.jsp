<%@page import="com.sdcj.domain.Wvideo"%>
<%@page import="com.sdcj.domain.Teacher"%>
<%@page import="com.sdcj.biz.WvideoBiz"%>
<%@page import="com.sdcj.domain.Video"%>
<%@page import="com.sdcj.biz.VideoBiz"%>
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
<link href="css/video-js.min.css" rel="stylesheet">
<script src="js/video.min.js"></script>
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
	<font style="font-size: 26px;font-family:幼圆 ;">
		<fieldset>
			<legend>查看视频</legend>
			<%
        Teacher  teacher=(Teacher)session.getAttribute("teacher");
        String name=teacher.getTname();
		VideoBiz videoBiz=new VideoBiz();
		Video video=videoBiz.findByTname(name);
		if(video==null){
		   WvideoBiz wvideoBiz=new WvideoBiz();
		   Wvideo wvideo=wvideoBiz.findByTname(name);
		   System.out.println(wvideo);		
		   if(wvideo!=null){	
		       System.out.println(wvideo);		   
           %>
			<script type="text/javascript">
				alert("您的视频还未审核，请耐心等待！");
			</script>
			<%}else { %>
			<script type="text/javascript">
				alert("您还未上传视频！或您的视频审核失败！");
			</script>
			<%
						    }
		}
		else{
		List<Video> videoList=videoBiz.findAll();
		session.setAttribute("videoList", videoList);
		
		%>
		    <c:forEach items="${sessionScope.videoList}" var="video">
			<table width="80%" height="85%" border="1" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td height="80" width="32%" align="center">标题</td>
					<td width="68%" align="center">${video.title }</td>
				</tr>
				<tr>
					<td height="80" align="center">视频</td>
					<td align="center"><video id="example_video_1"
							class="video-js vjs-default-skin" controls preload="none"
							width="550" height="270" poster="videoes/${video.photo }"
							data-setup="{}"> 
							<source src="videoes/${video.video }" type='video/mp4' />
							</td>
				</tr>
			</table><br><br><br>
			</c:forEach>
			<%} %>
		</fieldset>
	</font>

</body>
</html>
