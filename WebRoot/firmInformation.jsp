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

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<style type="text/css">
div#container {
	width: 1300px
}

div#header {
	background-color: #99bbbb;
	height: 90px;
}

div#menu {
	background-color: #ffff99;
	height: 500px;
	width: 600px;
	float: left;
}

div#content {
	background-color: #EEEEEE;
	height: 500px;
	width: 700px;
	float: left;
}

div#footer {
	background-color: #99bbbb;
	height: 300px;
	clear: both;
	text-align: center;
}


</style>

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
	
		<center>
			<div id="container">

				<div id="header">
					<c:import url="header.jsp" />
				</div>

				<div id="menu">
					<br /> <br /> <img
						src="upimg/${sessionScope.companyInformation.rimg}" border="0"
						height="400px" width="400px" />
				</div>
				<div id="content">
				<br/>
					<table>
						<tr>
							<td>公司名称：<br /><br/></td>
							<td>${sessionScope.companyInformation.firm}<br /><br/> 
							<td>
						</tr>
						<tr>
							<td>所属领域：<br /><br/></td>
							<td>${sessionScope.companyInformation.industry}<br /><br/></td>
							
						</tr>
						<tr>
							<td>地址：<br /><br/></td>
							<td>${sessionScope.companyInformation.address}<br /><br/></td>
						</tr>
						<tr>
							<td>公司网址：<br/><br /></td>
							<td><a href="${sessionScope.companyInformation.websit}">${sessionScope.companyInformation.websit}</a>
							<br/><br /></td>
						</tr>
						<tr>
							<td>电话：<br/><br /></td>
							<td>${sessionScope.companyInformation.tel}<br /><br/></td>
						</tr>
						<tr>
							<td>邮箱：<br/><br /></td>
							<td>${sessionScope.companyInformation.email}<br/><br /></td>
						</tr>
					<tr>
					<td>
					公司能够提供的体验岗位有：</td><td></td>
					</tr>
					
						<c:forEach items="${sessionScope.cpriceList}" var="cpriceList">
							<tr>
								<td>${cpriceList.post}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;${cpriceList.price}元/天</td>
							</tr>
						</c:forEach>
						<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
						<tr  align="right"><td>
						<a href="form3.jsp"><ins><h1>职业体验</h1></ins></a>
						<td></td>
						</td></tr>
					</table>
					 
				</div>
			</div>


		</center>
</body>
</html>
