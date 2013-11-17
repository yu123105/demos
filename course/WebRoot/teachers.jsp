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
    
    <title>师资力量</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	.content{margin:0px auto;width:980px;height: 100%;     
	-moz-box-shadow: 3px 3px 4px #666666;
    -webkit-box-shadow: 3px 3px 4px #666666;
    box-shadow: 0px 3px 7px #666666;
    /* For IE 8 */
    -ms-filter: "progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666')";
    /* For IE 5.5 - 7 */
    filter: progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#666666');
	 margin-bottom:20px; height:270px; background-image:url(images/teacher-background.png); background-repeat:repeat-x;}
	 .content img{ height:270px; width:200px;}
</style>
</head>


<body style="width:980px; margin:0px auto; padding-top:20px;">
	<div class="content" ><div style="float: left;"><img src="images/teacher1.png"/></div><div style="height:inherit"><span>dadad</span></div></div>
	<div class="content" ><div><div style="float: left;"><img src="images/teacher2.png" /></div>dasd</div></div>
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

