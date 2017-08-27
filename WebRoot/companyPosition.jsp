<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

.div1 {
	position: absolute;
	left: 40%;
	font-size: 20px;
}
</style>
</head>

<body>
	<font style="font-size: 36px;font-family:幼圆 ;">
		<fieldset>
			<legend>所设岗位</legend>
			<form action="cprice.do" method="post">
				<table width="80%" align="center">
					<tr width="1280px" align="100px">
						<input type="hidden" name="cname" value="${sessionScope.company.cname}" />
						<td align="left">职位：<input type="text" name="post" />
						</td>

						<td>体验金：<input type="text" name="price" /> <input
							type="submit" value="添加" />
						</td>

					</tr>
				</table>
			</form>
			<div class="div1">
			<a href="see.do">查看岗位</a>
			</div>
			<br />
		</fieldset>
	</font>
</body>
</html>
