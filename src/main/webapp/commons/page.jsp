
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-27
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .page{
            font-size: 25px;
        }
    </style>
</head>
<body>
    <div class="page">
        <p>第${page.currentPage}页/共${page.totalPages}页</p>
        <p>
            <a href="${ctx}${page.url}&pageNum=${page.prePage}">上一页</a>
            <a href="${ctx}${page.url}&pageNum=${page.nextPage}">下一页</a>
        </p>
    </div>

</body>
</html>
