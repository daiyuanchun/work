<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<STYLE TYPE="text/css">
body {
	margin: 40pt;
}

.changjianwenti {
	position: absolute;
	margin-top: 1%;
	width: 100px;
	height: 36px;
	background: #65c294;
	border-radius: 7px;
	line-height: 1px;
	text-align: center;
}

.changjianwenti-line {
	margin-top: -2px;
}

.problems {
	position: absolute;
	width: 100%;
	top: 17%;
}

.buy-problem {
	position: absolute;
	margin-top: 20px;
}

.buy-problem-text {
	position: absolute;
	margin-top: -34px;
	margin-left: 27px;
}

.buy-problem1 {
	margin-left: 30px;
}

.buy-problem2 {
	margin-left: 30px;
}

.buy-problem1-answer {
	margin-left: 40px;
}

.buy-problem2-answer {
	margin-left: 40px;
}

.ask-problem {
	position: absolute;
	margin-top: 280px;
}

.ask-problem-text {
	margin-top: -34px;
	margin-left: 23px;
}

.ask-problem1 {
	margin-left: 30px;
}

.ask-problem2 {
	margin-left: 30px;
}

.ask-problem1-answer {
	margin-left: 40px;
}

.ask-problem2-answer {
	margin-left: 40px;
}
</STYLE>
<BODY TOPMARGIN=30 LEFTMARGIN=30 MARGINWIDTH=30 MARGINHEIGHT=30>
	<div class="changjianwenti">
		<h2>
			<font face="楷体" size="5" color="white">常见问题</font>
	</div>
	</h2>
	<hr class="changjianwenti-line" color="#65c294" size="2" />
	<div class="problems">
		<div class="buy-problem">
			<img src="images/question.png" width="140px" height="50px" />
			<p class="buy-problem-text">
				<font face="微软雅黑" color="white" size="4">购买问题</font>
			</p>
			<p class="buy-problem1">
				<font face="微软雅黑" color="red" size="4">1.订单提交不成功</font>
			</p>
			<p class="buy-problem1-answer">
				<font face="微软雅黑" color="black" size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首先刷新网络，检查网络是否畅通。在网络畅通的条件下，请返回重新下订单。您也可以联系我们的客服人员，我们竭诚为您服务。如若为您带来不便，我们感到非常抱歉。</font>
			</p>
			<p class="buy-problem2">
				<font face="微软雅黑" color="red" size="4">2.不知该怎样付款</font>
			</p>
			<p class="buy-problem2-answer">
				<font face="微软雅黑" color="black" size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首先刷新网络，检查网络是否畅通,点击付款后根据页面提示的二维码进行扫描，之后根据提示进行付款。您也可以联系我们的客服人员，我们竭诚为您服务。如若为您带来不便，我们感到非常抱歉。</font>
			</p>

		</div>
		<div class="ask-problem">
			<img src="images/question.png" width="160px" height="50px" />
			<p class="ask-problem-text">
				<font face="微软雅黑" color="white" size="4">专业指导问题</font>
			</p>
			<p class="ask-problem1">
				<font face="微软雅黑" color="red" size="4">1.导师怎样进行指导，安全吗？</font>
			</p>
			<p class="ask-problem1-answer">
				<font face="微软雅黑" color="black" size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们的导师都是经过认真信息核实过的，都是在校教师，对专业有着很全面的理解。导师指导可以上门辅导，也可以在学校指导，可以和导师协商。</font>
			</p>
			<p class="ask-problem2">
				<font face="微软雅黑" color="red" size="4">2.如果我对导师不满意怎么办，可以更换导师吗？</font>
			</p>
			<p class="ask-problem2-answer">
				<font face="微软雅黑" color="black" size="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对导师不满意的可以找客服人员进行投诉，我们会尽量满足客户的需求，为您更换导师。但是投诉我们会进行核实，拒绝乱投诉，请做一个文明的网名。我们会根据客户的反映，对导师进行相应的扣分。</font>
			</p>

		</div>

	</div>



</body>
</html>