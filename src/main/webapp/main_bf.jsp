<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-28
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>主页</title>
    <style type="text/css">
        div{
            margin: 0 auto;
            width: 1500px;
            text-align: center;
        }
        table tr td{
            width: 300px;
        }

    </style>
</head>
<body>

    <div>
        <%@include file="commons/head.jsp"%>
        <br>
    </div>

<br>
<br>
<hr>


    <div>
        <!-- 分类 -->
        <div>
            分类：
            <c:forEach items="${categoryList}" var="c">
                <a href="${ctx}/clientServlet?method=showCategoryPhones&cid=${c.cid}">${c.cname}</a>
            </c:forEach>
        </div>
        <!-- 商品 -->
        <table border="1px solid black" cellpadding="0" cellspacing="0" width="1500px">
            <tr>
                <c:forEach items="${page.records}" var="page">
                    <td>
                        <img src="${page.photoName}" alt="图片"><br>
                        名称：${page.pName}<br>
                        描述：${page.pDescription}<br>
                        单价：${page.price}<br>
                        库存：${page.stock}<br>
                        <a href="">查看详情</a>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </div>

    <div>
        <%@include file="commons/page.jsp"%>
    </div>
<%--    <div>--%>
<%--        <p>第${page.currentPage}页/共${page.totalPages}页</p>--%>
<%--        <p>--%>
<%--            <a href="${ctx}/clientServlet?method=showIndex&pageNum=${page.prePage}">上一页</a>--%>
<%--            <a href="${ctx}/clientServlet?method=showIndex&pageNum=${page.nextPage}">下一页</a>--%>
<%--        </p>--%>
<%--    </div>--%>

</body>
</html>
