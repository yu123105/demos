<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>top.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
#outline {
	margin: 0px auto;
	width: 980px;
	height: 100%;
	background-image: url(images/guide.jpg);
	padding-top: 50px;
	margin-top: -40px;
	-moz-box-shadow: 3px 3px 4px #666666;
	-webkit-box-shadow: 3px 3px 4px #666666;
	box-shadow: 0px 5px 7px #666666;
	/* For IE 8 */
	-ms-filter:
		"progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666')";
	/* For IE 5.5 - 7 */
	filter: progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135,
		Color='#666666' );
}

#guide {
	padding-top: 0px;
	padding-bottom: 0px;
	margin-top: -35px;
	margin-left: 130px;
	margin-right: 130px;
	font-family: "Microsoft YaHei UI";
	font-size: 16px;
	text-decoration: none;
}

#guide a {
	text-decoration: none;
	color: #ffffff;
}

#top {
	margin: 0px auto;
	width: 980px;
	height: 95px;
	background-image: url(images/top.png);
	padding-top: 70px;
	margin-top: -10px;
}

#logo {
	background-image: url(images/logo.jpg) margin-left:160px;
	padding-top: 0px;
	padding-bottom: 0px;
	margin-top: -30px;
	margin-left: 50px;
	width: 100px;
	float: left;
}

#name {
	margin-bottom: 40px;
}

#cn {
	color: #205AAB;
	font-size: 20px;
	font-family: "Microsoft YaHei UI";
}

#en {
	color: #3266cc;
}

#login {
	margin-left: 790px;
	margin-top: -64px;
}

#login a {
	color: #3266cc;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
	text-decoration: none;
}
</style>
</head>

<body>
	<div id="top">
		<div id="login">
			<a href="login.html" target="main">用户登录</a>
		</div>
		<div id="logo">
			<img src="images/logo.png" />
		</div>
		<div id="name">
			<span id="cn"> &nbsp; &nbsp;浙江万里学院</span><br />
			<span id="en">Zhejiang wanli University</span>
		</div>
	</div>
	<div id="outline">
		<div id="guide">
			<a href="main.jsp" target="main">首页</a> &nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a
				href="main.jsp" target="main">课程介绍</a>&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a
				href="main.jsp" target="main">师资力量</a>&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a
				href="main.jsp" target="main">在线测试</a>&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a
				href="main.jsp" target="main">教学视频</a>&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a
				href="main.jsp" target="main">留言板</a>
		</div>
	</div>
	
</body>
</html>
