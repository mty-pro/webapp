<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<h1 align="center">欢迎登录！</h1>
<form action="login/myweb/jid" method="get">
    <table align="center">
        <tr>
            <td>请输入用户名：</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>请输入口令：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>