<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<base href="<%=basePath%>">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-1.11.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/jquery.enplaceholder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/base.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/sea.js"></script>
<script type="text/javascript" src="js/base(1).js"></script>
<script src="js/MD5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-validate-1.12.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/validate-common.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="js/check_reg.js"></script>

</head>
<body>
<fieldset>

							<legend>上传照片</legend>
							<table border="0" >
							<tr>
								<td><h3>头像：&nbsp;&nbsp;</h3></td>
								<td>
								<c:choose>
										<c:when test="${empty sessionScope.wteacher}">
										<img src="upimg/head-default-img.png" width="150px" height="150px" />&nbsp;&nbsp;
										</c:when>
										<c:otherwise>
										<img src="upimg/${sessionScope.wteacher.timg}" width="150px"
												height="150px" />&nbsp;&nbsp;
										</c:otherwise>
										</c:choose>
										</td>
								<td><form action="teacher.do" method="post"  enctype="multipart/form-data">
										<input type="hidden" name="nameForImg"
											value="${sessionScope.teacher.tname}" />
										<input type="file" name="upimg" /> <input type="submit"
											name="submit" value="换一换" />
									</form></td>
							</tr>
						</table> 
							

						</fieldset>
  </body>
</html>
