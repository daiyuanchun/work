<%@page import="com.sdcj.domain.Wcompany"%>
<%@page import="com.sdcj.biz.WcompanyBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
     <base href="<%=basePath%>">
     <title>审核公司信息</title>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}
html, body {
	width: 100%;
	height: 100%;
	overflow: hidden;
}
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-width: 100%;
	background-height: 100%;
	overflow: hidden;
}
#Div1 {
	position: absolute;
	left: 20%;
	top: 2%;
	width: 60%;
	height: 100%;
	border: 1px solid #000;
}
#Div2{
    position: absolute;
	left: 0%;
	top: 0%;
	width: 60%;
	height: 90%;
	border: 1px solid #000;
}
#Div3{
    position: absolute;
	left: 0%;
	top: 90%;
	width: 100%;
	height: 10%;
	text-align: center;
	line-height: 56px;
	border: 1px solid #000;
}
#Div4{
    position: absolute;
	left: 60%;
	top: 0%;
	width: 40%;
	height: 90%;
	border: 1px solid #000;
}
#Div5{
    position: absolute;
	left: 0%;
	top: 0%;
	width: 100%;
	height: 9%;
	line-height: 56px;
	text-align: center;
	border: 1px solid #000;
}
#Div6{
    position: absolute;
	left: 0%;
	top: 9%;
	width: 100%;
	height: 41%;
	border: 1px solid #000;
}
#Div7{
    position: absolute;
	left: 0%;
	top: 50%;
	width: 100%;
	height: 9%;
	line-height: 56px;
	text-align: center;
	border: 1px solid #000;
}
#Div8{
    position: absolute;
	left: 0%;
	top: 59%;
	width: 100%;
	height: 41%;
	border: 1px solid #000;
}
</style>
<script type="text/javascript">
function save(){
WcompanyForm.action="WcompanyAgree.do";
WcompanyForm.submit();
}
function tell(){
WcompanyForm.action="WcompanyDisagree.do";
WcompanyForm.submit();
}
</script>
</head>
<body>
	<div id="Div1">
		<form id="WcompanyForm" method="post" action="">
			<%
				WcompanyBiz wcompanyBIZ = new WcompanyBiz();
		        List<Wcompany> wcompanyList = wcompanyBIZ.findAll();
		        if(wcompanyList.size()==0){
		    %>
			<script type="text/javascript">
				alert("您已经审核完企业用户了！");
				delayURL("admView.jsp",20);
                function delayURL(url, time) {
                    setTimeout("location.href='" + url + "'", time);
                }
	        </script>
		    <% 
		        }
		        else{
		            Wcompany wcompany = wcompanyList.get(0);
		            session.setAttribute("wcompany", wcompany);
			%>
			<div id="Div2">
				<table width="100%" height="100%" border="1" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="32%" align="center">用户名</td>
						<td width="68%" align="center"><%=wcompany.getCname()%></td>
					</tr>
					<tr>
						<td align="center">电话号码</td>
						<td align="center"><%=wcompany.getTel()%></td>
					</tr>
					<tr>
						<td align="center">企业邮箱</td>
						<td align="center"><%=wcompany.getEmail()%></td>
					</tr>
					<tr>
						<td align="center">企业名称</td>
						<td align="center"><%=wcompany.getFirm()%></td>
					</tr>
					<tr>
						<td align="center">所属行业</td>
						<td align="center"><%=wcompany.getIndustry()%></td>
					</tr>
					<tr>
						<td align="center">企业详细位置</td>
						<td align="center"><%=wcompany.getAddress()%></td>
					</tr>
					<tr>
						<td align="center">企业官网链接</td>
						<td align="center"><%=wcompany.getWebsit()%></td>
					</tr>
					<tr>
						<td height="200" align="center">企业简介</td>
						<td align="center"><%=wcompany.getIntroduction()%></td>
					</tr>
				</table>
			</div>
			<div id="Div3">
			    <input type="button" value="同意" onclick="save()">
				<input type="button" value="不同意" onclick="tell()">
				<a href="admView.jsp">退出</a>
			</div>
			<div id="Div4">
				<div id="Div5">证件照</div>
				<div id="Div6">
					<img style="width: 99.5%; height: 100%"
						src="upimg/<%=wcompany.getPicture()%>">
				</div>
				<div id="Div7">企业个性照</div>
				<div id="Div8">
					<img style="width: 99.5%; height: 100%"
						src="upimg/<%=wcompany.getRimg()%>">
				</div>
			</div>
			<%} %>
		</form>
	</div>
</body>

