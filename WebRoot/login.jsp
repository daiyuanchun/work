<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
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
	
	<script type="text/javascript">
		function reloadCode() {
			var time = new Date().getTime();
			document.getElementById("imagecode").src = "<%=request.getContextPath()%>/ImageServlet?d="
+ time;
		}
		
	</script>
	
	<!--头部-->
	<c:import url="header.jsp" />
	<!--end 头部-->
	<div class="content">
		<!--内容区-->
		<div class="login-box">
		<div class="wrap clearfix">
				<div class="login-box-wind">
					<div class="login-tit">
						<h2>用户登录</h2>
					</div>
					<div class="login-cnt">
						<div class="frm-lst">
							<form id="loginForm" action="login.do" name="loginForm"
								method="post" novalidate="novalidate">
								<ul>
									<li>
										<div class="frm-inp">
											<input type="text" name="username" value=""
												class="inp ico-user-name" placeholder="账号" id="username">
										</div>

									</li>
									<li>
										<div class="frm-inp">
											<input type="password" name="password"
												class="inp ico-user-pswd" placeholder="密码" id="password">
										</div>

									</li>
									<li>
										<div class="frm-inp">
											<input type="text" name="checkcode" class="inp ico-user-pswd"
												placeholder="验证码" />
										</div>
									</li>
									<li>
										<div class="frm-inp">
											<img alt="验证码" id="imagecode"
												src="<%=request.getContextPath()%>/ImageServlet" />
												 <a
												href="javascript:reloadCode();">看不清</a><br>
										</div>
									</li>
									<li>
										<div class="frm-inp">
											个人用户:&nbsp;<input type="radio" name="user_type" value="person"  checked="checked">&nbsp;&nbsp;&nbsp;
											指导老师:&nbsp;<input type="radio" name="user_type" value="teacher">&nbsp;&nbsp;&nbsp;
											公司用户:&nbsp;<input type="radio" name="user_type" value="company">&nbsp;&nbsp;&nbsp;
											管理员：&nbsp;<input type="radio" name="user_type" value="manager">
										</div>
									</li>
								</ul>
							</form>
						</div>
						<script type="text/javascript">
							function tologin() {
								document.loginForm.submit();//页面中loginForm表单调用提交动作
							}
						</script>
						<div class="frm-lst-smt">
							<a href="javascript:tologin();" class="btn-red-big" id="loginIn">
								<span>登录</span>
							</a>
						</div>
						<div class="fgt">
							<a href="chooseUserType.jsp" class="now-reg-btn"><span>立即注册</span></a>
							<a href="forget.jsp" class="fgt-lnk">
							<span>忘记密码</span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end 内容区-->
	</div>
	<!--底部-->
</body>
</html>

<script>
//取出传回来的参数error并与yes比较
var codeError ='<%=request.getParameter("codeError")%>';
var userNotExitError ='<%=request.getParameter("userNotExitError")%>';
var userPasswordError='<%=request.getParameter("userPasswordError")%>';
var teacherRegisterFail ='<%=request.getParameter("teacherRegisterFail")%>';
var CompanyRegisterFail ='<%=request.getParameter("CompanyRegisterFail")%>';
var teacherWait ='<%=request.getParameter("teacherWait")%>';
var companyWait ='<%=request.getParameter("companyWait")%>';
if(codeError=='yes'){
    alert("验证码错误！");
}

if(userNotExitError=='yes'){
    alert("用户不存在！");
}
if(userPasswordError=='yes'){
  alert("密码不正确！");
}
if(teacherRegisterFail=='yes'){
    alert("您的注册信息未审核通过，请重新注册！");
}

if(teacherWait=='yes'){
    alert("您的注册信息还未审核，请您耐心等候！");
}

if(CompanyRegisterFail=='yes'){
    alert("贵企业的注册信息未审核通过，请重新注册！");
}

if(companyWait=='yes'){
    alert("贵企业的注册信息还未审核，请您耐心等候！");
}
</script>

