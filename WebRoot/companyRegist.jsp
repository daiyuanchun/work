<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>

<title>公司用户注册页面</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style>
/* === Remove input autofocus webkit === */
body{font:50px/60px "幼圆";}
body {
	background-image: URL("3.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	}
*:focus {outline: none;}
.contact{width:720px;margin:0px auto;padding:10px;}

/* === Form Typography === */
.contact_form h2{font-size:30px;font-weight:bold;}
.contact_form label{font-size:25px;}
.form_hint, .required_notification{font-size: 18px;}

/* === List Styles === */
.contact_form ul {width:720px;list-style-type:none;list-style-position:outside;padding:0px;}
.contact_form li{padding:12px; border-bottom:1px solid #DFDFDF;position:relative;} 
.contact_form li:first-child, .contact_form li:last-child {border-bottom:1px solid #777;}

/* === Form Header === */
.contact_form h2 {margin:0;display: inline;}
.required_notification {color:#d45252; margin:5px 0 0 0; display:inline;float:right;}

/* === Form Elements === */
.contact_form label {width:150px;margin-top: 3px;display:inline-block;float:left;padding:3px;}
.contact_form input {height:20px; width:220px; padding:5px 8px;}
.contact_form textarea {padding:8px; width:300px;}
.contact_form button {margin-left:156px;}

	/* form element visual styles */
.contact_form input, .contact_form textarea { 
	border:1px solid #aaa;
	box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
	border-radius:2px;
	padding-right:30px;
	-moz-transition: padding .25s; 
	-webkit-transition: padding .25s; 
	-o-transition: padding .25s;
	transition: padding .25s;
}
.contact_form input:focus, .contact_form textarea:focus {
	background: #fff url(images/red_asterisk.png) no-repeat; 
	border:1px solid #555; 
	box-shadow: 0 0 3px #aaa; 
	padding-right:70px;
}

/* === HTML5 validation styles === */	
.contact_form input:required, .contact_form textarea:required {background: #fff url(images/red_asterisk.png) no-repeat 98% center;}
.contact_form input:required:valid, .contact_form textarea:required:valid {background: #fff url(images/valid.png) no-repeat 98% center;box-shadow: 0 0 5px #5cd053;border-color: #28921f;}
.contact_form input:focus:invalid, .contact_form textarea:focus:invalid {background: #fff url(images/invalid.png) no-repeat 98% center;box-shadow: 0 0 5px #d45252;border-color: #b03535;}

/* === Form hints === */
.form_hint {
	background: #d45252;
	border-radius: 3px 3px 3px 3px;
	color: white;
	margin-left:8px;
	padding: 1px 6px;
	z-index: 999; 
	position: absolute; 
	display: none;
}
.form_hint::before {
	content: "\25C0";
	color:#d45252;
	position: absolute;
	top:1px;
	left:-6px;
}
.contact_form input:focus + .form_hint {display: inline;}
.contact_form input:required:valid + .form_hint {background: #28921f;}
.contact_form input:required:valid + .form_hint::before {color:#28921f;}
	
/* === Button Style === */
button.submit {
	background-color: #68b12f;
	background: -webkit-gradient(linear, left top, left bottom, from(#68b12f), to(#50911e));
	background: -webkit-linear-gradient(top, #68b12f, #50911e);
	background: -moz-linear-gradient(top, #68b12f, #50911e);
	background: -ms-linear-gradient(top, #68b12f, #50911e);
	background: -o-linear-gradient(top, #68b12f, #50911e);
	background: linear-gradient(top, #68b12f, #50911e);
	border: 1px solid #509111;
	border-bottom: 1px solid #5b992b;
	border-radius: 30px;
	-webkit-border-radius: 30px;
	-moz-border-radius: 3px;
	-ms-border-radius: 3px;
	-o-border-radius: 3px;
	box-shadow: inset 0 1px 0 0 #9fd574;
	-webkit-box-shadow: 0 1px 0 0 #9fd574 inset;
	-moz-box-shadow: 0 1px 0 0 #9fd574 inset;
	-ms-box-shadow: 0 1px 0 0 #9fd574 inset;
	-o-box-shadow: 0 1px 0 0 #9fd574 inset;
	color: white;
	font-weight: bold;
	padding: 6px 20px;
	text-align: center;
	text-shadow: 0 -1px 0 #396715;
}
button.submit:hover {
	opacity:.85;
	cursor: pointer; 
}
button.submit:active {
	border: 1px solid #20911e;
	box-shadow: 0 0 10px 5px #356b0b inset; 
	-webkit-box-shadow:0 0 10px 5px #356b0b inset ;

	-moz-box-shadow: 0 0 10px 5px #356b0b inset;
	-ms-box-shadow: 0 0 10px 5px #356b0b inset;
	-o-box-shadow: 0 0 10px 5px #356b0b inset;
	
}
.exit{
    font-size:18px;
}
</style>
    <script src="http://www.jiawin.com/wp-content/themes/javin/js/jquery.js"></script>
    <script type="text/javascript">
	jQuery(document).ready(function($){							
		$('#ads_close').click(function(e){
			$('#ads_box').fadeOut();
			e.preventDefault();
		});
	});
	function check(){
	 if(form3.cname.value.length<1){
	    alert("用户名不可为空！");
	    return false;
	    }
	    if(form3.cname.value.length>20){
	    alert("用户名字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.password.value.length<1){
	    alert("密码不可为空！");
	    return false;
	    }
	    if(form3.password.value.length>20){
	    alert("密码字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.passmessage.value.length<1){
	    alert("密码口令不可为空！");
	    return false;
	    }
	    if(form3.passmessage.value.length>20){
	    alert("密码口令字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.tel.value.length<1){
	    alert("电话不可为空！");
	    return false;
	    }
	    if(form3.tel.value.length>20){
	    alert("电话字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.email.value.length<1){
	    alert("邮箱不可为空！");
	    return false;
	    }
	    if(form3.email.value.length>20){
	    alert("邮箱字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.firm.value.length<1){
	    alert("公司名称不可为空！");
	    return false;
	    }
	    if(form3.firm.value.length>20){
	    alert("公司名称字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.industry.value.length<1){
	    alert("公司领域不可为空！");
	    return false;
	    }
	    if(form3.industry.value.length>20){
	    alert("公司领域字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.address.value.length<1){
	    alert("公司地址不可为空！");
	    return false;
	    }
	    if(form3.address.value.length>50){
	    alert("公司地址字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.introduction.value.length<1){
	    alert("公司介绍不可为空！");
	    return false;
	    }
	    if(form3.introduction.value.length>500){
	    alert("公司介绍字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    if(form3.websit.value.length<1){
	    alert("网站不可为空！");
	    return false;
	    }
	     if(form3.websit.value.length>50){
	    alert("网站字数长度超出了规定的范围！请重新输入！");
	    return false;
	    }
	    
	    form3.submit();
    }
</script>

</head>
<body>
<div class="contact">
<center><font style="color:red">${requestScope.companyErrorInfo }</font></center>
<form class="contact_form" action="CompanyRegist.do" method="post" enctype="multipart/form-data" id="form3">
    <ul>
        <li>
             <h2>企业注册</h2>
             <span class="required_notification"></span>
        </li>
        <li>
            <label for="cname">用户名:</label>
            <input type="text"  name="cname" placeholder="6~20个字符，可使用字母，数字，汉字" required />
            <span class="form_hint">(必填项)此项为您的注册账号，正确格式为：1~20个字符，可使用字母、数字，汉字</span>
        </li>
        
        <li>
            <label for="password">密码:</label>
            <input type="password" name="password" placeholder="6~20个字符，可使用字母、数字" required />
            <span class="form_hint">(必填项)正确格式为：1~20个字符，可使用字母、数字</span>
        </li>
        
        <li>
            <label for="passmessage">密码口令:</label>
            <input type="text"  name="passmessage" placeholder="用于找回密码" required />
        <span class="form_hint">正确格式为：1~20个字符，可使用字母、数字,汉字；用于找回密码,下次登录时如果忘记密码,可输入密码口令进行登陆</span>
        </li>
        
         <li>
            <label for="tel">电话:</label>
            <input type="text" name="tel" placeholder="请输入您的手机号或电话号" required />
            <span class="form_hint">(必填项)请输入您的手机号或电话号，任选其一填写即可。</span>
        </li>
         <li>
            <label for="email">邮箱:</label>
            <input type="email" name="email" placeholder="请输入您的邮箱号" required />
            <span class="form_hint">(必填项)请输入您的常用的邮箱号，便于联系</span>
        </li>
         <li>
            <label for="firm">公司名称:</label>
            <input type="text" name="firm" placeholder="公司名称" required />
            <span class="form_hint">(必填项)请输入公司名称，正确格式为：不多于50个字符</span>
        </li>
         <li>
            <label for="industry">所属行业:</label>
            <input type="text" name="industry" placeholder="公司所属行业" required />
            <span class="form_hint">(必填项)公司所属行业，正确格式为：不多于20个字符</span>
        </li>
        <li>
            <label for="address">地址:</label>
            <input type="text" name="address" placeholder="请输入公司详细地址" />
            <span class="form_hint">(必填项)请输入公司详细地址，正确格式为：不多于50个字符</span>
        </li>
        
          <li>
            <label for="picture">营业执照:</label>
            <input type="file" name="picture" placeholder="(必填项)可以证明您公司的工商营业执照" required />
            </li>
             <li>
            <label for="introduction">公司介绍:</label>
                 <textarea name="introduction" cols="40" rows="6" placeholder="(必填项)不多于500字" required >
                 </textarea>
 
            </li>
            <li>
            <label for="cimg">个人头像:</label>
            <input type="file" name="cimg" placeholder="(选填项)个人头像，这个照片任意" required />
            </li>
            <li>
            <label for="rimg">公司照:</label>
            <input type="file" name="rimg" placeholder="(必填项)公司一角照，可用于代表公司形象" required />
            </li>
            <li>
            <label for="website">公司网站:</label>
            <input type="url" name="website" placeholder="(必填项)http://www.amonyous.com" required pattern="(http|https)://.+"/>
            <span class="form_hint">正确格式为：http://www.amonyous.com</span>
        </li>
 
            
        <li>
        	<button class="submit" type="submit" onclick="check()">注册</button>&nbsp;&nbsp;&nbsp;
					<a href="chooseUserType.jsp" ><span class="exit">退出</span></a>
        </li>
    </ul>
</form>

</div>

</body>
</html>