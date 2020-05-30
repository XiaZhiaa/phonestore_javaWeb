<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-30
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <style type="text/css">
        body{
            margin-top: 100px;
        }
    </style>
    <script>
        function checkForm(){
            var username = document.getElementById("username").value;
            if(username==""){
                // alert("用户名不能为空！");
                document.getElementById("usernamespan").innerHTML="<font color='red'>"+"用户名不能为空"+"</font>";
                return false;
            }else if(username.length>0&&username.length<2){
                // alert("用户名不能小于4位！");
                document.getElementById("usernamespan").innerHTML="<font color='red'>"+"用户名不能小于2位"+"</font>";
                return false;
            }else if(username.length>20){
                // alert("用户名不能大于20位！");
                document.getElementById("usernamespan").innerHTML="<font color='red'>"+"用户名不能大于20位"+"</font>";
                return false;
            }

            var password = document.getElementById("password").value;
            if(password==""){
                // alert("密码不能为空！");
                document.getElementById("passwordspan").innerHTML="<font color='red'>"+"密码不能为空"+"</font>";
                return false;
            }else if(password.length>0&&password.length<6){
                // alert("密码不能小于6位！");
                document.getElementById("passwordspan").innerHTML="<font color='red'>"+"密码不能小于6位"+"</font>";
                return false;
            }else if(password.length>20){
                // alert("密码不能大于20位");
                document.getElementById("passwordspan").innerHTML="<font color='red'>"+"密码不能大于20位"+"</font>";
                return false;
            }

            var repassword = document.getElementById("repassword").value;
            if(repassword!=password){
                // alert("两次密码输入不一致！");
                document.getElementById("repasswordspan").innerHTML="<font color='red'>"+"两次密码输入不一致"+"</font>";
                return false;

            }

            var email = document.getElementById("email").value;
            if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(email)){
                // alert("邮箱格式不正确");
                document.getElementById("emailspan").innerHTML="<font color='red'>"+"邮箱格式不正确"+"</font>";
                return false;
            }

            // var phone = document.getElementById("telephone").value;
            // var telStr = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
            // if (!telStr.test(phone)) {
            //     document.getElementById("phonespan").innerHTML="<font color='red'>"+"手机号格式不正确"+"</font>";
            //     return false
            // }else{
                // msg = "手机号码规范";
            // }

        }
        function showTips(id,msg){
            document.getElementById(id+"span").innerHTML="<font color='gray'>"+msg+"</font>";
        }
        function check(id,msg){
            value1 = document.getElementById(id).value;
            if(value1==""){
                document.getElementById(id+"span").innerHTML="<font color='red'>"+msg+"</font>";
            }else{
                document.getElementById(id+"span").innerHTML="<font color='#008000'>✔</font>";
            }
        }
    </script>
</head>
<body>
<script type="text/javascript">
    var regdata = '<%=request.getAttribute("regdata")==null?"":request.getAttribute("regdata")%>';
    // console.log(data)
    if(regdata==""){

    }else {
        alert(regdata);
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
            <form action="${ctx}/userServlet?method=userRegister" method="post" name="regForm" onsubmit="return checkForm()" >
                <table border="1px" width="750px" height="400px" align="center" cellpadding="0px" cellspacing="0px" bgcolor="white">
                    <tr height="40px">
                        <td colspan="2">
                            <font size="8">会员注册</font> &nbsp;&nbsp;&nbsp;USER REGISTER
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            用户名
                        </td>
                        <td>
                            <input type="text" name="username" size="34px" id="username" placeholder="请输入用户名" onfocus="showTips('username','用户名必填!')" onblur="check('username','用户名不能为空!')"/>
                            <span id="usernamespan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            密码
                        </td>
                        <td>
                            <input type="password" name="password" size="34px" placeholder="请输入密码" id="password" onfocus="showTips('password','密码必填!')" onblur="check('password','密码不能为空!')"/>
                            <span id="passwordspan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            确认密码
                        </td>
                        <td>
                            <input type="password" name="repassword" size="34px" id="repassword" placeholder="确认密码" onfocus="showTips('repassword','重复密码')" onblur="check('repassword','再次输入您的密码')"/>
                            <span id="repasswordspan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            Email
                        </td>
                        <td>
                            <input type="text" name="email" size="34px" placeholder="请输入邮箱" id="email"/>
                            <span id="emailspan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            手机号
                        </td>
                        <td>
                            <input type="text" name="telephone" size="34px" placeholder="请输入手机号" />
                            <span id="telephonespan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            地址
                        </td>
                        <td>
                            <input type="text" name="address" size="34px" placeholder="请输入地址" />
                            <span id="addressspan"></span>
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value="注册" style="font-size: 30px"/>
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