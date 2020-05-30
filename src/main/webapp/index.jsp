
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-26
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>首页</title>
</head>
<body>

    <jsp:include page="/clientServlet">
        <jsp:param name="method" value="showIndex"/>
    </jsp:include>


</body>
</html>
