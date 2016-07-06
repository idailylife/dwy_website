<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/7/4
  Time: 下午9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>商家资质认证 <small>Shop Owner Authentication</small></h1>
            </div>

            <div>
                <div>
                    <br />

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div class="row">
                                <div class="col-md-4"></div>
                                <div class="col-md-4">
                                    <form class="form-horizontal registerForm" id="formShopValidation">
                                        <div class="form-group">
                                            <label for="tbwangwangid" class="col-sm-3 control-label">淘宝掌柜名</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" name="taobaoId" id="tbwangwangid" placeholder="淘宝旺旺ID" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="qqnum" class="col-sm-3 control-label">绑定QQ号</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" id="qqnum" name="qq" required>
                                            </div>
                                        </div>

                                        <h4>验证旺旺ID：</h4>
                                        <p>请使用手机版千牛或者电脑版千牛软件，打开随意一个聊天窗口输入“用店无忧，店铺无忧”，并截图上传！</p>

                                        <br />
                                        <h4>注意事项：</h4>
                                        <p>电脑版千牛软件，请一定要显示出旺旺名称和截图时间，手机版请选择有聊天记录的窗口，并需要显示旺旺名称和时间！</p>
                                        <br />


                                        <div class="form-group">
                                            <label for="uploadchatshot" class="col-sm-4 control-label">上传聊天截图</label>
                                            <div class="col-sm-8">
                                                <input id="uploadchatshot" name="screenshotImg" type="file" class="btn btn-primary">
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-10">
                                                <button id="btnShopverify" type="button" class="btn btn-primary">立即验证店铺</button>
                                            </div>
                                        </div>
                                    </form>

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