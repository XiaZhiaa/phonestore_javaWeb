
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-28
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<html>
<head>
    <title>修改商品</title>
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <style type="text/css">
        .updatePhone div{
            margin: 20px auto;
            text-align: center;
            width: 600px;
        }
        .updatePhone tr{
            height: 50px;
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
            <div class="updatePhone">




                <!-- 商品 -->
                <div>
                    <h1>修改商品</h1>
                </div>
                <div>
                    <form action="${ctx}/phoneServlet?method=updatePhone" method="post" enctype="multipart/form-data">
                        <table border="1px solid black" cellspacing="0" cellpadding="0" width="600px">
                            <tr align="center">
                                <td>商品名称</td>
                                <td><input type="text" value="${phone.pName}" name="pName"></td>
                            </tr>
                            <tr align="center">
                                <td>商品描述</td>
                                <td><input type="text" value="${phone.pDescription}" name="pDescription"></td>
                            </tr>
                            <tr align="center">
                                <td>商品单价</td>
                                <td><input type="text" value="${phone.price}" name="price"></td>
                            </tr>
                            <tr align="center">
                                <td>商品库存</td>
                                <td><input type="text" value="${phone.stock}" name="stock"></td>
                            </tr>

                            <tr align="center">
                                <td>商品图片</td>
                                <td><input type="file" value="${phone.photoPath}/${phone.photoName}" name="photoName"></td>
                            </tr>
                            <tr  align="center">
                                <td>商品分类</td>
                                <td>
                                    <select name="cid" id="select" onchange="function select() {
                       var select = this.value;
                    document.getElementById('hidden').value=select;
                    // alert(select);
                    }">
                                        <option>---请选择---</option>
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.cid}">${category.cid}${category.cname}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="hidden" id="hidden" name="hidden">
                                </td>
                            </tr>
                            <tr align="center">
                                <td colspan="2">
                                    <input type="submit" value="确认修改" style="font-size: 30px">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>






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
