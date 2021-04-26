<%--
  Created by IntelliJ IDEA.
  User: 鑫宇
  Date: 2021/4/25
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--    永远固定相对路径跳转到的结果  动态获取base地址-->
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<%--这里的写法要注意--%>
<base href=<%=basePath%>>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<!--引入JQuery-->
<script src="static/Jquery.js"></script>
