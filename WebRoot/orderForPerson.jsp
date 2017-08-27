	
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
				<fieldset>

							<legend>我的订单</legend>

							
							<br/> &nbsp;&nbsp;已支付的订单（指导老师）：
							<table border="1">
								<tr>
									<td>开始时间</td>
									<td>时长（小时）</td>
									<td>指导老师姓名</td>
									<td>学生姓名</td>
									<td>价格（元/小时）</td>
									<td>总额（元）</td>
									<td>支付状态</td>
									<td>您需要去支付</td>
								</tr>
								<tr>
									<td>${requestScope.chatChecked.time}</td>
									<td>${requestScope.chatChecked.last}</td>
									<td>${requestScope.chatChecked.rname}</td>
									<td>${requestScope.chatChecked.sname}</td>
									<td>${requestScope.chatChecked.sumPrice}</td>
									<td>${requestScope.chatChecked.sumPrice}</td>
									<td>未支付</td>
									<td>去支付</td>
								</tr>
							</table>
							<br /> 已支付的订单（公司体验）：
							<table border="1">
								<tr>
									<td>开始时间</td>
									<td>时长</td>
									<td>体验公司名称</td>
									<td>体验人</td>
									<td>价格</td>
									<td>支付状态</td>
								</tr>
								<tr>
									<td>2016年5月5日</td>
									<td>2天</td>
									<td>上海科技有限公司</td>
									<td>小明</td>
									<td>200元</td>
									<td>已支付</td>
								</tr>
							</table>
						</fieldset>
						
</body></html>