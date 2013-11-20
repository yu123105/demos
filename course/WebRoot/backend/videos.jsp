<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
.download{float:right; margin-right:30px;}
.dob{ font-size:14px; text-indent:2em; padding-top:3px; padding-bottom:3px;}
.odd{ background-color:#94C9CF; font-size:14px; text-indent:2em; padding-top:3px; padding-bottom:3px;}
#paging{text-align:center; font-size:12px; margin-top:10px;}
img{ border:none;}
</style>
</head>

<body style="width:980px; margin:0px auto; padding-top:10px;" >

<table>
	<tr>
		<th>文件名</th>
		<th>上传日期</th>
		<th>path</th>
	</tr>
	<s:iterator value="vids" var="v" >
	<tr>
		<td>${v.vname}</td>
		<td>${v.datetime}</td>
		<td>${v.path}</td>
	</tr>
	</s:iterator>
</table>

	<a href="backend/vid!view?pageNo=1">第一页</a> &nbsp;&nbsp;
	<a href="backend/vid!view?pageNo=${pageNo-1}">上一页</a> &nbsp;&nbsp;
	<a href="backend/vid!view?pageNo=${pageNo+1}" >下一页</a> &nbsp;&nbsp;
	<a href="backend/vid!view?pageNo=${totalPage}">最后一页</a>&nbsp;&nbsp; 共计 ${totalPage} 页

<script type="text/javascript"> 
function sethash(){
    hashH = Math.min(document.documentElement.scrollHeight,document.body.scrollHeight+101);
    urlC = "agent.html"; 
    document.getElementById("iframeC").src=urlC+"#"+hashH; 
}
window.onload=sethash;
</script>
</body>
</html>

