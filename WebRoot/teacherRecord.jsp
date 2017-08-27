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
    <font style="font-size: 32px;font-family:幼圆 ;">
		<fieldset>
			<legend>订单</legend>
			<table border="1" cellpadding="0"
					cellspacing="0">
						 <c:forEach items="${sessionScope.chatList}" var="chatList">
						您需要审核的订单（网上交流）：
						<form  action="chat.do"  method="post">
						    <input type="hidden"  name="time"  value="${chatList.time}"/>
							<input type="hidden"  name="tname"  value="${chatList.tname}"/>
							<input type="hidden"  name="rname"  value="${chatList.rname}"/>
							<input type="hidden"  name="pname"  value="${chatList.pname}"/>
							<input type="hidden"  name="sname"  value="${chatList.sname}"/>
							<input type="hidden"  name="price"  value="${chatList.price}"/>
							<input type="hidden"  name="sumPrice"  value="${chatList.sumprice}"/>
							<input type="hidden"  name="last"  value="${chatList.last}"/>
							<tr  align="center">
								<td>开始时间</td>
								<td>时长(小时)</td>
								<td>指导老师</td>
								<td>学生</td>
								<td>价格(元/小时)</td>
								<td>总额（元）</td>
								<td>支付状态</td>
								<td>申请是否同意</td>
							</tr>
							<tr  align="center">
								<td>${chatList.time}</td>
								<td>${chatList.last}</td>
								<td>${chatList.rname}</td>
								<td>${chatList.sname}</td>
								<td>${chatList.price}</td>
								<td>${chatList.sumprice}</td>
								<td>未支付</td>
								<td>
								<input type="submit"  name="agress"  value="同意"/>&nbsp;&nbsp;
								<input type="submit"  name="disagress"  value="不同意"/>
								 </td>
							</tr></form>
							</c:forEach>
							</table><br>
							<table border="1" cellpadding="0"
					cellspacing="0">
						 <c:forEach items="${sessionScope.faceList}" var="faceList">
						您需要审核的订单（面对面交流）：
						<form  action="face.do"  method="post">
							<tr  align="center">
							<input type="hidden"  name="time"  value="${faceList.time}"/>
							<input type="hidden"  name="tname"  value="${faceList.tname}"/>
							<input type="hidden"  name="rname"  value="${faceList.rname}"/>
							<input type="hidden"  name="pname"  value="${faceList.pname}"/>
							<input type="hidden"  name="sname"  value="${faceList.sname}"/>
							<input type="hidden"  name="price"  value="${faceList.price}"/>
							<input type="hidden"  name="sumPrice"  value="${faceList.sumPrice}"/>
							<input type="hidden"  name="last"  value="${faceList.last}"/>
							<input type="hidden"  name="tel"  value="${faceList.tel}"/>
								<td>开始时间</td>
								<td>时长(小时)</td>
								<td>指导老师</td>
								<td>学生</td>
								<td>价格(元/小时)</td>
								<td>总额（元）</td>
								<td>手机</td>
								<td>请给出面对面交流地址</td>
								<td>申请是否同意</td>
							</tr>
							<tr  align="center">
								<td>${faceList.time}</td>
								<td>${faceList.last}</td>
								<td>${faceList.rname}</td>
								<td>${faceList.sname}</td>
								<td>${faceList.price}</td>
								<td>${faceList.sumPrice}</td>
								<td>${faceList.tel}</td>
								
								<td><input  type="text" name="address"  placeholder="输入见面地址"/></td>
								<td>
								
								<input type="submit"  name="agress"  value="同意"/>&nbsp;&nbsp;
								<input type="submit"  name="disagress"  value="不同意"/>
								 </td>
							</tr>
							</form>
							
							</c:forEach>
							</table><br>
							<table border="1" cellpadding="0"
					cellspacing="0">
							<c:forEach items="${sessionScope.chatCheckedList}" var="chatCheckedList">
						您的订单(网上交流最终订单)：
							<tr  align="center">
								<td>开始时间</td>
								<td>时长(小时)</td>
								<td>指导老师</td>
								<td>学生</td>
								<td>价格(元/小时)</td>
								<td>总额（元）</td>
							  <td>申请是否同意</td>
							</tr>
							<tr  align="center">
								<td>${chatCheckedList.time}</td>
								<td>${chatCheckedList.last}</td>
								<td>${chatCheckedList.rname}</td>
								<td>${chatCheckedList.sname}</td>
								<td>${chatCheckedList.price}</td>
								<td>${chatCheckedList.sumprice}</td>
								<td>已同意</td>
								
								
								 
							</tr>
							</c:forEach>
							
						</table><br> 
						<table border="1" cellpadding="0"
					cellspacing="0">
							<c:forEach items="${sessionScope.faceCheckedList}" var="faceCheckedList">
						您的订单(面对面交流最终订单)：
							<tr  align="center">
								<td>开始时间</td>
								<td>时长(小时)</td>
								<td>指导老师</td>
								<td>学生</td>
								<td>价格(元/小时)</td>
								<td>总额（元）</td>
								<td>手机</td>
								<td>面对面交流地址</td>
								
							  <td>申请是否同意</td>
							</tr>
							<tr  align="center">
								<td>${faceCheckedList.time}</td>
								<td>${faceCheckedList.last}</td>
								<td>${faceCheckedList.rname}</td>
								<td>${faceCheckedList.sname}</td>
								<td>${faceCheckedList.price}</td>
								<td>${faceCheckedList.sumprice}</td>
								<td>${faceCheckedList.tel}</td>
								<td>${faceCheckedList.address}</td>
								<td>已同意</td>
								
								
								 
							</tr>
							</c:forEach>
							
						</table> 
			
		</fieldset>


	</font>
  </body>
</html>
