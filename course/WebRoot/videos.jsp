<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
 	<base href="<%=basePath%>">
    
    <title>��Ʒ��Ƶ�̳�</title>
    
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
.play{float:right; margin-right:30px;}
.dob{ font-size:14px; text-indent:2em; padding-top:3px; padding-bottom:3px;}
.odd{ background-color:#94C9CF; font-size:14px; text-indent:2em; padding-top:3px; padding-bottom:3px;}
#paging{text-align:center; font-size:12px; margin-top:10px;}
img{ border:none;}
</style>
</head>

<body style="width:980px; margin:0px auto; padding-top:10px;" >

<div class="odd"><span class="download"><a href="#" title="����"><img src="images/download.png" /></a></span> <span class="play"><a href="#" title="����"><img src="images/play.png" /></a></span>��Ʒ�̳�</div>
<div class="dob"><span class="download"><a href="#" title="����"><img src="images/download.png" /></a></span> <span class="play"><a href="#" title="����"><img src="images/play.png" /></a></span>��Ʒ�̳�</div>
<div id="paging"style="text-align:center">
<a href="#" >��һҳ</a> &nbsp;&nbsp; <a href="#">��һҳ</a> &nbsp;&nbsp;<a href="#" >��һҳ</a> &nbsp;&nbsp;<a href="#" >���һҳ</a>&nbsp;&nbsp; ���ƣ�ҳ
</div>
<iframe id="iframeC" name="iframeC" src="" width="0" height="0" style="display:none;" ></iframe>

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

