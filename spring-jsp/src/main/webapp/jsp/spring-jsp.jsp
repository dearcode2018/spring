<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>spring-jsp.jsp</title>
    
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
 <%
 	String id = (String) request.getAttribute("id");
 	String username = (String) request.getAttribute("username");
 	String nickname = (String) request.getAttribute("nickname");
 	String password = (String) request.getAttribute("password");
 	String type = (String) request.getAttribute("type");
 	//String valid = request.getAttribute("valid").toString();
 	//String lastLoginTime = (String) request.getAttribute("lastLoginTime");
 	String lastLoginIp = (String) request.getAttribute("lastLoginIp");
  %>   
    
    <input type="text" value="<%=id%>" />
    <input type="text" value="<%=username%>" />
    <br />
    <input type="text" value="<%=nickname%>" />
    <input type="text" value="<%=password%>" />
    <br />
    <input type="text" value="<%=lastLoginIp%>" />
    <br />
    <p>这里写你的初始化内容<img src="/ueditor/jsp/upload/image/20150812/1439362830099026817.png" title="1439362830099026817.png" alt="secondarytile.png"/></p>
  </body>
</html>
