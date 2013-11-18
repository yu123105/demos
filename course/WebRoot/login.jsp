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

<title>用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
#center {
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	padding-top: 330px;
	padding-bottom: 50px; auto;
	padding-left: 0px;
	padding-right: 0px;
	width: 530px;
	margin-top: 50px;
	margin-bottom: 50px;
	background-image: url(images/login.png);
	background-repeat: no-repeat;
}

#main {
	margin: 0px auto;
	width: 980px;
}

#form {
	margin-top: -200px;
	margin-left: 140px;
	color: #3266cc;
	font-family: "Microsoft YaHei UI";
	font-size: 16px;
	font-weight: bold;
}

#form a {
	text-decoration: none;
	font-size: 14px;
	color: #999999;
	font-weight: bold;
}

#btn {
	margin-left: 30px;
	margin-right: 40px;
	background-image: url(images/btn.PNG);
	width: 100px;
	height: 50px;
	border: none;
}

#forgot {
	margin-bottom: 10px;
	float: right;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>
	<div id="main">
		<div id="center">
			<form action="login!login" method="post" target="_top">
				<div id="form">
					用&nbsp;户&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
						name="user.username" /><br />
					<br /> &nbsp;&nbsp;密&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="password" name="user.password" /> <br />
					<br /> <input type="submit" id="btn" value="" /> <a
						href="forget.jsp"> <img src="images/forgotl.png" border="0" />
					</a>
				</div>
			</form>
		</div>
	</div>
	<iframe id="iframeC" name="iframeC" src="" width="0" height="0"
		style="display:none;"></iframe>

	<script type="text/javascript">
		function sethash() {
			hashH = Math.min(document.documentElement.scrollHeight,
					document.body.scrollHeight + 101);
			urlC = "agent.html";
			document.getElementById("iframeC").src = urlC + "#" + hashH;
		}
		window.onload = sethash;
	</script>
</body>
</html>

