<%@ page import="java.util.Random" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/10
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="rand"><%= new Random().nextInt(100) %></c:set>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>注册 <small>Register</small></h1>
            </div>

            <div>
                <div>
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#dummyTab" aria-controls="shopowner" role="tab" data-toggle="tab" data-type="0">商家注册</a>
                        </li>
                        <li role="presentation">
                            <a href="#dummyTab" aria-controls="users" role="tab" data-toggle="tab" data-type="1">刷手注册</a>
                        </li>
                    </ul>
                    <br />

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="dummyTab">
                            <!-- dummy tab item-->
                        </div>
                    </div>
                </div>
                <!-- Common tab content -->
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <form class="form-horizontal" id="registerForm">
                            <div class="form-group">
                                <label for="inputEmail" class="col-sm-3 control-label">邮箱</label>
                                <div class="col-sm-9">
                                    <input class="form-control" id="inputEmail" type="email" name="email" placeholder="邮箱" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-sm-3 control-label">密码</label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="password" id="inputPassword" name="password" min="6" placeholder="密码" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputImageCaptcha" class="col-sm-3 control-label">验证码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="inputImageCaptcha" placeholder="图片验证码" required>
                                </div>
                                <div class="col-sm-1">
                                    <span id="spanImageVerifyState"></span>
                                </div>
                                <div class="col-sm-4">
                                    <img src="<c:url value="/verify/img?rand=${rand}"/> " style="height: 2.75rem;">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPhoneNumber" class="col-sm-3 control-label">手机</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="inputPhoneNumber" name="phoneNumber" placeholder="手机号码" min="11" required>
                                </div>
                                <div class="col-sm-2">
                                    <button id="btnGetVerifyCode" type="submit" class="btn btn-primary" disabled="disabled">短信验证</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputVerifyCode" class="col-sm-3 control-label">短信验证</label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="password" id="inputVerifyCode" name="verifyCode" min="6" placeholder="短信验证码" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputInviteCode" class="col-sm-3 control-label">邀请码</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="inputInviteCode" placeholder="邀请码" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-10">
                                    <button id="btnRegister" type="submit" class="btn btn-primary">注册</button>
                                </div>
                            </div>
                        </form>
                        <%--<script>--%>
                            <%--$("#registerForm").validate();--%>
                        <%--</script>--%>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>

        </div>
    </div>
</div>