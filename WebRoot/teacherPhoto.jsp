<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.fileldset {
	    padding: 10px;
	    margin: 10px;
	    width: 100%;
	height: 100%;
	    color: #333;
	    border: #06c dashed  1px;
}
</style>
</head>
<fieldset>
	<legend>上传照片</legend>
	<table align="center">
		<tr>
			<td><h3>头像</h3></td>
			<td><c:choose>
					<c:when test="${empty sessionScope.teacher.timg}">
						<img src="upimg/head-default-img.png" width="260px"
							height="260px" />&nbsp;&nbsp;
										</c:when>
					<c:otherwise>
						<img src="upimg/${sessionScope.teacher.timg}" width="260px"
							height="260px" />&nbsp;&nbsp;
					</c:otherwise>
				</c:choose></td>
				<td><h3>个人照片</h3></td>
			<td><c:choose>
					<c:when test="${empty sessionScope.teacher.rimg}">
						<img src="upimg/head-default-img.png" width="260px" height="260px" />&nbsp;&nbsp;
										</c:when>
					<c:otherwise>
						<img src="upimg/${sessionScope.teacher.rimg}" width="260px"
							height="260px" />&nbsp;&nbsp;
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<td></td>
			<td><form action="teacherPhoto.do" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="nameForImg"
						value="${sessionScope.teacher.tname}" /> <input type="file"
						name="upimg" /> <input type="submit" name="timgSubmit" value="换一换" />
				</form></td>
				<td></td>
			<td>
				<form action="teacherPhoto.do" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="tnameForPhoto"
						value="${sessionScope.teacher.tname}" /> <input type="file"
						name="photo" /> <input type="submit"  name="rimgSubmit"  value="换一换" />
				</form>
			</td>
		</tr>
		
		
	</table>
</fieldset>
</html>
