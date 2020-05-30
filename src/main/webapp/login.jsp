<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-30
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <style type="text/css">
        body{
            margin-top: 100px;
        }
    </style>
    <script type="text/javascript">


        function checkUser(){
            var username = $("#username").val();
            var password = $("#password").val()
            if ( username == "" || password == "") {
                alert("用户名或密码不能为空！");
                return false;
            }
        }

    </script>
</head>
<body>
<script type="text/javascript">
    var loginData = '<%=request.getAttribute("loginData")==null?"":request.getAttribute("loginData")%>';
    // console.log(data)
    if(loginData==""){

    }else {
        alert(loginData);
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
            <!--嵌套一个十行二列的表格-->
            <form action="${pageContext.request.contextPath}/userServlet?method=userLogin" method="post" name="loginForm" onsubmit="return checkUser()" >
                <table border="1px" width="750px" height="400px" align="center" cellpadding="0px" cellspacing="0px" bgcolor="white">
                    <tr height="40px">
                        <td colspan="2">
                            <font size="8">会员登陆</font> &nbsp;&nbsp;&nbsp;USER REGISTER
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            用户名
                        </td>
                        <td>
                            <input style="height: 50px" type="text" name="username" size="34px" id="username" placeholder="请输入用户名" required="required"/>
                            <span id="usernamespan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            密码
                        </td>
                        <td>
                            <input style="height: 50px" type="password" name="password" size="34px" placeholder="请输入密码" id="password" required="required"/>
                            <span id="passwordspan"></span>
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value="登陆" style="font-size: 30px"/>
                        </td>
                    </tr>
                </table>
            </form>
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
