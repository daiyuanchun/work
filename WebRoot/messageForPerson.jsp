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
		<font  size="5px">
			<table width="1280px" border="0">
				<tr>
					<td style="background-color:#99bbbb;"><c:import
							url="header.jsp"></c:import></td>
				</tr>
				
						</table> <br>
						<fieldset>

							<legend>个人资料</legend>

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
												<option value="0">请选择省份</option>
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
													<c:when test="${empty sessionScope.allCity}">
														<option value="0">请选择城市</option>
													</c:when>
													<c:otherwise>
														<option value="0">请选择城市</option>
														<c:forEach items="${sessionScope.allCity}" var="allCity">
															<option value="${allCity.city}">${allCity.city}</option>
														</c:forEach>
													</c:otherwise>
												</c:choose>
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
													<c:when test="${empty sessionScope.allArea}">
														<option value="0">&nbsp;&nbsp;</option>
													</c:when>
													<c:otherwise>
														<option value="0">请选择区县</option>
														<c:forEach items="${sessionScope.allArea}" var="allArea">
															<option value="${allArea.area}">${allArea.area}</option>
														</c:forEach>
													</c:otherwise>
												</c:choose>
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
									name="person_email" /> &nbsp;&nbsp;年龄：&nbsp;&nbsp; <select
									name="personAge">
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
								</select><br /><center> <input type="submit" value="保存信息" /></center>
							</form>

							<br /> 
						</fieldset>
					</td>


				</tr>
				<tr>
					<td style="background-color:#99bbbb;text-align:center;">
						Copyright W3School.com.cn</td>
				</tr>
			</table>

		</font>
	</center>
</body>
</html>
