<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
   <link rel="stylesheet" type="text/css" href="bootstrap3.3.5/css/bootstrap.min.css">
    <script src="bootstrap3.3.5/js/jquery-2.2.4.min.js"></script>
    <script src="bootstrap3.3.5/js/bootstrap.min.js"></script>     
    
  </head>
  
  <body>
<form class="form-horizontal">                                   <!--水平布局-->
        <div class="form-group"> 
            <label class="col-xs-2 control-label"></label>
            <div class="col-xs-8">                                   <!--栅格大小-->
                <!-- <input type="text" class="form-control" name=""> -->
            </div>
        </div>
        <div class="form-group"> 
            <label for="password" class="col-xs-2 control-label"></label>
            <div class="col-xs-8">
            <form  action="sbcn.do"  method="post"></form>
                <input type="text" id="password" placeholder="请输入您要查询的指导老师姓名或公司名称" class="form-control" name="search"/>
                <input   type="submit" value="搜索"/>
                </form>
            </div>
        </div>

  </body>
</html>
