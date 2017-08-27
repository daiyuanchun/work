<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</style>
</head>


<body>
	<font style="font-size: 32px;font-family:幼圆 ;">
		<fieldset>
			<legend>订单</legend>
			
			<form action="dealExperience.do" method="post">
				<c:forEach items="${sessionScope.exList}" var="exList">
					<br /> 等待处理的订单:(公司体验)
							<table border="1">
					<input type="hidden"  name="cname"  value="${exList.cname}"/>
					<input type="hidden"  name="pname"  value="${exList.pname}"/>
					<input type="hidden"  name="time"  value="${exList.time}"/>
					<input type="hidden"  name="last"  value="${exList.last}"/>
					<input type="hidden"  name="firm"  value="${exList.firm}"/>
					<input type="hidden"  name="sname"  value="${exList.sname}"/>
					<input type="hidden"  name="field"  value="${exList.field}"/>
					<input type="hidden"  name="price"  value="${exList.price}"/>
					<input type="hidden"  name="sumPrice"  value="${exList.sumPrice}"/>
						<tr>
							<td>开始时间</td>
							<td>时长</td>
							<td>体验公司名称</td>
							<td>体验人</td>
							<td>体验岗位</td>
							<td>价格(元/天)</td>
							<td>总额（元）</td>
							<td>申请是否同意</td>
						</tr>
						<tr>
							<td>${exList.time }</td>
							<td>${exList.last }</td>
							<td>${exList.firm }</td>
							<td>${exList.sname }</td>
							<td>${exList.field }</td>
							<td>${exList.price }</td>
							<td>${exList.sumPrice }</td>
							<td><input type="submit" name="agress" value="同意" />
						<input type="submit" name="disagress" value="不同意" /></td>
						</tr>
					</table>
				</c:forEach>
			</form>
			<br /> 
			您的最终订单：
			<table border="1" align="center">
			<c:forEach items="${sessionScope.checkedList}" var="checkedList">
				<tr>
					<td>开始时间</td>
					<td>时长</td>
					<td>体验公司名称</td>
					<td>体验人</td>
					<td>体验岗位</td>
					<td>价格(元/天)</td>
					<td>总额（元）</td>
					<td>申请是否同意</td>
				</tr>
				<tr>
					<td>${checkedList.time}</td>
					<td>${checkedList.last}</td>
					<td>${checkedList.firm}</td>
					<td>${checkedList.sname}</td>
					<td>${checkedList.field }</td>
					<td>${checkedList.price}</td>
					<td>${checkedList.sumPrice}</td>
					<td>已同意</td>
				</tr>
				</c:forEach>
			</table>
		</fieldset>


	</font>
</body>
</html>
