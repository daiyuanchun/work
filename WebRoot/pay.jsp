<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>确认支付</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<style>
* {
	margin: 0px;
	padding: 0px;
}

body {
	margin: 60pt;
}

.div1 {
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
}

.pay-header {
	background: #65c294;
	position: absolute;
	width: 90%;
	height: 23px;
	top: 16%;
}

.pay-message {
	position: absolute;
	width: 90%;
	top: 26%;
	left: 20%;
}

.pay-message-text {
	position: absolute;
	top: 26%;
	left: 25%;
}

.pay-explain {
	position: absolute;
	width: 100%;
	height:100%;
	top: 67%;
}

.pay-explain-text {
	position: absolute;
	background: #65c294;
	width: 90%;
	height: 23px;
}

.ss {
	position: absolute;
	width: 100%;
	top: 8%;
}
.pay-explain-ansewers{
    position: absolute;
	top: 15%;
	left: 0%;
	width: 100%;
}
.finally {
	position: absolute;
	top: 110%;
	right:10%;
}
</style>
</head>

<body>
	<div class="div1">
		<c:import url="header.jsp" />
		<div class="pay-header">
			<p>
				<font face="楷体" color="white" size="4">&nbsp;请扫码确认信息后进行支付</font>
			</p>
		</div>
		<div class="pay-message">
			<div class="pay-message-picture">
				<img src="images/pay.png" width="200px" height="200px" />
			</div>
			<div class="pay-message-text">
				<p class="pay-message-text1">
					<font face="微软雅黑" color="black" size="5">支付宝：17862925468</font>
				</p>
				<p class="pay-message-text1">
					<font face="微软雅黑" color="black" size="5">姓名：*玉蓉</font>
				</p>
				<p class="pay-message-text1">
					<font face="微软雅黑" color="gray" size="5">本号已实名认证，为官方支付宝帐号，请您放心</font>
				</p>
			</div>
		</div>
		<div class="pay-explain">
			<p class="pay-explain-text">
				<font face="楷体" color="white" size="4">&nbsp;请仔细阅读有关付款说明</font>
			</p>
			<div class="ss">
			<p><font face="微软雅黑" color="gray" size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;重要的话只说

					一遍&nbsp;:</font>
			</p>
			</div>
			<div class="pay-explain-ansewers">
				<p>
					<font face="微软雅黑" color="red" size="4">1.请仔细再三对照支付信息，若有转错账户者，官网概不

						负任何责任</font>
				</p>
				<p>
					<font face="微软雅黑" color="red" size="4">2.支付需要谨慎，请根据自己的情况进行选择，不要盲目

						的跟随大众。支付之后钱款不能退回，请亲们注意。</font>
				</p>
				<p>
					<font face="微软雅黑" color="red" size="4">3.付款后需要后台人员进行审核，请耐心等待，若审核不

						过，钱款会自动退回并且通知。相应的的审核通过，则购买成功。大概需要一个工作日</font>
				</p>
				<p>
					<font face="微软雅黑" color="red" size="4">4.由于系统不够完善，只能提供直接转账，上面为我们的

						官方收款人，已认证身份，请放心。为您带来的不便，还请谅解</font>
				</p>
				<p>
					<font face="微软雅黑" color="red" size="4">5.如若有任何其他疑问请点击联系我们，我们的客服人员

						竭诚为您服务</font>
				</p>
			</div>
		</div>
		<div class="finally">
		<p>
			<font face="楷体" color="gray" size="5">最终解释权归遇见网官方所有</font>
		</p>
	    </div>
	</div>
</body>
</html>

