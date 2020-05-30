<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-28
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>头</title>
    <style type="text/css">
        /*body{*/
        /*    margin: 0 auto;*/

        /*}*/
        ul{
            list-style-type: none;
            /*position: relative;*/
            /*left: 400px;*/
        }
        li{
            margin-left: 50px;
            float: left;
            /*margin: 0px 30px;*/
        }
    </style>
</head>
<body>
    <input type="hidden" value="">
    <ul>
<%--        <li><a href="${ctx}/clientServlet?method=showIndex&pageNum=1">首页</a></li>--%>
        <c:if test="${USER_SESSION != null}">
            <li>你好，${USER_SESSION.username}</li>
            <li><a href="${ctx}/userServlet?method=userLogout">注销</a></li>
        </c:if>
        <c:if test="${USER_SESSION == null}">
            <li><a href="${ctx}/userServlet?method=toLogin">登录</a></li>
            <li><a href="${ctx}/userServlet?method=toRegister">注册</a></li>
        </c:if>
        <li><a href="">订单</a></li>
        <li><a href="">购物车</a></li>
        <li><a href="./admin.jsp">后台管理</a></li>
    </ul>
    <br>
</body>
</html>
