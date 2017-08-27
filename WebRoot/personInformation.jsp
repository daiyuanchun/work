
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
	<center>
		<font color="blue" size="5px">
			<table width="1280px" border="0">
				<tr>
					<td style="background-color:#99bbbb;"><c:import
							url="header.jsp"></c:import></td>
				</tr>
				<tr valign="top">
					<td
						style="background-color:#e6e6fa;height:1280px;width:750px;text-align:top;">
						<h1>
							<b>我的专区</b>
						</h1>
						<h3>基本信息</h3> <br>
						<table border="0">
							<tr>
								<td><h3>头像：&nbsp;&nbsp;</h3></td>
								<td><c:choose>
										<c:when test="${empty sessionScope.personAdd}">
											<img src="upimg/head-default-img.png" width="150px"
												height="150px" />&nbsp;&nbsp;
										</c:when>
										<c:otherwise>
											<img src="upimg/${sessionScope.personAdd.pimg}" width="150px"
												height="150px" />&nbsp;&nbsp;
										</c:otherwise>
									</c:choose></td>
								<td>&nbsp;&nbsp;
									<form action="add.do" method="post"
										enctype="multipart/form-data">
										<input type="hidden" name="nameForImg"
											value="${sessionScope.person.pname}" /> <input type="file"
											name="upimg" /> <input type="submit" name="submit"
											value="上传头像" />
									</form>

								</td>
							</tr>
						</table> <br>
						<fieldset>

							<legend>个人信息</legend>

							&nbsp;&nbsp;用户名：${sessionScope.person.pname}<br /> <br />

							<table>
								<tr>
									<td>&nbsp;&nbsp;城市:&nbsp;&nbsp;</td>
									<td>
										<form action="city.do" id="provinceForm" method="post"
											hidefocus="true">
											<input type="hidden" name="nameForProvince"
												value="${sessionScope.person.pname}" /> <select
												name="personProvince"
												onChange="document.getElementById('provinceForm').submit()">
												<c:choose>
													<c:when test="${empty sessionScope.personAdd.province}">
														<option value="0">请选择</option>
													</c:when>
													<c:otherwise>
														<option value="${sessionScope.personAdd.province}">${sessionScope.personAdd.province}</option>
													</c:otherwise>
												</c:choose>
												<c:forEach items="${sessionScope.allProvince}"
													var="allProvince">
													<option value="${allProvince.province}">${allProvince.province}</option>
												</c:forEach>
											</select>&nbsp;&nbsp;
										</form>

									</td>
									<td>
										<form action="area.do" id="cityForm" method="post"
											hidefocus="true">
											<input type="hidden" name="nameForCity"
												value="${sessionScope.person.pname}" /> <select
												name="personCity"
												onChange="document.getElementById('cityForm').submit()">
												<c:choose>
													<c:when test="${empty sessionScope.personAdd.city}">
														<option value="0">请选择</option>
													</c:when>
													<c:otherwise>
														<option value="${sessionScope.personAdd.city}">${sessionScope.personAdd.city}</option>
													</c:otherwise>
												</c:choose>
												<c:forEach items="${sessionScope.allCity}" var="allCity">
													<option value="${allCity.city}">${allCity.city}</option>
												</c:forEach>

											</select>&nbsp;&nbsp;
										</form>

									</td>
									<td>
										<form action="addarea.do" id="areaForm" method="post"
											hidefocus="true">
											<input type="hidden" name="nameForArea"
												value="${sessionScope.person.pname}" /> <select
												name="personArea"
												onChange="document.getElementById('areaForm').submit()">
												<c:choose>
													<c:when test="${empty sessionScope.personAdd.area}">
														<option value="0">请选择</option>
													</c:when>
													<c:otherwise>
														<option value="${sessionScope.personAdd.area}">${sessionScope.personAdd.area}</option>
													</c:otherwise>
												</c:choose>
												<c:forEach items="${sessionScope.allArea}" var="allArea">
													<option value="${allArea.area}">${allArea.area}</option>
												</c:forEach>

											</select>
										</form>

									</td>
								</tr>
							</table>
							<br />
							<form action="mes.do" method="post">
								<input type="hidden" name="nameMes"
									value="${sessionScope.person.pname}" />
								<table>
									<tr>
										<td>&nbsp;&nbsp;性别：&nbsp;&nbsp;</td>
										<td><input type="radio" name="sex" value="保密"
											checked="checked" /></td>
										<td><h6>保密&nbsp;&nbsp;</h6></td>
										<td><input type="radio" name="sex" value="男" /></td>
										<td><h6>男&nbsp;&nbsp;</h6></td>
										<td><input type="radio" name="sex" value="女" /></td>
										<td><h6>女</h6></td>
									</tr>
								</table>
								<br />&nbsp;&nbsp; 邮箱：&nbsp;&nbsp;<input type="email"
									name="person_email" value="${sessionScope.personAdd.email }" />
								&nbsp;&nbsp;年龄：&nbsp;&nbsp; <select name="personAge">
									<c:choose>
										<c:when test="${empty sessionScope.personAdd.age}">
											<option value="0">请选择</option>
										</c:when>
										<c:otherwise>
											<option value="${sessionScope.personAdd.age}">${sessionScope.personAdd.age}</option>
										</c:otherwise>
									</c:choose>
									<option value="15以下">15以下</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="35以上">35以上</option>
								</select><br /> &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"
									value="保存信息" />
							</form>
							</form>
							<c:forEach items="${sessionScope.chatList}" var="chatList">
								<br /> &nbsp;&nbsp;您的订单：(网上交流)
							<table border="1">
									<tr align="center">
										<td>开始时间</td>
										<td>时长（小时）</td>
										<td>指导老师姓名</td>
										<td>学生姓名</td>
										<td>价格（元/小时）</td>
										<td>总额（元）</td>
										<td>老师QQ</td>
										<td>老师微信</td>
										<td>您需要去支付</td>
									</tr>
									<tr align="center">
										<td>${chatList.time}</td>
										<td>${chatList.last}</td>
										<td>${chatList.rname}</td>
										<td>${chatList.sname}</td>
										<td>${chatList.price}</td>
										<td>${chatList.sumprice}</td>
										<td>${chatList.qq}</td>
										<td>${chatList.wechat}</td>
										<td><a href="pay.jsp"><font color="red">去支付</font></a></td>
									</tr>
								</table>
							</c:forEach>

							<c:forEach items="${sessionScope.faceList}" var="faceList">
								<br /> &nbsp;&nbsp;您的订单：(面对面交流)
							<table border="1">
									<tr align="center">
										<td>开始时间</td>
										<td>时长（小时）</td>
										<td>指导老师姓名</td>
										<td>学生姓名</td>
										<td>价格（元/小时）</td>
										<td>总额（元）</td>
										<td>老师的联系方式</td>
										<td>交流地址</td>
										<td>您需要去支付</td>
									</tr>
									<tr align="center">
										<td>${faceList.time}</td>
										<td>${faceList.last}</td>
										<td>${faceList.rname}</td>
										<td>${faceList.sname}</td>
										<td>${faceList.price}</td>
										<td>${faceList.sumprice}</td>
										<td>${faceList.tel}</td>
										<td>${faceList.address}</td>
										<td><a href="pay.jsp"><font color="red">去支付</font></a></td>
									</tr>
								</table>
							</c:forEach>

							<c:forEach items="${sessionScope.experienceList}"
								var="experienceList">
								<br /> 您的订单（公司体验）：
							<table border="1">
									<tr>
										<td>开始时间</td>
										<td>时长</td>
										<td>体验公司名称</td>
										<td>体验人</td>
										<td>体验岗位</td>
										<td>价格</td>
										<td>总额</td>
										<td>您需要去支付</td>
									</tr>
									<tr>
										<td>${experienceList.time }</td>
										<td>${experienceList.last }</td>
										<td>${experienceList.firm }</td>
										<td>${experienceList.sname }</td>
										<td>${experienceList.field }</td>
										<td>${experienceList.price }</td>
										<td>${experienceList.sumPrice }</td>
										<td><a href="pay.jsp"><font color="red">去支付</font></a></td>
									</tr>
								</table>
							</c:forEach>
						</fieldset>
					</td>


				</tr>
				<tr>
					<td style="background-color:#99bbbb;text-align:center;">
						欢迎来到遇见网</td>
				</tr>
			</table>

		</font>
	</center>
</body>
</html>
										