<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/27
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    onload = function () {
        var container2 = document.getElementById("vCode2");
        var code = new vCode(container2, {
            len: 5,
            bgColor: "#444444",
            colors: [
                "#DDDDDD",
                "#DDFF77",
                "#77DDFF",
                "#99BBFF",
                //"#7700BB",
                "#EEEE00"
            ]
        });
        document.getElementById("btn2").addEventListener("click", function () {
            alert(code.verify(document.getElementById("code").value));
        }, false);
    };
</script>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>用户认证 <small>User Authentication</small></h1>
        </div>

        <div>
            <br />
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <form class="form-horizontal registerForm">
                                <div class="form-group">
                                    <label for="name" class="col-sm-3 control-label">姓名</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="name" id="name" placeholder="姓名" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="idnum" class="col-sm-3 control-label">身份证号</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" id="idnum" name="idnum" min="16" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="gender" class="col-sm-3 control-label">性别</label>
                                    <div class="col-sm-3">
                                        <select class="form-control" id="gender" name="gender">
                                            <option>男</option>
                                            <option>女</option>
                                        </select>
                                    </div>
                                    <label for="age" class="col-sm-3 control-label">年龄</label>
                                    <div class="col-sm-3">
                                        <input class="form-control" type="text" id="age" name="age" placeholder="年龄" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="wangwangid" class="col-sm-3 control-label">收款</label>
                                    <div class="col-sm-3">
                                        <input class="form-control" type="text" id="wangwangid" name="wangwangid" required>
                                    </div>
                                    <label for="idlevel" class="col-sm-3 control-label">账号等级</label>
                                    <div class="col-sm-3">
                                        <input class="form-control" type="text" id="idlevel" name="idlevel" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="alipayid" class="col-sm-3 control-label">收款支付宝</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" id="alipayid" name="alipayid" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label for="address" class="col-sm-3 control-label">收货地址</label>
                                        <div class="col-sm-3">
                                            <select class="form-control" name="province"></select>
                                        </div>
                                        <div class="col-sm-3">
                                            <select class="form-control" name="city"></select>
                                        </div>
                                        <div class="col-sm-3">
                                            <select class="form-control" name="area"></select>
                                        </div>
                                    </div>
                                    <script language="javascript" defer>
                                        new PCAS("province","city","area");
                                    </script>
                                    <br />
                                    <div class="row">
                                        <div class="col-sm-3"><br /></div>

                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="address" name="address" placeholder="详细地址" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="idpicture" class="col-sm-5 control-label">身份证正面照片上传</label>
                                    <div class="col-sm-1">
                                        <button id="idpicture" name="idpicture" type="submit" class="btn btn-primary">上传</button>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="userandidpicture" class="col-sm-5 control-label">手持身份证照片上传</label>
                                    <div class="col-sm-1">
                                        <button id="userandidpicture" name="userandidpicture" type="submit" class="btn btn-primary">上传</button>
                                    </div>
                                </div>

                                <hr />

                                <div class="form-group">
                                    <div class="col-sm-offset-5 col-sm-10">
                                        <button id="register" type="submit" class="center btn btn-primary">实名认证</button>
                                    </div>
                                </div>
                            </form>
                            <script>
                                $("#registerForm").validate();
                            </script>
                        </div>
                        <div class="col-md-1">
                        </div>
                        <div class="col-md-3">
                            <div class="well">
                                <img class="smalllogo img-center" src="img/digital/1.png"  alt="safety"/>
                                <hr />
                                <h4>实名资料·严格加密保障安全</h4>
                                <p>经过我们的平台审核后，将资料下载保存在一台离线的服务器上，并删除平台上的资料，绝对保证会员资料的安全。</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>