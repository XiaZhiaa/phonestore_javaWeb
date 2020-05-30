<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-27
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>手机列表</title>
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <style type="text/css">
    </style>

</head>
<body>
<script type="text/javascript">
    var data = '<%=request.getAttribute("data")==null?"":request.getAttribute("data")%>';
    // console.log(data)
    if(data==""){

    }else {
        alert(data);
        data = "";
    }
    function delOneItem(id) {
        var sure = confirm("确定要删除该商品吗？");
        if (sure){
            window.location="${ctx}/phoneServlet?method=delPhone&id="+id;
        }
    }
</script>


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

    <tr>
        <td height="600px" background="./img/regist_bg.jpg">
            <!--嵌套一个表格-->
            <div>
                <!-- 商品 -->
                <table border="1px solid black" width="1500px" cellpadding="0" cellspacing="0">
                    <thead>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>编号</th>
                        <th>名称</th>
                        <th>描述</th>
                        <th>单价</th>
                        <th>库存</th>
                        <th>分类</th>
                        <th>图片</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.records}" var="page">
                        <tr align="center"style="height: 100px">
                            <td><input type="checkbox"></td>
                            <td>${page.pid}</td>
                            <td>${page.pName}</td>
                            <td>${page.pDescription}</td>
                            <td>${page.price}</td>
                            <td>${page.stock}</td>
                            <td>${page.cname}</td>
                            <td><img src="${page.photoPath}/${page.photoName}" alt=""></td>
                            <td><a href="${ctx}/phoneServlet?method=findPhoneById&pid=${page.pid}">修改</a></td>
                            <td><a href="javascript:delOneItem(${page.pid})">删除</a></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div align="center">
                <%@include file="commons/page.jsp"%>
            </div>
            <div align="center">
                <a href="${ctx}/phoneServlet?method=toAddPhone" style="font-size: 30px">添加商品</a>
            </div>
            <br>
            <div align="center">
                <a href="${ctx}/clientServlet?method=toAdmin" style="font-size: 30px">返回</a>
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
