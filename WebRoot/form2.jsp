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
    <title>面对面交流</title>
  </head>
  <body>
  <center>
  <form  action="dealFace.do"  method="post">
  <table   width="1200px"  height="500px"  border="1">
  <tr>
  <td>
  指导老师姓名：
  <input type="hidden"  value=" ${sessionScope.wteacherInformation.tname}"  name="tname"/>
  <input type="hidden"  value=" ${sessionScope.wteacherInformation.rname}"  name="rname"/>
  <input type="hidden"  value=" ${sessionScope.wteacherInformation.tel}"  name="tel"/>
  <input type="hidden"  value=" ${sessionScope.person.pname}"  name="pname"/>
  
  </td>
  <td>
  
  ${sessionScope.wteacherInformation.rname}
  </td>
  <td></td>
  </tr>
  <tr>
  <td>
  指导学生真实姓名：
  </td>
  <td>
  <input  type="text"   size=20  name="userName"/>
  </td>
  </tr>
  <tr>
  <td>
  面对面交流开始时间：
  </td>
  <td>
请输入年月日：<input type="text" placeholder="某年某月某日" name="xytime"/>

<select name="time">
<option value="-1">请选择时间</option>
<option value="1">1点</option>
<option value="2">2点</option>
<option value="3">3点</option>
<option value="4">4点</option>
<option value="5">5点</option>
<option value="6">6点</option>
<option value="7">7点</option>
<option value="8">8点</option>
<option value="9">9点</option>
<option value="10">10点</option>
<option value="11">11点</option>
<option value="12">12点</option>
<option value="13">13点</option>
<option value="14">14点</option>
<option value="15">15点</option>
<option value="16">16点</option>
<option value="17">17点</option>
<option value="18">18点</option>
<option value="19">19点</option>
<option value="20">20点</option>
<option value="21">21点</option>
<option value="22">22点</option>
<option value="23">23点</option>
<option value="24">24点</option>
</select>
  
 
  </tr>
  <tr>
  <td>
  面对面交流时长：
  </td>
  <td><select name="lastTime">
<option value="-1">请选择时长</option>
<option value="1">1小时</option>
<option value="2">2小时</option>
<option value="3">3小时</option>
<option value="4">4小时</option>
<option value="5">5小时</option>
</select>
  </td>
 
  </tr>
  <tr>
  <td>
  价格（元/小时）：
  </td>
  <td>
  <input type="hidden"  value=" ${sessionScope.wteacherInformation.pricey}"  name="price"/>
  ${sessionScope.wteacherInformation.pricey}
  </td>
  
  </tr>
  <tr>
  <td>
  指导老师电话：
  </td>
  <td>
  ${sessionScope.wteacherInformation.tel}</td>
  </tr>
  </table>
  <input type="submit" name="faceForm"  value="提交申请单"/>
  </form>
  建议：1，请填写正确的信息，否则老师审核将不会通过。<br/>
  <br/>&nbsp;&nbsp;&nbsp;2,请填写正确的时间，交流时间最好在早上9点至晚上6点之间。
  
  </center>
  </body>
  </html>