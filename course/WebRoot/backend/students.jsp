<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<base href="<%=basePath%>">

<title>精品视频教程</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.delete {
	float: right;
	margin-right: 30px;
}

.edit {
	float: right;
	margin-right: 30px;
}

.dob {
	font-size: 14px;
	text-indent: 2em;
	padding-top: 3px;
	padding-bottom: 3px;
}

.odd {
	background-color: #94C9CF;
	font-size: 14px;
	text-indent: 2em;
	padding-top: 3px;
	padding-bottom: 3px;
}

#paging {
	text-align: center;
	font-size: 12px;
	margin-top: 10px;
}

img {
	border: none;
}
</style>
</head>

<body style="width:980px; margin:0px auto; padding-top:10px;">
	<!-- 
<div class="odd"> <span class="delete"><a href="#" title="删除"><img src="images/delete.png" /></a></span><span class="edit"><a href="#" title="编辑"><img src="images/pen.png" /></a></span>精品教程</div>
<div class="dob"> <span class="delete"><a href="#" title="删除"><img src="images/delete.png" /></a></span><span class="edit"><a href="#" title="编辑"><img src="images/pen.png" /></a></span>精品教程</div>
<div id="paging"style="text-align:center">
<a href="#" >第一页</a> &nbsp;&nbsp; <a href="#">上一页</a> &nbsp;&nbsp;<a href="#" >下一页</a> &nbsp;&nbsp;<a href="#" >最后一页</a>&nbsp;&nbsp; 共计？页
</div>
<iframe id="iframeC" name="iframeC" src="" width="0" height="0" style="display:none;" ></iframe>
 -->
	<table>
		<tr>
			<th>ID</th>
			<th>学生姓名</th>
			<th>电话</th>
			<th>昵称</th>
			<th>班级</th>
			<th>操作</th>
		</tr>
		<s:iterator value="stus" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.realname}</td>
				<td>${s.phone}</td>
				<td>${s.username}</td>
				<td>${s.clazz}</td>
				<td><a href="stu!delete?id=${s.id}" title="删除"><img src="images/delete.png" /></a></td>
			</tr>
		</s:iterator>
	</table>

	<a href="backend/stu!view?pageNo=1">第一页</a> &nbsp;&nbsp;
	<a href="backend/stu!view?pageNo=${pageNo-1}">上一页</a> &nbsp;&nbsp;
	<a href="backend/stu!view?pageNo=${pageNo+1}" >下一页</a> &nbsp;&nbsp;
	<a href="backend/stu!view?pageNo=${totalPage}">最后一页</a>&nbsp;&nbsp; 共计 ${totalPage} 页
	
	<s:debug></s:debug>
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

