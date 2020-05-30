<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-26
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>分类列表</title>
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <style type="text/css">
        /*body{*/
        /*    text-align: center;*/
        /*}*/
        .category{
            text-align: center;
            margin: 20px auto;

        }
        .category table{
            margin: 0 auto;
        }
        .category tr{
            height: 30px;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    var categoryData = '<%=request.getAttribute("categoryData")==null?"":request.getAttribute("categoryData")%>';
    // console.log(data)
    if(categoryData==""){

    }else {
        alert(categoryData);
        categoryData = "";
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
    <!--3.注册表单-->
    <tr>
        <td height="600px" background="./img/regist_bg.jpg">
            <!--嵌套一个表格-->
            <div class="category">



                <div>
                    <h1>分类列表</h1>
                </div>
                <div >
                    <table width="600px" cellspacing="0" cellpadding="0" border="1px solid black">
                        <tr>
                            <th><input type="checkbox"></th>
                            <th>编号</th>
                            <th>分类名称</th>
                            <th colspan="2">操作</th>
                        </tr>
                        <c:forEach items="${list}" var="c">
                            <tr align="center">
                                <td><input type="checkbox"></td>
                                <td>${c.cid}</td>
                                <td>${c.cname}</td>
<%--                                <td><a href="${ctx}/categoryServlet?method=findById&id=${c.cid}">修改</a></td>--%>
                                <td>
                                    <a href="JavaScript:updateCategory('${c.cname}','${c.cid}')">修改</a>
                                </td>
                                <td>
                                    <a href="JavaScript:delCategory('${c.cid}')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    <div >
                        <form action="${ctx}/categoryServlet?method=addCategory" method="post">
                            <input type="text" name="cname" id="cname" style="display: none">
                            <input type="submit" id="#addCategory" value="添加分类" style="font-size: 30px">
                        </form>
                    </div>

                    <a href="${ctx}/clientServlet?method=toAdmin" style="font-size: 30px">返回</a>
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


<script type="text/javascript">

    function updateCategory(name,id) {
        var categoryName = prompt("修改分类",name);
        // console.log(categoryName);
        window.location.href="${ctx}/categoryServlet?method=updateCategory&cid="+id+"&cname="+categoryName;
    }

    function delCategory(id){
        var sure = window.confirm("您确定要删除该分类吗？");
        if (sure){
            window.location.href="${ctx}/categoryServlet?method=delCategory&id="+id;
        }
    }

    document.getElementById("#addCategory").onclick=function () {
        var cname = prompt("请输入分类名称：");
        document.getElementById("cname").value=cname;

    }

</script>
</body>
</html>


