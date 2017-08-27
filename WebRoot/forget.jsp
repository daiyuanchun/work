<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <title>找回密码</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body{
font-size: 24px;
font-family:幼圆 ;
}
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-width: 100%;
	background-height: 100%;
	overflow: hidden;
	}
.content{
    position: absolute;
	left: 20%;
	top: 2%;
	width: 60%;
	height: 100%;
}
.div1 h2{
    position: absolute;
	left: 40%;
	top: 0%;
	width: 100%;
	height: 30%;
    font-size:50px;
    font-weight:bold;
}
.div2{
    position: absolute;
	left: 29%;
	top: 20%;
	width: 78%;
	height: 70%;
    font-size:30px;
}
.div4{
    font-size:22px;
    position: absolute;
    left: 18%;
}
.div5{
    font-size:16px;
}
.div6{
    position: absolute;
	left: 25%;
}
</style>
</head>
<body>
	
	<script type="text/javascript">
		function reloadCode() {
			var time = new Date().getTime();
			document.getElementById("imagecode").src = "<%=request.getContextPath()%>/ImageServlet?d="
+ time;
		}
		
	</script>

	<div class="content">
	   <div class="div1">
		    <h2>找回密码</h2>
	   </div>
	   <div class="div2">
			<div class="div3">
				<form action="forget.do" method="post">
					&nbsp;&nbsp;用户名：<input type="text" name="username" value=""/><br><br>
					&nbsp;&nbsp;密口令：<input type="text" name="passMessage" value=""/><br><br>
					&nbsp;&nbsp;新密码：<input type="password" name="newPassword" value=""/><br><br>
					确认密码：<input type="password" name="password" value=""/><br><br>
					&nbsp;&nbsp;验证码：<input type="text" name="checkcode"/><br><br>
					<div class="div4">
					   <img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/ImageServlet" /> 
					   <a href="javascript:reloadCode();">看不清</a>
					</div><br><br>
					<div class="div5">
						个人用户:<input type="radio" name="user_type" value="person" checked="checked">&nbsp;
						指导老师:<input type="radio" name="user_type" value="teacher">&nbsp;
						公司用户:<input type="radio" name="user_type" value="company">
					</div><br>
					<div class="div6">
					    <input type="submit" value="提交">
					</div>
				</form>
			</div>
		</div>
	 </div>
</html>
<script>
var codeError ='<%=request.getParameter("codeError")%>';
var userPassmessageError='<%=request.getParameter("userPassmessageError")%>';
var teacherPassmessageError='<%=request.getParameter("teacherPassmessageError")%>';
var companyPassmessageError='<%=request.getParameter("companyPassmessageError")%>';
var passwordError='<%=request.getParameter("passwordError")%>';
var teacherPasswordError='<%=request.getParameter("teacherPasswordError")%>';
var companyPasswordError='<%=request.getParameter("companyPasswordError")%>';
var userNotExitError='<%=request.getParameter("userNotExitError")%>';
var teacherNotExitError='<%=request.getParameter("teacherNotExitError")%>';
var companyNotExitError='<%=request.getParameter("companyNotExitError")%>';
var personSuccess='<%=request.getParameter("personSuccess")%>';
var teacherSuccess='<%=request.getParameter("teacherSuccess")%>';
var companySuccess='<%=request.getParameter("companySuccess")%>';
var personError='<%=request.getParameter("personError")%>';
var teacherError='<%=request.getParameter("teacherError")%>';
var companyError='<%=request.getParameter("companyError")%>';

if(codeError=='yes'){
    alert("验证码错误！");
}
if(userPassmessageError=='yes'){
    alert("密码口令错误！");
}
if(teacherPassmessageError=='yes'){
    alert("密码口令错误！");
}
if(companyPassmessageError=='yes'){
    alert("密码口令错误！");
}
if(passwordError=='yes'){
    alert("新密码与确认密码不一致!");
}
if(teacherPasswordError=='yes'){
    alert("新密码与确认密码不一致!");
}
if(companyPasswordError=='yes'){
    alert("新密码与确认密码不一致!");
}
if(userNotExitError=='yes'){
    alert("用户名不存在！");
}
if(teacherNotExitError=='yes'){
    alert("用户名不存在！");
}
if(companyNotExitError=='yes'){
    alert("用户名不存在！");
}
if(personSuccess=='yes'){
    alert("修改密码成功！");
}
if(teacherSuccess=='yes'){
    alert("修改密码成功！");
}
if(companySuccess=='yes'){
    alert("修改密码成功！");
}
if(personError=='yes'){
    alert("修改密码失败!");
}
if(teacherError=='yes'){
    alert("修改密码失败");
}
if(companyError=='yes'){
    alert("修改密码失败");
}
</script>