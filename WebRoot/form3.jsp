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
    <title>职业体验</title>
  </head>
  <body>
  <center>
  <form  action="dealCompanyFirm.do"  method="post">
  <table   width="1200px"  height="500px"  border="1">
  <tr>
  <td>
  公司名称：
  </td>
  <td>
  <input type="hidden"  value=" ${sessionScope.companyInformation.cname}"  name="cname"/>
  <input type="hidden"  value=" ${sessionScope.companyInformation.firm}"  name="firm"/>
 ${sessionScope.companyInformation.firm}
  </td>
  <td></td>
  </tr>
  <tr>
  <td>
  体验人真实姓名：
  </td>
  <td>
  <input type="hidden"  value=" ${sessionScope.person.pname}"  name="pname"/>
  <input  type="text"   name="userName"/>
  </td>
  </tr>
  <tr>
  <td>
  职业体验开始时间：
  </td>
  <td>
请输入年月日：<input type="text" placeholder="某年某月某日" name="xytime"/>
</td>
  </tr>
  <tr>
  <td>
  请选择您要体验的岗位：
  </td>
  <td>
  <select name="post">
  <option value="-1">请选择岗位</option>
  <c:forEach items="${sessionScope.cpriceList}" var="cpriceList">
   <option value="${cpriceList.post},${cpriceList.price}">${cpriceList.post}&nbsp;&nbsp;${cpriceList.price}</option>
   </c:forEach>
   </select>
  </td>
  </tr>
  <tr>
  <td>
  您要体验几天：
  </td>
  <td><select name="lastTime">
<option value="-1">请选择体验天数</option>
<option value="1">1天</option>
<option value="2">2天</option>
<option value="3">3天</option>
<option value="4">4天</option>
<option value="5">5天</option>
<option value="6">6天</option>
<option value="7">7天</option>
<option value="8">8天</option>
<option value="9">9天</option>
<option value="10">10天</option>
<option value="11">11天</option>
<option value="12">12天</option>
<option value="13">13天</option>
<option value="14">14天</option>
<option value="15">15天</option>
<option value="16">16天</option>
<option value="17">17天</option>
<option value="18">18天</option>
<option value="19">19天</option>
<option value="20">20天</option>
<option value="21">21天</option>
<option value="22">22天</option>
<option value="23">23天</option>
<option value="24">24天</option>
<option value="25">25天</option>
<option value="26">26天</option>
<option value="27">27天</option>
<option value="28">28天</option>
<option value="29">29天</option>
<option value="30">30天</option>

</select>
  </td>
 
  </tr>
  
  </table><br/>
  <input type="submit" name="askCompanyForCheck" value="提交申请单"/>
  </form>
  建议：请填写正确的信息，否则公司审核将不会通过。<br/>
  
  
  </center>
  </body>
  </html>