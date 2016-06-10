<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/6/9
  Time: 下午1:06
  To change this template use UpdFile | Settings | UpdFile Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="banner has-dots" style="overflow: hidden; width: 100%; height: 100%; background-color: #9bbcbc">
    <ul style="width: 400%; position: relative; left: 0; height: 600px;">
        <li style="background-image: url(<c:url value="/static/img/li-bgimage1.jpg"/>); width: 25%; height:619px; opacity:.75;">
            <div class="inner">
                <h1>店吾优，致力于做助力于电商发展的中坚力量</h1>
                <p>即将开始叩响的财富之门，你做好准备了吗？</p>

                <a class="btn" href="#download">开始</a>
            </div>
        </li>

        <li style="background-image: url(<c:url value="/static/img/li-bgimage2.jpg"/>); width: 25%; height:619px; opacity:.75;">
            <div class="inner">
                <h1>支持淘宝·天猫·聚划算等多平台</h1>
                <p>为更多的店铺进行服务，成为最专业的淘宝电商TP服务商，让更多平台的店主获利是我们的责任</p>

                <a class="btn" href="#download">开始</a>
            </div>
        </li>

        <li style="background-image: url(<c:url value="/static/img/li-bgimage3.jpg"/>); width: 25%; height:619px; opacity:.75;">
            <div class="inner">
                <h1>资源丰富，刷手靠谱，电商发展得力助手</h1>
                <p>多渠道业务推广，卖家刷手平台认证，筛选得力助手祝您一飞冲天</p>

                <a class="btn" href="//github.com/idiot/unslider">开始</a>
            </div>
        </li>

        <li style="background-image: url(<c:url value="/static/img/li-bgimage4.jpg"/>); width: 25%; height:619px; opacity:.75;">
            <div class="inner">
                <h1>系统多终端开发中，敬请期待</h1>
                <p>开启上班下班仍能盈利模式，暴走的财富正在向你狂奔</p>

                <a class="btn" href="#download">开始</a>
            </div>
        </li>
    </ul>
</div>

<div class="container">

    <div class="row login-fixed index-login">
        <div class="col-sm-6 col-md-12">
            <div class="thumbnail login-bg ">
                <form class="form-horizontal index-login">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">账号</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail3">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住我
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <button type="submit" class="btn btn-primary">&nbsp登录&nbsp</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="register.html">立即注册</a>
                                </div>
                                <div class="col-sm-6">
                                    <a href="retrivepassword.html">忘记密码</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="catproject content">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="project-intro">
                    <br /><br />
                    <h1 class="text-center">店吾U&nbsp<small>做最好的TP服务商</small></h1>
                    <br />
                    <p><h4>&nbsp &nbsp &nbsp  淘拍档（TaoBao Partner）意即淘宝合作伙伴，就是加入淘宝合作伙伴计划的各类外包服务提供商，专为在淘宝网开店的人提供专业的托管服务，坊间俗称TP。像宝尊、赛诺贝斯，商派就是这一类服务商。</h4></p>

                    <br />
                    <div class="operation">
                        <button type="button" class="btn btn-primary btn-md" >
                            了解更多
                        </button>

                        <button type="button" class="btn btn-primary btn-md">
                            <span class="glyphicon glyphicon-share"></span> 分享
                        </button>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <img src="<c:url value="/static/img/main-intro.png"/> " alt="The project of the day" class="img-responsive"/>
            </div>
        </div>
    </div>
</div>

<div class="catproject bg-lightgray content">
    <div class="container">
        <div class="row">
            <div class="container">
                <div class="header">
                    <h1 class="text-white text-center"><strong>系统特色</strong></h1>
                </div>
                <div class="row">

                    <div class="col-sm-6 col-md-4">
                        <a href="services.html" title="免费"><img src="<c:url value="/static/img/digital/free.png"/> " class="specialty img-circle img-center"></a>
                        <div class="caption">
                            <h3 class="text-center"><a href="services.html" title="
                        当天提现，当天到账；
                      无需交纳任何入会手续费；
                             垫付立返；
                  个性化操作赚钱 满足各种刷客需求。
                  " data-toggle="tooltip" data-placement="bottom"><strong>免费</strong></a></h3>
                            <p class="text-white h4 text-center">平台承若 永久免费</p>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <a href="services.html" title="精准"><img src="<c:url value="/static/img/digital/precise.png"/> " class="specialty img-circle img-center"></a>
                        <div class="caption">
                            <h3 class="text-center"><a href="services.html" title="选择我的客户画像；细分年龄、性别、地区、时段；  告别黑号；我就是意向顾客。" data-toggle="tooltip" data-placement="bottom"><strong>精准</strong></a></h3>
                            <p class="text-white h4 text-center">个性化选择 锁定精准顾客</p>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <a href="services.html" title="可靠"><img src="<c:url value="/static/img/digital/reliable.png"/> " class="specialty img-circle img-center"></a>
                        <div class="caption">
                            <h3 class="text-center"><a href="services.html" title="多种方式，真实购物流程；&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp全方位补单 告别刷单，我就是真实订单。" data-toggle="tooltip" data-placement="bottom"><strong>可靠</strong></a></h3>
                            <p class="text-white h4 text-center">多方式 多渠道 停留时长</p>
                        </div>
                    </div>
                </div>

                <br />

                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <a href="services.html" title="安全"><img src="<c:url value="/static/img/digital/1.png"/> " class="specialty img-circle img-center"></a>
                        <div class="caption">
                            <h3 class="text-center"><a href="services.html" title="多种重要信息认证；账号真实唯一；同ID每日限量；全额赔付，平台保障，安全无忧。" data-toggle="tooltip" data-placement="bottom"><strong>安全</strong></a></h3>
                            <p class="text-white h4 text-center">实名认证 全额赔付</p>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <a href="services.html" title="简单"><img src="<c:url value="/static/img/digital/easy.png"/> " class="specialty img-circle img-center"></a>
                        <div class="caption">
                            <h3 class="text-center"><a href="services.html" title="界面简单，流程简易；操作方便，24*7小时技术维护，诚信安全，方便快捷。" data-toggle="tooltip" data-placement="bottom"><strong>简单</strong></a></h3>
                            <p class="text-white h4 text-center">操作简单 方便快捷</p>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <a href="services.html" title="稳定"><img src="<c:url value="/static/img/digital/stable.png"/> " class="specialty img-circle img-center"></a>
                        <div class="caption">
                            <h3 class="text-center"><a href="services.html" title="整体系统架构设计完善,后台服务器超凡稳定，为您提供稳定的财富增长速度！" data-toggle="tooltip" data-placement="bottom"><strong>稳定</strong></a></h3>
                            <p class="text-white h4 text-center">强悍后台 稳定支持</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script type="text/javascript">--%>
    <%--$(function () {--%>
        <%--$('[data-toggle="tooltip"]').tooltip()--%>
    <%--});--%>
<%--</script>--%>

<div class="catproject content">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="project-intro text-vertical-align">
                    <h1 class="text-vertical-align">不止于更多<br /><small>PC客户端、手机客户端和微信公众号即将推出</small></h1>
                    <br />
                    <br />

                </div>
            </div>

            <div class="col-lg-6 text-vertical-align">
                <div class="row">
                    <div class="col-lg-3">
                        <img src="<c:url value="/static/img/weixin.png"/> " class="smalllogo"/>
                    </div>
                    <div class="col-lg-3">
                        <img src="<c:url value="/static/img/android.png"/> " class="smalllogo"/>
                    </div>
                    <div class="col-lg-3">
                        <img src="<c:url value="/static/img/windows.png"/> " class="smalllogo"/>
                    </div>
                    <div class="col-lg-3">
                        <img src="<c:url value="/static/img/apple.png"/> " class="smalllogo"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="recruit bg-lightblue content">
    <div class="container">
        <h1 style="color:#efefef;" class="text-center">加入店吾U，轻松敲开财富的大门</h1>
        <h3 style="color:#efefef;" class="text-center">Join us and make every minute worthwhile!</h3>
        <button type="button" class="btn btn-success btn-lg" style="margin-left:500px;margin-top:20px;">
            加入我们
        </button>
    </div>
</div>