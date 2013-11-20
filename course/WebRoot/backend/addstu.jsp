<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addstu.jsp' starting page</title>
    
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
  <form action="stu!add" method="post">
    <table>
		<tr>
			<td>用户名/昵称：</td>
			<td><input type="text" name="stu.username"  /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="stu.password" /></td>
		</tr>
		<tr>
			<td>真实姓名：</td>
			<td><input type="text" name="stu.realname" /></td>
		</tr>
		<tr>
			<td>班级：</td>
			<td><input type="text" name="stu.clazz" /></td>
		</tr>
		<tr>
			<td>电话：</td>
			<td><input type="text" name="stu.phone" /></td>
		</tr>
		<tr>
			<td><input type="reset" value="重置" /></td>
			<td><input type="button" value="提交"></td>
		</tr>
    </table>
  </form>
  </body>
</html>
