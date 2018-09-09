<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/login.css">
    <title>初识在校园</title>

    <%--${pageContext.request.contextPath};--%>
    <style type="text/css">
        html,body{height: 100%}
    body{
        background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535626938249&di=9b53f52bcc468586ca2d55edb8e05788&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F56eba3550c5bc.jpg");
        background-repeat: no-repeat;

        background-size: cover;
        background-attachment: fixed;
        background-color: #CCCCCC;
        background-color: rgba(0,0,255,0.5);

    }
        .login-panel{
            width: 400px;
            height: 300px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -150px;
            margin-left: -200px;

        }

    </style>
</head>
<body>

<<<<<<< HEAD
    <!--<%=basePath%>-->
     <%--https://localhost:8081/chance/--%>
=======
    <div class="outer-wrap">
        <div class="login-panel">
            <h2 align="center"><font size="5" color="#fff8dc">欢迎登录</font></h2>

    <%--<%=basePath%>--%>
     <%--https://localhost:443/chance/--%>



>>>>>>> 81593878418a8d5d0a445a0def8b6899163adef0
    <form name="loginForm" action="login/verify" method="post">
        <table align="center">
            <tr>
                <td ><font size="3" color="#fff8dc">用户名:</font></td><td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td><font size="3" color="#fff8dc">密码:</font></td><td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td colspan="2", align="center" >
                    <input type="submit" value="确认" />
                    <input type="reset" value="重置" style="margin-left: 30px" />
                </td>
            </tr>
        </table>
    </form>
        </div>
    </div>
</body>

</html>