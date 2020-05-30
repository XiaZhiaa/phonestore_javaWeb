<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-28
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>手机商城后台管理</title>
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <style>
        .adminMenu div{
            margin: 0 auto;
            width: 300px;
        }
        .adminMenu h1{
            position: relative;
            top: -100px;
            left: 450px;
            font-size: 50px;
        }
        .adminMenu ul{
            position: relative;
            left: 450px;
        }
        .adminMenu li{
            float: none;
        }

        .adminMenu a{
            font-size: 40px;
        }
    </style>
</head>
<body>

    <table border="1px" align="center" width="1300px" cellpadding="0px" cellspacing="0px">
        <!--1.logo部分-->
        <tr>
            <td>
                <!--嵌套一个一行三列的表格-->
                <table border="1px" width="100%">
                    <tr height="50px">
                        <td width="33.3%" colspan="2">
                            <h1 style="color: #FF0000;">三组实训项目之爱尚手机商城</h1>
                        </td>
                        <td width="33.3%">
                            <%@include file="commons/head.jsp"%>

                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <!--2.导航栏部分-->
        <tr height="50px">
            <td bgcolor="black" class="nav">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/clientServlet?method=showIndex&pageNum=1">
                    <font size="6" color="white">首页</font>
                </a> &nbsp;&nbsp;&nbsp;&nbsp;
                <c:forEach items="${categoryList}" var="c">
                    <a href="${ctx}/clientServlet?method=showCategoryPhones&cid=${c.cid}" style="margin-left: 100px">
                        <font color="white" size="5">${c.cname}</font>
                    </a>
                </c:forEach>
            </td>
        </tr>
        <!--3.注册表单-->
        <tr>
            <td height="600px" background="./img/regist_bg.jpg">
                <!--嵌套一个表格-->
                <div class="adminMenu">
                    <h1>手机商城后台管理</h1>
                </div>
                <div class="adminMenu">
                    <ul>
                        <li><a href="${ctx}/phoneServlet?method=findAllPhones&pageNum=1">商品管理</a></li>
                        <li><a href="${ctx}/categoryServlet?method=findAll">分类管理</a></li>
                        <li><a href="${ctx}/clientServlet?method=showIndex&pageNum=1">返回首页</a></li>
                    </ul>

                </div>
            </td>
        </tr>
        <!--4.广告图片-->
        <tr>
            <td>
                <img src="./img/footer.jpg"  width="100%"/>
            </td>
        </tr>
    </table>
    <%@ include file="commons/foot.jsp"%>
    </body>
</html>

</body>
</html>
