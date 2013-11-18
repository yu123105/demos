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
<title>底部</title>

<style type="text/css">
#copyright {
	width: 980px;
	text-align: center;
	height: 140px;
	margin-top: 5px;
	margin-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	background-image: url(images/bottom.png);
	background-repeat: no-repeat;
	-moz-box-shadow: 3px 3px 4px #666666;
	-webkit-box-shadow: 3px 3px 4px #666666;
	box-shadow: 0px -5px 5px #666666;
	/* For IE 8 */
	-ms-filter:
		"progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666')";
	/* For IE 5.5 - 7 */
	filter: progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135,
		Color='#666666' );
}
</style>
</head>
<body>
	<div id="copyright">
		<br />
		<li><h4>您是第?位访问我们网站的游客</h4>
		</li> Copyright ?2013-2020&nbsp;<a href="http://hzch.js.zwu.edu.cn"
			title="会展经济与管理专业">会展经济与管理专业http://hzch.js.zwu.edu.cn</a> All Rights
		Reserved.
	</div>
</body>
</html>