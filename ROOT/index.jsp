<%@ page language="java" import="java.util.*,java.net.URL" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome to BAE</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
    <body>
        <h4>Welcome to Baidu App Engine!</h4>
        <h2>欢迎开启BAE之旅！</h2>
        <br/>
        <br/>
        <ul>以下链接可能对您有用：</ul>
        <ul><a href="https://bce.baidu.com/doc/BAE/QuickGuide.html" target="_blank">入门指南</a></ul>
        <ul><a href="http://developer.baidu.com/forum/topic/list?boardId=66" target="_blank">论坛</a></ul>
        <ul><a href="http://www.baeblog.com/" target="_blank">技术博客</a></ul>
        <ul><a href="http://weibo.com/baiduappengine" target="_blank">微博</a></ul>
        <ul><a href="https://bce.baidu.com/doc/BAE/FAQ.html" target="_blank">常见问题</a></ul> 
    </body>
</html>
