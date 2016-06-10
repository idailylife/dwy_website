<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/9
  Time: 下午12:29
  To change this template use UpdFile | Settings | UpdFile Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tiles:importAttribute name="javascripts" ignore="true"/>
<tiles:importAttribute name="stylesheets" ignore="true"/>

<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <META NAME="Title" CONTENT="I5U | 你的淘宝店铺盈利助手.">
    <META NAME="Author" CONTENT="Senser">
    <META NAME="Subject" CONTENT="Taobao TS tool">
    <META NAME="Keywords" CONTENT="taobao,ts">
    <META NAME="Designer" CONTENT="Keefe Wong">

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- Auto-appended stylesheets -->
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <!-- Scripts -->
    <script src="http://cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <!-- Header -->
    <header>
        <tiles:insertAttribute name="header"/>
    </header>

    <!-- Content -->
    <section>
        <tiles:insertAttribute name="body"/>
    </section>
    <!-- Footer -->
    <footer>
        <tiles:insertAttribute name="footer"/>
    </footer>

    <!-- Scripts Appended -->
    <c:forEach var="script" items="${javascripts}">
        <script src="<c:url value="${script}"/> "></script>
    </c:forEach>
</body>
</html>
