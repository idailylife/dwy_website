<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hebowei
  Date: 16/7/11
  Time: 下午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>发布任务
                    <small>Task Publishment</small>
                </h1>
            </div>

            <div id="publishtask">
                <form class="form-horizontal" id="taskpublishmentform">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img id="productpicture" src="<c:url value="/static/img/biglogo.png"/> " alt="..."
                                     class="productimg"/>
                                <div class="caption">
                                    <p>
                                        <button class="btn btn-primary img-center" role="button" id="">上传图片
                                        </button>
                                    </p>
                                    <input type="file" name="image">
                                </div>
                            </div>
                        </div>

                        <div class="col-md-8">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择入口<span
                                        class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-10">
                                    <label class="radio-inline">
                                        <input type="radio" id="naturalsearch" value="0" name="type"
                                               onclick="to_change()" checked="checked"> 自然搜索
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="taocommand" value="1" name="type"
                                               onclick="to_change()"> 淘口令
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="directtrain" value="2" name="type"
                                               onclick="to_change()"> 直通车
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="shoppingcart" value="3" name="type"
                                               onclick="to_change()"> 购物车
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="footprint" value="4" name="type"
                                               onclick="to_change()"> 足迹
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="activity" value="5" name="type"
                                               onclick="to_change()"> 活动
                                    </label>
                                </div>
                            </div>
                            <hr/>
                            <div id="naturalsearchdiv">
                                <div class="form-group">
                                    <label for="keywords" class="col-sm-2 control-label">关键词<span class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="keyword" placeholder="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">排序方式<span
                                            class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" value="0" name="sort" checked> 综合
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" value="1" name="sort"> 人气
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" value="2" name="sort"> 销量
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" value="3" name="sort"> 信用
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" value="4" name="sort"> 价格
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" value="5" name="sort"> 天猫
                                        </label>
                                    </div>
                                </div>

                                <div id="entrancediv" class="form-group">
                                    <label class="col-sm-2 control-label">入口<span
                                            class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" value="5" name="entranceType" checked> 电脑端
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" value="4" name="entranceType"> 手机端
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div id="taocommanddiv" style="display:none;">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">输入淘口令<span
                                            class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="form-group col-sm-10">
                                        <textarea id="taocommandcontent" class="form-control" rows="3" name="taokouling"></textarea>
                                    </div>
                                </div>
                            </div>

                            <div id="activitydiv" style="display:none;">
                                <div class="form-group">
                                    <label for="activityname" class="col-sm-2 control-label">活动名称<span
                                            class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="activityname" name="actName" placeholder="">
                                    </div>

                                    <label for="activitykind" class="col-sm-2 control-label">活动类别<span
                                            class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="activitykind" name="actType" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <label for="keywords" class="col-sm-2 control-label">关键词<span class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="keywords" name="keyword" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">排序方式<span
                                            class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" id="together" value="0" name="rankBy" checked> 综合
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" id="popularity" value="1" name="rankBy"> 人气
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" id="sales" value="2" name="rankBy"> 销量
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" id="credit" value="3" name="rankBy"> 信用
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" id="price" value="4" name="rankBy"> 价格
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" id="tmall" value="5" name="rankBy"> 天猫
                                        </label>
                                    </div>
                                </div>

                                <div id="sortingway" class="form-group">
                                    <label class="col-sm-2 control-label">入口<span class="warningtext">&nbsp * &nbsp </span></label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input type="radio" id="pc" value="5" name="entranceType" checked> 电脑端
                                        </label>

                                        <label class="radio-inline">
                                            <input type="radio" id="phone" value="4" name="entranceType"> 手机端
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <hr/>
                            <div class="form-group">
                                <label for="gender" class="col-sm-2 control-label">买家性别<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <select class="form-control" id="gender" name="buyerGender" required>
                                        <option value="male" >男</option>
                                        <option value="female" >女</option>
                                    </select>
                                </div>

                                <label class="col-sm-2 control-label">年龄</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="minage" name="buyerAgeLow" placeholder="最低">
                                </div>

                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="maxage" name="buyerAgeHigh" placeholder="最高">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">交易范围<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <select class="form-control" name="buyerLocation">
                                        <option value="">--请选择省份--</option>
                                        <option value="北京市">北京市</option>
                                        <option value="天津市">天津市</option>
                                        <option value="河北省">河北省</option>
                                        <option value="山西省">山西省</option>
                                        <option value="内蒙古自治区">内蒙古自治区</option>
                                        <option value="辽宁省">辽宁省</option>
                                        <option value="吉林省">吉林省</option>
                                        <option value="黑龙江省">黑龙江省</option>
                                        <option value="上海市">上海市</option>
                                        <option value="江苏省">江苏省</option>
                                        <option value="浙江省">浙江省</option>
                                        <option value="安徽省">安徽省</option>
                                        <option value="福建省">福建省</option>
                                        <option value="江西省">江西省</option>
                                        <option value="山东省">山东省</option>
                                        <option value="河南省">河南省</option>
                                        <option value="湖北省">湖北省</option>
                                        <option value="湖南省">湖南省</option>
                                        <option value="广东省">广东省</option>
                                        <option value="广西壮族自治区">广西壮族自治区</option>
                                        <option value="海南省">海南省</option>
                                        <option value="重庆市">重庆市</option>
                                        <option value="四川省">四川省</option>
                                        <option value="贵州省">贵州省</option>
                                        <option value="云南省">云南省</option>
                                        <option value="西藏自治区">西藏自治区</option>
                                        <option value="陕西省">陕西省</option>
                                        <option value="甘肃省">甘肃省</option>
                                        <option value="青海省">青海省</option>
                                        <option value="宁夏回族自治区">宁夏回族自治区</option>
                                        <option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
                                        <option value="香港特别行政区">香港特别行政区</option>
                                        <option value="澳门特别行政区">澳门特别行政区</option>
                                        <option value="台湾省">台湾省</option>
                                        <option value="其它">其它</option>
                                    </select>
                                </div>

                                <label for="acceptorcredit" class="col-sm-2 control-label">买家等级<span
                                        class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <select class="form-control" id="acceptorcredit" name="buyerRank">
                                        <option value="0">1❤️到2❤️</option>
                                        <option value="1">3-5❤</option>
                                        <option value="2">1-2钻</option>
                                        <option value="3">3钻及以上</option>

                                    </select>
                                </div>
                            </div>

                            <hr/>

                            <div class="form-group">
                                <label for="shopname" class="col-sm-2 control-label">店铺名称<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="shopname" placeholder="" required>
                                </div>

                                <label for="shopwangwang" class="col-sm-2 control-label">店铺旺旺<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="shopwangwang" placeholder="" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="tradeprice" class="col-sm-2 control-label">付款金额<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="tradeprice" name="paymentAmount"
                                           placeholder="">
                                </div>

                                <label for="skuchoose" class="col-sm-2 control-label">SKU选择&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="skuchoose" name="sku" placeholder="">
                                </div>

                                <label for="purchasenumbers" class="col-sm-2 control-label">购买数量<span
                                        class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="purchasenumbers" name="qtyToBuy"
                                           placeholder="1">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="chatsetting" class="col-sm-2 control-label">聊天设置<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-5">
                                    <label class="radio-inline">
                                        <input type="radio" id="required" value="1" name="requireChat" checked> 需要
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="notrequired" value="0" name="requireChat"> 不需要
                                    </label>

                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="samecityforbid" value="samecityforbid"
                                               name="samecityforbid"> 同城不可接
                                    </label>
                                </div>

                                <div class="col-md-5">
                                    <div class="row">
                                        <label for="showprice" class="col-sm-5 control-label">显示价格<span
                                                class="warningtext">&nbsp * &nbsp </span></label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="showprice" placeholder="" name="price"
                                                   required>
                                        </div>

                                        <label class="radio-inline">
                                            <input type="checkbox" id="withdeliverfee" value="1"
                                                   name="shipmentCovered" checked> 包邮
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="coupon" class="col-sm-2 control-label">优惠券&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="coupon" name="coupon" placeholder="">
                                </div>

                                <label for="couponurl" class="col-sm-2 control-label">领取地址&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="couponurl" name="couponLink"
                                           placeholder="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="chatcode" class="col-sm-2 control-label">聊天暗语&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="chatcode" name="secretMessage"
                                           placeholder="">
                                </div>

                                <label for="ordercomment" class="col-sm-2 control-label">订单留言&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="ordercomment" name="commentOrder"
                                           placeholder="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="searchillustrate"
                                       class="col-sm-2 control-label">搜索说明&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="searchillustrate" name="commentSearch"
                                           placeholder="">
                                </div>

                                <label for="payillustrate" class="col-sm-2 control-label">付款说明&nbsp&nbsp&nbsp </label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="payillustrate" name="commentPay"
                                           placeholder="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="page-header">
                            <h1>聊天机制
                                <small>Chat Setting</small>
                            </h1>
                        </div>

                        <div id="chatsetting">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="chattime" class="col-sm-2 control-label">聊天时长</label>
                                        <div class="col-sm-6">
                                            <input class="form-control" type="text" id="chattime"
                                                   placeholder="系统根据宝贝价格及类目自行设置" readonly>
                                        </div>

                                        <label for="collectsetting" class="col-sm-2 control-label">收藏设置</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="collectsetting"
                                                   placeholder="默认双收藏" readonly>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="productscantime" class="col-sm-2 control-label">宝贝浏览时间</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="productscantime"
                                                   placeholder="同聊天时长" readonly>
                                        </div>

                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="firstpageofshop" value="firstpageofshop"
                                                   name="firstpageofshop"> 店铺首页
                                        </label>
                                    </div>

                                    <div class="form-group">
                                        <label for="visittimeinshop" class="col-sm-2 control-label">店内浏览</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="visittimeinshop"
                                                   placeholder="默认2-5分钟" readonly>
                                        </div>

                                        <label for="visitnumbers" class="col-sm-2 control-label">浏览个数</label>
                                        <div class="col-sm-1">
                                            <input type="text" class="form-control" id="visitnumbers" placeholder="1"
                                                   readonly>
                                        </div>

                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="ranklist" value="ranklist" name="ranklist"> 排行榜
                                        </label>

                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="randomvisiting" value="randomvisiting"
                                                   name="randomvisiting"> 随即浏览
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="page-header">
                            <h1>任务设置
                                <small>Task Setting</small>
                            </h1>
                        </div>

                        <div id="tasksetting">
                            <div class="row">
                                <div class="col-md-12">
                                    <fieldset>
                                        <div class="form-group">
                                            <label for="dtp_input1" class="col-md-2 control-label" for="publishtime">定时发布（默认立即发布）</label>
                                            <div class="input-group date form_datetime col-md-5" id="publishtime"
                                                 data-date="1979-09-16T05:25:07Z"
                                                 data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                                <input class="form-control" size="16" type="text" value="" readonly=""
                                                       name="startTime">
                                                <span class="input-group-addon"><span
                                                        class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span
                                                        class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <input type="hidden" id="dtp_input1" value="1979-09-20 14:45:07"><br>

                                        </div>
                                    </fieldset>

                                    <div class="form-group">
                                        <label for="gaptime" class="col-sm-2 control-label">每个任务间隔时间<span
                                                class="warningtext">&nbsp * &nbsp </span></label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" name="gapDuration" id="gaptime"
                                                   placeholder="分钟" required>
                                        </div>

                                        <label for="tasknumber" class="col-sm-2 control-label">发布数量<span
                                                class="warningtext">&nbsp * &nbsp </span></label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="tasknumber" placeholder="个" name="publishedCount"
                                                   required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">计算花费</label>
                                        <div class="col-sm-4">
                                            <p type="text" id="money" placeholder="">本金<span
                                                    id="cost">2.00</span>元,佣金<span id="commission">2.00</span>元,共计<span
                                                    id="addup">4.00</span>元。
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <hr/>

                    <button class="btn btn-bg btn-primary img-center" type="button" id="btnPublish">发布任务</button>

                    <br/>

                </form>

            </div>
        </div>
    </div>
</div>