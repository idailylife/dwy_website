<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/9
  Time: 下午12:38
  To change this template use UpdFile | Settings | UpdFile Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/> "><img src="<c:url value="/static/img/logo.png"/> " alt="Logo" /></a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="" target="_blank">任务大厅</a></li>
                <li><a href="" target="_blank">个人中心</a></li>
                <li><a href="" target="_blank">联系我们</a></li>
                <li><a href="" target="_blank">投诉建议</a></li>
                <li>
                    <form class="navbar-form form-horizontal" role="form">
                        <div class="col-lg-12">
                            <div class="input-group">
                                <input name="search" type="text" class="form-control" placeholder="输入关键词">
                    <span class="input-group-btn">
                      <button class="btn btn-primary" type="button">搜索</button>
                    </span>
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${loginState}">
                        <li><a href="<c:url value="#"/> ">${displayName}</a></li>
                        <li><a href="<c:url value="/user/logout"/> ">注销</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="<c:url value="/user/login"/> ">登陆</a></li>
                        <li><a href="<c:url value="/user/register"/> ">注册</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</div>
<script>
    var homeUrl = "<c:url value="/"/>";
</script>