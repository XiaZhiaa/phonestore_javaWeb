
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-30
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<html>
<head>
    <title>底部</title>
    <style type="text/css">
       .bottom{
           margin: 20px auto;
           width: 700px;
       }
    </style>
</head>
<body>
<!--5.友情链接和版权信息-->
<div class="bottom">
    <table>
        <tr>
            <td align="center">
                <a href="#">关于我们</a>
                <a href="#">联系我们</a>
                <a href="#">招贤纳士</a>
                <a href="#">法律声明</a>
                <a href="#">友情链接</a>
                <a href="#">支付方式</a>
                <a href="#">配送方式</a>
                <a href="#">服务声明</a>
                <a href="#">广告声明</a>
                <p>
                    Copyright © 2019-2020 三组 版权所有
                </p>
            </td>
        </tr>
    </table>
</div>


</body>
</html>
