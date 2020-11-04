<%--
  Created by IntelliJ IDEA.
  User: 马天宇
  Date: 2020/11/4
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h1 align="center">欢迎登录！</h1>
    <table align="center">
        <tr>
            <td>您的用户名是：</td>
            <td>
                <%=request.getParameter("name")%>
            </td>
        </tr>
        <tr>
            <td>您的口令是：</td>
            <td>
                <%=request.getParameter("password")%>
            </td>
        </tr>
    </table>
</body>
</html>
