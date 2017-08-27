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
<style type="text/css">
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.div1 {
	position: absolute;
	left: 48%;
}
</style>
</head>

<body>
	<font style="font-size: 32px;font-family:幼圆 ;">
		<fieldset>
			<legend>企业信息</legend>
			<form action="companyBasic.do" method="post">
				<table align="center">
					<tr>
						<td align="center">体验公司所在省份（必选）：</td>
						<td><select name="provinceId">
								<c:choose>
									<c:when test="${empty sessionScope.company.provinceId.province}">
									<option value="0">请选择省份</option>
									</c:when>
									<c:otherwise>
									<option value="${sessionScope.company.provinceId}" >${sessionScope.company.provinceId.province}</option>
									</c:otherwise>
								</c:choose>
								
								<option value="1">北京市</option>
								<option value="2">天津市</option>
								<option value="5">上海市</option>
								<option value="3">浙江省</option>
								<option value="4">安徽省</option>
								<option value="6">福建省</option>
								<option value="7">重庆市</option>
								<option value="8">江西省</option>
								<option value="9">山东省</option>
								<option value="10">河南省</option>
								<option value="11">河北省</option>
								<option value="12">江苏省</option>
								<option value="13">湖南省</option>
								<option value="14">湖北省</option>
								<option value="15">内蒙古自治区</option>
								<option value="16">新疆维吾尔自治区</option>
								<option value="17">宁夏回族自治区</option>
								<option value="18">西藏自治区</option>
								<option value="19">广西壮族自治区</option>
								<option value="20">广东省</option>
								<option value="21">四川省</option>
								<option value="22">贵州省</option>
								<option value="23">山西省</option>
								<option value="24">云南省</option>
								<option value="25">辽宁省</option>
								<option value="26">陕西省</option>
								<option value="27">吉林省</option>
								<option value="28">甘肃省</option>
								<option value="29">黑龙江省</option>
								<option value="30">青海省</option>
								<option value="31">海南省</option>
								<option value="31">香港特别行政区</option>
								<option value="31">澳门特别行政区</option>
								<option value="31">台湾省</option>
						</select></td>
					</tr>
					<tr>
						<td align="center">公司所在领域（必选）：</td>
						<td><select name=fieldId>
								<c:choose>
									<c:when test="${empty sessionScope.company.fieldId.field}">
									<option value="0">请选择领域</option>
									</c:when>
									<c:otherwise>
									<option value="${sessionScope.company.fieldId}" >${sessionScope.company.fieldId.field}</option>
									</c:otherwise>
								</c:choose>
								
								<option value="1">农,林,牧,渔业</option>
								<option value="2">采矿业</option>
								<option value="3">制造业</option>
								<option value="4">电力,热力,燃气及水的生产和供应业</option>
								<option value="5">环境和公共设施管理业</option>
								<option value="6">建筑业</option>
								<option value="7">交通运输,仓储业和邮政业</option>
								<option value="8">信息传输,计算机服务和软件业</option>
								<option value="9">批发和零售业</option>
								<option value="10">住宿,餐饮业</option>
								<option value="11">金融,保险业</option>
								<option value="12">房地产业</option>
								<option value="13">租赁和商务服务业</option>
								<option value="14">科学研究,技术服务和地质勘查业</option>
								<option value="15">水利,环境和公共设施管理业</option>
								<option value="16">居民服务和其他服务业</option>
								<option value="17">卫生,社会保障和社会服务业</option>
								<option value="18">教育业</option>
								<option value="19">文化,体育,娱乐业</option>
								<option value="20">综合(含投资类,主业不明显)</option>
								<option value="21">其他</option>
								
						</select></td>
					</tr>
					<tr>
						<td align="center"><input type="hidden" name="lastCname"
							value="${sessionScope.company.cname}" /> 用户名：</td>
						<td><input type="text" name="cname"
							value="${sessionScope.company.cname}" /></td>
					</tr>
					<tr>
						<td align="center">电话：</td>
						<td><input type="text" name="tel"
							value="${sessionScope.company.tel}" /></td>
					</tr>
					<tr>
						<td align="center">邮箱：</td>
						<td><input type="text" name="email"
							value="${sessionScope.company.email}" /></td>
					</tr>
					<tr>
						<td>企业全称：</td>
						<td><input type="text" name="firm"
							value="${sessionScope.company.firm}" /></td>
					</tr>
					<tr>
						<td>所属行业：</td>
						<td><input type="text" name="industry"
							value="${sessionScope.company.industry}" /></td>
					</tr>
					<tr>
						<td>企业地址：</td>
						<td><input type="text" name="address"
							value="${sessionScope.company.address}" /></td>
					</tr>
					<tr>
						<td>企业官网：</td>
						<td><input type="text" name="websit"
							value="${sessionScope.company.websit}" /></td>
					</tr>
					<tr>
						<td>企业简介：</td>
						<td><textarea name="introduction" rows="30" cols="100">${sessionScope.company.introduction}</textarea>
						</td>
					</tr>
				</table>
				<div class="div1">
					<input type="submit" name="save" value="保存信息" />
				</div>
			</form>
		</fieldset>
	</font>
</body>
</html>
