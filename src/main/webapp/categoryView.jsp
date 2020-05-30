<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-26
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>修改分类</title>
</head>
<body>
<%--<%@include file="commons/head.jsp"%>--%>
<%--    <div>--%>
<%--        <form action="${ctx}/categoryServlet?method=addCategory" method="post"></form>--%>
<%--        <input type="text" name="cname">--%>
<%--        <input type="submit" value="添加">--%>
<%--    </div>--%>
    <div>
        <form action="${ctx}/categoryServlet?method=updateCategory&cid=${category.cid}" method="post">
            <input type="text" name="cname" value="${category.cname}">
            <input type="submit" value="修改">
        </form>
    </div>




</body>
</html>
