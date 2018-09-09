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

    <%--<base href="<%=basePath%>">--%>
    <link rel="stylesheet" href="css/login.css">
    <title>初识在校园</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <style type="text/css">

        
        ul{
            list-style: none;
            position: fixed;
            width: 100%;

        }
        .nav>li{
            float: left;
        }
        ul a{
            display: block;
            text-decoration: none;
            width: 100px;
            height: 50px;
            text-align: center;
            line-height: 50px;
            color: white;
            background-color: #2f3e45;
        }
        .nav>li:first-child a{
            border-radius: 0px;
        }
        .nav>li:last-child a{
            border-radius: 0px;
        }
        .drop-down{
            /*position: relative;*/
        }
        .drop-down-content{
            padding: 0;
            display: none;
            /*position: absolute;*/
        }


        .drop-down-content li:hover a{
            background-color:red;
        }
        .nav .drop-down:hover .drop-down-content{
            display: block;
        }
    </style>
</head>
<body>
<h2 align="center">欢迎登录</h2>
<div id="a" >
    <div >
        <img src="http://pic.58pic.com/58pic/13/19/70/59H58PIC743_1024.jpg" style="width: 100%;height: 200px">
    </div>

<ul class="nav" >

    <li class="drop-down" ><a href="#">初识爱情信息</a>
        <ul class="drop-down-content">
            <li><a href="认证信息审核">认证信息审核</a></li>
            <li><a href="举报信息查看">举报信息查看</a></li>
        </ul>
    </li >
    <li class="drop-down" style="padding-left: 100px"><a href="#">丘比特之箭</a>
        <ul class="drop-down-content">
            <li><a href="qbt">丘比特</a></li>
            <li><a href="">箭</a></li>
        </ul>
    </li>

<<<<<<< HEAD
<!--<%=basePath%>-->
<%--https://localhost:8081/chance/--%>
=======
</ul>
</div>
>>>>>>> 81593878418a8d5d0a445a0def8b6899163adef0

</body>

</html>