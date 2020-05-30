<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-05-30
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>激活成功</title>
</head>
<script type="text/javascript">
    var activeData = '<%=request.getAttribute("activeData")==null?"":request.getAttribute("activeData")%>';
    // console.log(data)

    alert(activeData);

    if (activeData=="激活成功，即将跳转到登录页面"){
        setInterval(function () {
            window.location.href="${pageContext.request.contextPath}/userServlet?method=toLogin";
        },5000);
    }
</script>
<body>
    <div>

    </div>
</body>
</html>
