<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>evaluation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	学生日常点评
    <form action="evaluation.action" method="post">
    	ctid:<input type="text" name="ctid"><br/>
    	schoolnumber:<input type="text" name="schoolnumber"><br>
    	endtime:<input type="text" name="endtime"><br/>
    	学习效果：☆<input type="radio" name="effect" value="20">
    	☆<input type="radio" name="effect" value="40">
    	☆<input type="radio" name="effect" value="60">
    	☆<input type="radio" name="effect" value="80">
    	☆<input type="radio" name="effect" value="100"><br/>
    	教学纪律：调课<input type="radio" name="discipline" value="1">
    	停课<input type="radio" name="discipline" value="2">
    	不准时上下课<input type="radio" name="discipline" value="3"><br/>
    	到课情况：&lt;50%<input type="radio" name="attendance" value="1">
    	70%左右<input type="radio" name="attendance" value="2">
    	&gt;90%<input type="radio" name="attendance" value="3"><br/>
    	教学进度：快<input type="radio" name="speed" value="1">
    	适中<input type="radio" name="speed" value="2">
    	慢<input type="radio" name="speed" value="3"><br/>
    	其他建议：<input type="text" name="advice"><br/>
    	<input type="submit" value="submit">
    </form>
  </body>
</html>
