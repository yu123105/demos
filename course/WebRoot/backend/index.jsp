<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=utf8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>
<style type="text/css">
html,body {
	font: normal 20px verdana;
	margin: 0;
	padding: 0;
	border: 0 none;
	overflow: hidden;
	height: 100%;
}

.empty .x-panel-body {
	padding-top: 0;
	text-align: center;
	color: gray;
	font-size: 14px;
}

.x-btn button {
	font-size: 14px;
}

.x-panel-header {
	font-size: 16px;
}
</style>

<link rel="styleSheet" type="text/css"
	href="js/ExtJS/resources/css/ext-all.css" />
<script type="text/javascript" charset="utf-8"
	src="js/ExtJS/ext-all-debug.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/ExtJS/ext-lang-zh_CN.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/backend.js"></script>

<body>

</body>
</html>
