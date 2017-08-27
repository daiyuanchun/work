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
			<legend>基本信息</legend>
			<form action="teacherBasic.do" method="post">
				<table width="1280px" border="0" align="center">
					<input type="hidden" name="hiddenName"
						value="${sessionScope.teacher.tname}" />

					<tr>
						<td align="center">您所属省份(必选):</td>
						<td><select name="provinceId">
								<c:choose>
									<c:when
										test="${empty sessionScope.teacher.provinceId.province}">
										<option value="0">请选择省份</option>
									</c:when>
									<c:otherwise>
										<option value="${sessionScope.teacher.provinceId}">${sessionScope.teacher.provinceId.province}</option>
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
						<td align="center">您所属专业领域(必选):</td>
						<td><select name="majorId">
								<c:choose>
									<c:when test="${empty sessionScope.teacher.majorId.major}">
										<option value="0">请选择专业领域</option>
									</c:when>
									<c:otherwise>
										<option value="${sessionScope.teacher.majorId}">${sessionScope.teacher.majorId.major}</option>
									</c:otherwise>
								</c:choose>
								<option value="1">电子信息科学与技术</option>
								<option value="2">软件工程</option>
								<option value="3">工商管理</option>
								<option value="4">计算机科学与技术</option>
								<option value="5">经济学</option>
								<option value="6">临床医学</option>
								<option value="7">会计学</option>
								<option value="8">金融学</option>
								<option value="9">土木工程</option>
								<option value="10">人力资源管理</option>
								<option value="11">机械制造及其自动化</option>
								<option value="12">自动化</option>
								<option value="13">法学</option>
								<option value="14">广告学</option>
								<option value="15">汉语言文学</option>
								<option value="16">对外汉语</option>
								<option value="17">传播学</option>
								<option value="18">广播电视编导</option>
								<option value="19">戏剧影视文学</option>
								<option value="20">英语语言文学</option>
								<option value="21">葡萄牙语</option>
								<option value="22">新闻学</option>
								<option value="23">阿拉伯语</option>
								<option value="24">西班牙语</option>
								<option value="25">朝鲜语</option>
								<option value="26">日语</option>
								<option value="27">意大利语</option>
								<option value="28">数学与应用数学</option>
								<option value="29">保险专业</option>
								<option value="30">金融工程</option>
								<option value="31">经济学-数学（双学位）</option>
								<option value="32">图书馆学</option>
								<option value="33">统计学</option>
								<option value="34">国际贸易</option>
								<option value="35">税务</option>
								<option value="36">农村区域发展</option>
								<option value="37">旅游管理</option>
								<option value="38">土地资源管理</option>
								<option value="39">农林经济管理</option>
								<option value="40">天文学</option>
								<option value="41">应用气象学</option>
								<option value="42">教育技术</option>
								<option value="43">材料成型与控制工程</option>
								<option value="44">过程装备与控制工程</option>
								<option value="45">车辆工程</option>
								<option value="46">工业设计</option>
								<option value="47">电气工程及其自动化</option>
								<option value="48">通信工程</option>
								<option value="49">电子信息工程</option>
								<option value="50">（光电）信息工程</option>
								<option value="51">汽车运用工程</option>
								<option value="52">热能与动力工程</option>
								<option value="53">测控技术与仪器</option>
								<option value="54">建筑环境与设备工程</option>
								<option value="55">给水与排水工程</option>
								<option value="56">港口航道与海岸工程</option>
								<option value="57">工程力学</option>
								<option value="58">安全工程</option>
								<option value="59">包装工程</option>
								<option value="60">飞行器设计与工程</option>
								<option value="61">飞行器动力工程</option>
								<option value="62">飞行器环境与生命保障</option>
								<option value="63">探测制导与控制技术</option>
								<option value="64">适航技术与管理</option>
								<option value="65">农业水利工程</option>
								<option value="66">水文水资源</option>
								<option value="67">农业工程</option>
								<option value="68">勘查技术与工程</option>
								<option value="69">化学</option>
								<option value="70">应用化学</option>
								<option value="71">环境科学与工程</option>
								<option value="72">环境工程</option>
								<option value="73">材料科学与工程</option>
								<option value="74">高分子材料与工程</option>
								<option value="75">化学工程与工艺</option>
								<option value="76">制药工程</option>
								<option value="77">木材科学与工程</option>
								<option value="78">林产化工</option>
								<option value="79">药学</option>
								<option value="80">生物技术</option>
								<option value="81">生物工程</option>
								<option value="82">食品科学与工程</option>
								<option value="83">葡萄与葡萄酒工程</option>
								<option value="84">食品质量与安全</option>
								<option value="85">农学</option>
								<option value="86">园艺</option>
								<option value="87">植物保护</option>
								<option value="88">草业科学</option>
								<option value="89">生态学</option>
								<option value="90">农业资源与环境</option>
								<option value="91">动物科学</option>
								<option value="92">动物医学</option>
								<option value="93">水产养殖</option>
								<option value="94">基础医学</option>
								<option value="95">高级护理</option>
								<option value="96">口腔医学</option>
								<option value="97">中医学</option>
								<option value="98">针灸推拿学</option>
								<option value="99">哲学</option>
								<option value="100">社会学与社会工作</option>
								<option value="101">政治学与行政学</option>
								<option value="102">国际政治</option>
								<option value="103">外交学</option>
								<option value="104">思想政治教育</option>
								<option value="105">电子商务</option>
								<option value="106">物流工程</option>
								<option value="107">信息管理与信息系统</option>
						</select></td>
					</tr>
					<tr>
						<td>请选择您指导的方式：（必选）</td>
						<td><select name="wayId">
								<c:choose>
									<c:when test="${empty sessionScope.teacher.wayId.way}">
										<option value="0">请选择指导方式</option>
									</c:when>
									<c:otherwise>
										<option value="${sessionScope.teacher.wayId}">${sessionScope.teacher.wayId.way}</option>
									</c:otherwise>
								</c:choose>
								<option value="1">网上交流</option>
								<option value="2">面对面交流</option>
								<option value="3">网上交流+面对面交流</option>
						</select></td>
					</tr>
					<tr>
						<td>请输入您网上交流的价格（元/小时）：</td>
						<td><input type="text" name="pricex" value="${sessionScope.teacher.pricex}" /></td>
					</tr>
					<tr>
						<td>请输入您面对面交流的价格(元/小时)：</td>
						<td><input type="text" name="pricey" value="${sessionScope.teacher.pricey}" /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;用户名：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherTname"
							value="${sessionScope.teacher.tname}" /><br /></td>
						<td>&nbsp;&nbsp;自我介绍：&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;真实姓名：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherRname"
							value="${sessionScope.teacher.rname}" /><br /></td>
						<td rowspan="7" colspan="1"><textarea name="aboutme"
								rows="30" cols="100"
								value="${sessionScope.teacher.introduction}">${sessionScope.teacher.introduction}
								</textarea></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;电话：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherTel"
							value="${sessionScope.teacher.tel}" /><br /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;Email：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherEmail"
							value="${sessionScope.teacher.email}" /><br /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;专业：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherMajor"
							value="${sessionScope.teacher.major}" /><br /> <br /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;就职学校：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherSchool"
							value="${sessionScope.teacher.school}" /><br /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;QQ：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherQQ"
							value="${sessionScope.teacher.qq}" /><br /></td>
					</tr>
					<tr>
						<td align="center">&nbsp;&nbsp;微信：&nbsp;&nbsp;</td>
						<td><input type="text" name="teacherWechat"
							value="${sessionScope.teacher.wechat}" /><br /></td>
					</tr>
				</table>


				<div class="div1">
					<input type="submit" name="teacherForm" value="保存信息" />
				</div>
			</form>
		</fieldset>
	</font>
</body>
</html>
