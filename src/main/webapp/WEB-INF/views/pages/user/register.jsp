<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/10
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>注册 <small>Register</small></h1>
            </div>

            <div>
                <div>
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="shopowner" role="tab" data-toggle="tab">商家注册</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="users" role="tab" data-toggle="tab">刷手注册</a></li>
                    </ul>
                    <br />

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
                                <div class="col-md-4"></div>
                                <div class="col-md-4">
                                    <form class="form-horizontal" id="registerForm-owner">
                                        <div class="form-group">
                                            <label for="inputEmail-owner" class="col-sm-3 control-label">邮箱</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" id="inputEmail-owner" type="email" name="email" placeholder="邮箱" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword-owner" class="col-sm-3 control-label">密码</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="password" id="inputPassword-owner" name="password" min="6" placeholder="密码" required>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="inputPhoneNumber-owner" class="col-sm-3 control-label">手机</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="inputPhoneNumber-owner" name="phoneNumber" placeholder="手机号码" min="11" required>
                                            </div>
                                            <div class="col-sm-2">
                                                <button id="btnGetVerifyCode-owner" type="submit" class="btn btn-primary">获取验证码</button>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputVerifyCode-owner" class="col-sm-3 control-label">验证码</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="password" id="inputVerifyCode-owner" name="verifyCode" min="6" placeholder="手机验证码" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputTaobaoId-owner" class="col-sm-3 control-label">淘宝账号</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="inputTaobaoId-owner" placeholder="淘宝账号" name="taobaoId" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputInviteCode-owner" class="col-sm-3 control-label">邀请码</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="inputInviteCode-owner" placeholder="邀请码" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-10">
                                                <button id="btnRegister-owner" type="submit" class="btn btn-primary">注册</button>
                                            </div>
                                        </div>
                                    </form>
                                    <script>
                                        $("#registerForm-owner").validate();
                                    </script>
                                </div>
                                <div class="col-md-4"></div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="profile">
                            <div class="row">
                                <div class="col-md-4"></div>
                                <div class="col-md-4">
                                    <form class="form-horizontal" id="registerForm-worker">
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
                                            <label for="inputPhoneNumber" class="col-sm-3 control-label">手机</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="inputPhoneNumber" placeholder="手机号码" min="11" required>
                                            </div>
                                            <div class="col-sm-2">
                                                <button id="btnGetVerifyCode" type="submit" class="btn btn-primary">获取验证码</button>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputVerifyCode" class="col-sm-3 control-label">验证码</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="password" id="inputVerifyCode" name="verifyCode" min="6" placeholder="手机验证码" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputTaobaoId" class="col-sm-3 control-label">淘宝账号</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="inputTaobaoId" placeholder="淘宝账号" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-10">
                                                <button id="btnRegister" type="submit" class="btn btn-primary">注册</button>
                                            </div>
                                        </div>
                                    </form>
                                    <script>
                                        $("#registerForm-worker").validate();
                                    </script>
                                </div>
                                <div class="col-md-4"></div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>

        </div>
    </div>
</div>