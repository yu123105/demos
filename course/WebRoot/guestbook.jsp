<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>留言板</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/guestbook.css">
</head>

<body>
<div class="container">

    <div class="content">
        <h3 style="float: left;">留言板</h3>
        <input type="button" value="发表主题" onClick="theme();"/>

        <%-- 第一层循环 --%>
        <s:iterator value="list" var="p">
        <div class="guestbook-list">
            <p class="guestbook-head">
                <span class="guestbook-name">${p.user.username}</span> <span class="guestbook-time">${p.datetime}</span>
            </p>

            <p class="guestbook-content">
                    ${p.cont}</p>

            <br/>
            <a style="float: right;" href="javascript:void(0);" onClick="show(this);">点击回复</a>
            <br/>
            <s:iterator value="#p['children']" var="ch">
                <!-- 子循环开始 -->
            <div class="guestbook-reply">
                    <p class="guestbook-rhead">
                        <span class="guestbook-name">${ch.user.username}</span> <span
                            class="guestbook-time">${ch.datetime}</span></p>

                    <p class="guestbook-content">
                            ${ch.cont}</p>
                <!-- 子循环结束 -->
            </div>
            </s:iterator>


            <div style="display: none;">
                <!-- 回复表单 -->
                <form action="guestbook!add" method="post" target="_top" >
                    <input type="hidden" name="parentid" value="${p.id}"/>
                    <input type="hidden" name="userid" value="${session.user.id}"/>
                    <textarea rows="5" cols="80" name="guestbook.cont"></textarea>
                    <input type="submit" value="回复"/>
                </form>

            </div>
        </div>
        </s:iterator>
        <br/>
        <br/>
    <%-- 页码 --%>
        <div>
            当前是第${pageNo}页||
            共${totalPage}页
            <%--${pageNo-1}--%>
            <a href="guestbook?pageNo=${pageNo-1}" >上一页</a>
            <a href="guestbook?pageNo=${pageNo+1}" >下一页</a>
        </div>

    </div>
    <%-- 发表主题 --%>
    <!-- end .content -->
    <div id="theme" style="display: none;">
        <span class="close" onClick="cancel();"></span>

        <form action="guestbook!add" method="post" target="_top">
            <input type="hidden" name="parentid" value="0"/>
            <input type="hidden" name="userid" value="${session.user.id}"/>
            <span class="tip">请输入内容：</span>
            <textarea name="guestbook.cont"></textarea>
            <input type="submit" value="发表主题"/>
            <a href="javascript:void(0);" onClick="cancel();">取消</a>
        </form>
    </div>
</div>

<!-- end .container -->
<script type="text/javascript">
    function show(reply) {
        var divs = reply.parentNode.getElementsByTagName("div");
        var len = divs.length;
        //alert(divs[len-1].innerHTML);
        var div = divs[len - 1];
        if (div.style.display == "") {
            div.style.display = "none";
        } else {
            div.style.display = "";
        }
    }
    function theme() {
        var theme = document.getElementById("theme");
        theme.style.display = "";
    }
    function cancel() {
        var theme = document.getElementById("theme");
        theme.style.display = "none";
    }
</script>

</body>
</html>