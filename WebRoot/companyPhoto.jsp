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
					<c:when test="${empty sessionScope.company.cimg}">
						<img src="upimg/head-default-img.png" width="300px" height="300px" />&nbsp;&nbsp;
			        </c:when>
					<c:otherwise>
						<img src="upimg/${sessionScope.company.cimg}" width="300px" height="300px" />&nbsp;&nbsp;
			        </c:otherwise>
				</c:choose></td>
				<td><h3>公司照片</h3></td>
			<td><c:choose>
					<c:when test="${empty sessionScope.company.rimg}">
						<img src="upimg/head-default-img.png" width="300px" height="300px" />&nbsp;&nbsp;
			        </c:when>
					<c:otherwise>
						<img src="upimg/${sessionScope.company.rimg}" width="300px" height="300px" />&nbsp;&nbsp;
			        </c:otherwise>
				</c:choose></td>
	    </tr>
		<tr>
			<td></td>
			<td><form action="companyPhoto.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="cnameForImg" value="${sessionScope.company.cname}" /> 
					<input type="file" name="newCimg" /> 
					<input type="submit"   name="submitForCimg"  value="换一换" />
				</form>
			</td>
			<td></td>
			<td>
				<form action="companyPhoto.do" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="cnameForImg" value="${sessionScope.company.cname}" /> 
					<input type="file" name="newRimg" /> 
					<input type="submit" name="submitForRimg" value="换一换" />
				</form>
			</td>
		</tr>
		
		
	</table>
</fieldset>
</html>
