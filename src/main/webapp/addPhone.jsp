<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-27
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>商品添加界面</title>
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <style type="text/css">
        .add{
            margin: 0 auto;
            width: 600px;
            text-align: center;
        }
        .add tr{
            height: 40px;
        }
    </style>
    <script src="js/jquery-3.5.1.min.js"></script>
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
    <!--3.添加表单-->
    <tr>
        <td height="600px" background="./img/regist_bg.jpg">
            <!--嵌套一个表格-->
            <div class="add">


                <h1>商品添加</h1>
                <form action="${ctx}/phoneServlet?method=addPhone" method="post" enctype="multipart/form-data" onsubmit="return checkAdd()"/>
                    <table border="1px solid black" cellspacing="0" cellpadding="0" width="600px">
                        <tr align="center">
                            <td>商品名称</td>
                            <td><input type="text" name="pName" required="required"></td>
                        </tr>
                        <tr align="center">
                            <td>商品描述</td>
                            <td><input type="text" name="pDescription"></td>
                        </tr>
                        <tr align="center">
                            <td>商品单价</td>
                            <td><input type="text" name="price" required="required"></td>
                        </tr>
                        <tr align="center">
                            <td>商品库存</td>
                            <td><input type="text" name="stock"></td>
                        </tr>

                        <tr align="center">
                            <td>商品图片</td>
                            <td><input type="file" name="photoName"></td>
                        </tr>
                        <tr  align="center">
                            <td>商品分类</td>
                            <td>
                                <select name="cid" id="select">
                                    <option>---请选择---</option>
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.cid}">${category.cname}</option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" id="hidden" name="hidden">
                            </td>
                        </tr>
                        <tr align="center">
                            <td colspan="2">
                                <input type="submit" value="添加" style="font-size: 30px">
                            </td>
                        </tr>
                        <tr align="center">
                            <td colspan="2">
                                <a href="javascript:goBack()" style="font-size: 30px">返回</a>
                            </td>
                        </tr>
                    </table>
                </form>

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


    <script type="text/javascript">
        function goBack() {
            window.location.href="${ctx}/phoneServlet?method=findAllPhones&pageNum=1";
        }
        $('#select').change(function () {
             var cid = $("#select option:selected").val();
            $("#hidden").val(cid);
        });
        function checkAdd() {

        }
    </script>
</body>
</html>
