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
    BODY {margin: 40pt} 
    .wangzhanjianjie{ margin-top: 4px;width: 100px;height: 33px;background: #65c294;border-radius: 10px;} 
    .wangzhanjianjie-line{margin-top: -2px;}
    .wangzhanjianjie-header{margin-left: 40px;}
    .wangzhan-background{ width: 35%;height: 250px;margin-top: -350px;margin-left: 600px;}
    .wangzhanjianjie-message{position: absolute;margin-left: 27px;margin-top: 100px;}
    .what-meet{ margin-top: -25px;margin-left: 40px;}
    .what-meet-text{margin-top:-12px;margin-left: 40px;}
    .why-meet{ margin-top: -29px;margin-left: 40px;}
    .why-meet-text{margin-top:-12px;margin-left: 40px;}
    .make-what{margin-top: -29px;margin-left: 40px;}
    .make-what-text{margin-top:-12px;margin-left: 40px;}
    .object-meet{margin-top: -29px;margin-left: 40px;}
    .object-meet-text{margin-top:-12px;margin-left: 40px;}
    .dream-meet{margin-top: -29px;margin-left: 40px;}
    .dream-meet-text{margin-top:-12px;margin-left: 40px;}
    
</STYLE>  
<BODY TOPMARGIN=30 LEFTMARGIN=30 MARGINWIDTH=30 MARGINHEIGHT=30>  
<div class="wangzhanjianjie"> <h2><font face="楷体" size="5" color="white">关于我们</font></div></h2>
<hr class="wangzhanjianjie-line" color="#65c294" size="2"/>
<div class="wangzhanjianjie-header">
	<img src="images/1.jpg" width="48%" height="380px"/>
</div>
<div class="wangzhan-background">
	<p class="wangzhan-background-text"><font face="微软雅黑" size="4">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;目前，高中生选择大学专业时，出现盲目性，没有选择自己感兴趣的专业，导致很多大学生后悔自己当初选的专业，不愿意好好学习，导致人生选择的偏差。

	</font> </p>
	<p class="wangzhan-background-text"><font face="微软雅黑" size="4">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在社会上，就业难已经成了一大难题。其中求职者不清楚自己的合适职业是什么，无法准确的应聘合适的职位，是导致就业难的其中一个原因，同时企业也难以挑选到合适的职员。

	</font> </p>
	<p class="wangzhan-background-text"><font face="微软雅黑" size="4">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基于这两种现象，遇见网产生了，希望能成为你未来的得力助手。

	</font> </p>

</div>
<div class="wangzhanjianjie-message">
	<img src="images/2.png" width="25px" height="25px"/>
	<p class="what-meet"><font face="微软雅黑"color="black" size="4">什么是遇见网?</font></p>
	<p class="what-meet-text"><font face="微软雅黑" color="grey" size="3">1.遇见网专注于高中生以及求职者对专业的了解，进行专业指导</font></p>
	<img src="images/2.png" width="25px" height="25px"/>
	<p class="why-meet"><font face="微软雅黑"color="black" size="4">为什么做遇见网?</font></p>
	<p class="why-meet-text"><font face="微软雅黑" color="grey" size="3">1.高中生通过网站与名校各专业老师交流、看专业讲解视频，合理选择自己的大学专业。</font></p>
	<p class="why-meet-text"><font face="微软雅黑" color="grey" size="3">2.求职者通过体验不同的岗位，寻找自己适合的职业。</font></p>
	
	<img src="images/2.png" width="25px" height="25px"/>
	<p class="make-what"><font face="微软雅黑"color="black" size="4">遇见网做什么?</font></p>
	<p class="make-what-text"><font face="微软雅黑" color="grey" size="3">1.专业指导，视频讲解，职业体验</font></p>
	<img src="images/2.png" width="25px" height="25px"/>
	<p class="object-meet"><font face="微软雅黑"color="black" size="4">遇见网服务的对象?</font></p>
	<p class="object-meet-text"><font face="微软雅黑" color="grey" size="3">1.要想合理选择自己专业的高中生。</font></p>
	<p class="object-meet-text"><font face="微软雅黑" color="grey" size="3">2.不清楚自己适合什么职业的求职者。</font></p>
	<p class="object-meet-text"><font face="微软雅黑" color="grey" size="3">3.提供体验服务的企业。</font></p>
	<p class="object-meet-text"><font face="微软雅黑" color="grey" size="3">4.提供专业指导的老师。</font></p>
	<img src="images/2.png" width="25px" height="25px"/>
	<p class="dream-meet"><font face="微软雅黑"color="black" size="4">遇见网的追求是什么?</font></p>
	<p class="dream-meet-text"><font face="微软雅黑" color="grey" size="3">1.使下一代的花朵，做一个清楚自己未来并为之努力的追梦的青年！</font></p>
</div>

</body></html>