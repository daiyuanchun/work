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
    .div1{
    position: absolute;
	left: 45%;
    }
    </style>
  </head>
 
  <body>
    <font style="font-size: 36px;font-family:幼圆 ;">
    <fieldset>
     <legend>查看岗位</legend>
		<table align="center"   width=60%>
		<c:forEach items="${sessionScope.list}" var="list">
		<tr>
		<form action="updateOrDelete.do"  method="post">
		<input type="hidden" name="cname" value="${sessionScope.company.cname}" /> 
			<td>
				职位：<input type="text" name="post" value="${list.post}"/>
			</td>
			<td>
			    体验金： <input type="text" name="price" value="${list.price}"/>
			</td>
			<td>
			   <input  type="submit" name="updateCprice" value="更新此项内容"/>
			   
			</td>
			<td>
			 <input  type="submit" name="deleteCprice" value="删除此项内容"/>
			</td>
			</form>
		</tr>
		</c:forEach>
		</table>
		</fieldset>
		</font>
		<font style="font-size: 20px;font-family:幼圆 ;">
		<div class="div1">
		</div>
		温馨提示：如果您要更新数据，只需在文本框中重新输入数据即可，然后点击更新按钮。
		
		 </font>
		
  </body>
</html>
