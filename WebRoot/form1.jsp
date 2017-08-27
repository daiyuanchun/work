<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>网上交流</title>
</head>
<body>
	<center>
		<font style="font-size: 20px;font-family:幼圆 ;"> 网上交流申请表
			<form action="deal.do" method="post">
				<table width="1280px" height="500px" border="1">
					<tr>
						<td>&nbsp;&nbsp;&nbsp;指导老师姓名：</td>
						<td><input type="hidden"
							value=" ${sessionScope.wteacherInformation.tname}" name="tname" />
							<input type="hidden"
							value=" ${sessionScope.wteacherInformation.rname}" name="rname" />
							<input type="hidden"
							value=" ${sessionScope.wteacherInformation.qq}" name="qq" /> <input
							type="hidden" value=" ${sessionScope.wteacherInformation.wechat}"
							name="wechat" />
							&nbsp;&nbsp;&nbsp;${sessionScope.wteacherInformation.rname}</td>

					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;指导学生真实姓名：</td>
						<td><input type="hidden"
							value=" ${sessionScope.person.pname}" name="pname" />
							&nbsp;&nbsp;&nbsp; <input type="text"
							style="font-size: 15px;font-family:幼圆 ;" name="userName" /></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;网上交流开始时间：</td>
						<td>&nbsp;&nbsp;&nbsp;请输入年月日：<input type="text"
							placeholder="某年某月某日" name="xytime" /> <select name="abctime">
								<option value="错误">请选择时间</option>
								<option value="1点">1点</option>
								<option value="2点">2点</option>
								<option value="3点">3点</option>
								<option value="4点">4点</option>
								<option value="5点">5点</option>
								<option value="6点">6点</option>
								<option value="7点">7点</option>
								<option value="8点">8点</option>
								<option value="9点">9点</option>
								<option value="10点">10点</option>
								<option value="11点">11点</option>
								<option value="12点">12点</option>
								<option value="13点">13点</option>
								<option value="14点">14点</option>
								<option value="15点">15点</option>
								<option value="16点">16点</option>
								<option value="17点">17点</option>
								<option value="18点">18点</option>
								<option value="19点">19点</option>
								<option value="20点">20点</option>
								<option value="21点">21点</option>
								<option value="22点">22点</option>
								<option value="23点">23点</option>
								<option value="24点">24点</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 价格（元/小时）：</td>
						<td><input type="hidden"
							value="${sessionScope.wteacherInformation.pricex}"
							name="hiddenPrice" />
							&nbsp;&nbsp;&nbsp;${sessionScope.wteacherInformation.pricex}</td>

					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;网上交流时长：</td>
						<td>&nbsp;&nbsp;&nbsp;<select name="lastTime">
								<option value="0">请选择时长</option>
								<option value="1">1小时</option>
								<option value="2">2小时</option>
								<option value="3">3小时</option>
								<option value="4">4小时</option>
								<option value="5">5小时</option>
						</select>
						</td>

					</tr>

				</table>
				<br />
				<br /> <input type="submit" value="提交给老师审核"
					name="askTeacherForCheck" />
			</form> <br />
		<br /> 建议：1，请填写正确的信息，否则老师审核将不会通过。<br /> <br />&nbsp;&nbsp;&nbsp;2,请填写正确的时间，交流时间最好在早上8点至晚上23点之间。


		</font>
	</center>
</body>
</html>