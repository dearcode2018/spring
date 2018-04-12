<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="renderer" content="webkit">
	  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	  <meta name="apple-mobile-web-app-capable" content="yes">
	  <meta name="apple-mobile-web-app-status-bar-style" content="black">
	  <title>公告详情</title>
  	  <link rel="stylesheet" href="<%=path%>/css/reset.css">
  	  <link rel="stylesheet" href="<%=path%>/css/style.css">		
	  <script type="text/javascript">        !function(a){function b(){var b=g.getBoundingClientRect().width;a.rem=(b/6.4>100?100:(b/6.4<50?50:b/6.4)),g.style.fontSize=a.rem+ "px"}var g=a.document.documentElement,e;a.addEventListener( "resize",function(){clearTimeout(e),e=setTimeout(b,300)},!1),a.addEventListener( "pageshow",function(a){a.persisted&&(clearTimeout(e),e=setTimeout(b,300))},!1),b()}(window);
	  </script>
	</head>
  
	<body>
	<script type="text/javascript">
	window.onload = function(){
	  var btnBack = document.getElementById("btnBack");
	  btnBack.addEventListener("touchstart",function(){
	    history.go(-1);
	  })
	}
	</script>	
		<header>
	  </header>
	  <article class="detail">
	    <h3>${title}</h3>
	    <div class="infor">
	      <div class="inblock">${date}</div>
	      <div class="inblock">${author}</div>
	    </div>
	    <div class="content">
	   		 ${content}
	    </div>
	  </article>
	</body>
</html>
