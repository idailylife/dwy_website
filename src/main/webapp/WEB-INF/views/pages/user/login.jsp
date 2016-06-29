<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/10
  Time: 上午10:12
  To change this template use UpdFile | Settings | UpdFile Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>登录 <small>Log in</small></h1>
            </div>

            <div id="login">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <form>
                            <label for="inputEmail" class="sr-only">账号</label>
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                            <br />
                            <label for="inputPassword" class="sr-only">密码</label>
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                            <br />
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" id="checkRemember" value="remember-me"> 记住我
                                </label>
                            </div>
                            <div class="row">
                                <div class="col-md-3"></div>
                                <div class="col-md-3">
                                    <button class="btn btn-primary" id="btnSubmitLogin" type="submit">登录</button>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-default"><a href="<c:url value="/user/register"/> ">现在注册</a></button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>

            <br />

        </div>
    </div>
</div>
