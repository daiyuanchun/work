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
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="Description" content="">
<meta name="Keywords" content="">
<title>公司排名</title>

<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.enplaceholder.js" type="text/javascript" charset="utf-8"></script>
<script src="js/base.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/sea.js"></script>
<script type="text/javascript" src="js/base(1).js"></script>
<script src="js/MD5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-validate-1.12.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate-common.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/check_reg.js"></script>
<script src="js/jquery.pagination.js" type="text/javascript"></script>
<script type="text/javascript">

	$(
			function() {
				var fieldId = $("#fieldId").val();
				if ($("#industryUL li a[value='" + fieldId + "']").size() > 0) {
					$("#industryUL li a").removeClass("active");
					$("#industryUL li a[value='" + fieldId + "']").addClass(
							"active");
				};
				
				//初始化时设置样式-项目类型
				var priceId = $("#priceId").val();
				if ($("#typeUL li a[value='" + priceId + "']").size() > 0) {
					$("#typeUL li a").removeClass("active");
					$("#typeUL li a[value='" + priceId + "']").addClass(
							"active");
				}
				;
				var provinceId = $("#provinceId").val();
				if ($("#locationUL li a[value='" + provinceId + "']").size() > 0) {
					$("#locationUL li a").removeClass("active");
					$("#locationUL li a[value='" + provinceId + "']").addClass(
							"active");
				}
				;

				//注册事件-项目领域
				$("#industryUL li a").click(
						function() {
							var fieldId = $(this).attr("value");
							if ($("#industryUL li a[value='" + fieldId + "']").size() > 0) {
								$("#industryUL li a").removeClass("active");
								$("#industryUL li a[value='" + fieldId + "']").addClass("active");
								$("#fieldId").val(fieldId);
								$("#searchvoform").submit();
							}
						});
				
				//注册事件-项目类型
				$("#typeUL li a").click(
						function() {
							var priceId = $(this).attr("value");
							if ($("#typeUL li a[value='" + priceId + "']").size() > 0) {
								$("#typeUL li a").removeClass("active");
								$("#typeUL li a[value='" + priceId + "']").addClass("active");
								$("#priceId").val(priceId);
								$("#searchvoform").submit();
							}
						});
				$("#locationUL li a").click(
						function() {
							var provinceId = $(this).attr("value");
							if ($("#locationUL li a[value='" + provinceId + "']").size() > 0) {
								$("#locationUL li a").removeClass("active");
								$("#locationUL li a[value='" + provinceId + "']").addClass("active");
								$("#provinceId").val(provinceId);
								$("#searchvoform").submit();
							}
						});

			})
</script>

</head>

<body>

	
<!--头部-->
<c:import url="header.jsp"/>
<!--end 头部-->
	<div class="content">
		<!--内容区-->
		<div class="srh-wp-box">
			<div class="wrap">
				<form action="searchvo.do" id="searchvoform" method="post">
					<input type="hidden" id="page" name="page" value="1">
					<div class="screen-box">
						<div class="sl-wrap clearfix">
							<div class="sl-key">公司所属领域：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="industryUL">
										<input id="fieldId" type="hidden" name="fieldId" value="${empty param.fieldId?-1:param.fieldId}"/>
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<c:forEach items="${requestScope.fieldList}" var="field">
										<li><a value="${field.id}" title="${field.field}" href="javascript:void(0);">${field.field}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="sl-ext">
								<span><em>更多</em><i class="icon"></i></span>
							</div>
						</div>
						
						<div class="sl-wrap clearfix">
							<div class="sl-key">价&nbsp;格（元）：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="typeUL">
										<input type="hidden" name="priceId" id="priceId" value="${empty param.priceId?-1:param.priceId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<c:forEach items="${requestScope.priceList}" var="price">
										<li><a value="${price.id}" title="${price.priceBa}" href="javascript:void(0);">${price.priceBa}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">
								所&nbsp;属&nbsp;省&nbsp;份：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="locationUL">
										 <input type="hidden" name="provinceId" id="provinceId"  value="${empty param.provinceId?-1:param.provinceId}"> 
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<c:forEach items="${requestScope.provinceList}" var="province">
										<li><a value="${province.id}" title="${province.province}" href="javascript:void(0);">${province.province}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="sl-ext">
								<span><em>更多</em><i class="icon"></i></span>
							</div>
						</div>
						<div class="sl-wrap clearfix no-border">
							<div class="sl-key">
								搜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;索：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<div class="sl-search">
										<!-- <input class="ipt-txt" type="text" name="itemname"> -->
										<button class="sl-search-btn" onclick="return false;"></button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				<div class="tab">
				<ul class="tabs-list clearfix">
				
					<c:choose>
						<c:when test="${empty requestScope.wcompanyList }">
							<center><h1><font style="font-size: 24px;font-family:幼圆 ;">当前查询无结果</font></h1></center>
						</c:when>
						<c:otherwise>
							
							<c:forEach items="${requestScope.wcompanyList }" var="wcompanyList">
								<li>
									<div class="hd">
										<p class="phot">
										<a href="informationfindbyid.do?id=${wcompanyList.cname}"><img  border="0" src="upimg/${wcompanyList.rimg}" width="200" height="200"/></a>
										</p>
									</div>
									<div class="bd">
										<p class="name">
											<a href="informationfindbyid.do?id=${wcompanyList.cname}">${wcompanyList.firm}</a>
											<c:if test="">
												<i class="invest_ico_gray"></i>
											</c:if>
										</p>
										<p class="tits">${wcompanyList.address}</p>
										<p class="weal">
										
					                    <a javascript:void(0);="" class="one">${wcompanyList.fieldId.field}</a>
										</p>
										<p class="link">
											<a javascript:void(0);="">${wcompanyList.introduction}</a>
										</p>
									</div>
								</li>
							</c:forEach>
							</ul>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="paging">
				<div class="paging-box">
					<script type="text/javascript">
						function topage(page){
							$("#page").val(page);
							$("#searchvoform").submit();
						}
					</script>
					<ul>
						<c:choose>
							<c:when test="${requestScope.page eq 1 }">
								<li><a title="上一页" href="javascript:void(0);">&lt;&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a title="上一页" href="javascript:topage(${requestScope.page-1});">&lt;&lt;</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="index" begin="1" end="${requestScope.pageCount }">
							<c:choose>
								<c:when test="${index eq requestScope.page }">
									<li><a class="active" href="javascript:void(0);">${index}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="javascript:topage(${index});">${index}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${requestScope.page eq requestScope.pageCount }">
								<li><a title="下一页" href="javascript:void(0);">&gt;&gt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a title="下一页" href="javascript:topage(${requestScope.page+1});">&gt;&gt;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
				<!--end 分页-->

			</div>
		</div>
		<!--srh-wp-box End-->
		<!--end 内容区-->
	</div>

	<!--底部-->
	
</body>
</html>
