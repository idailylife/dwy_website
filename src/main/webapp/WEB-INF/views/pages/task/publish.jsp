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
                <h1>发布任务 <small>Task Publishment</small></h1>
            </div>

            <div id="publishtask">
                <form class="form-horizontal" id="formTaskPublishment">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img id="productpicture" src="<c:url value="/static/img/biglogo.png"/> " alt="..." class="productimg" />
                                <div class="caption">
                                    <p><button href="#" class="btn btn-primary img-center " role="button" id="">上传图片</button></p>
                                    <input style="display: none;" type="file" name="image">
                                </div>
                            </div>
                        </div>

                        <div class="col-md-8">
                            <div class="form-group">
                                <label for="keywords" class="col-sm-2 control-label">关键词<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="keywords" name="keyword" placeholder="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">排序方式<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-10">
                                    <label class="radio-inline">
                                        <input type="radio" id="together" value="0" name="rankby" checked> 综合
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="popularity" value="1" name="rankby"> 人气
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="sales" value="2" name="rankby"> 销量
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="credit" value="3" name="rankby"> 信用
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="price" value="4" name="rankby"> 价格
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" id="tmall" value="5" name="rankby"> 天猫
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="tradeprice" class="col-sm-2 control-label">付款金额<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="tradeprice" name="paymentAmount" placeholder="">
                                </div>

                                <label for="skuchoose" class="col-sm-2 control-label">SKU选择<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="skuchoose" name="sku" placeholder="">
                                </div>

                                <label for="purchasenumbers" class="col-sm-2 control-label">购买数量<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="purchasenumbers" name="qtyToBuy" placeholder="">
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
                                        <input type="checkbox" id="samecityforbid" value="samecityforbid" name="samecityforbid"> 同城不可接
                                    </label>
                                </div>

                                <div class="col-md-5">
                                    <div class="row">
                                        <label for="showprice" class="col-sm-4 control-label">显示价格<span class="warningtext">&nbsp * &nbsp </span></label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="showprice" placeholder="">
                                        </div>

                                        <label class="radio-inline">
                                            <input type="checkbox" id="withdeliverfee" value="withdeliverfee" name="withdeliverfee"> 包邮
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="coupon" class="col-sm-2 control-label">优惠券<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" id="coupon" name="coupon" placeholder="">
                                </div>

                                <label for="couponurl" class="col-sm-2 control-label">领取地址<span class="warningtext">&nbsp * &nbsp </span></label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="couponurl" name="couponLink" placeholder="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="chatcode" class="col-sm-2 control-label">聊天暗语<span class="warningtext"> &nbsp&nbsp&nbsp </span></label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="chatcode" name="chatcode" placeholder="">
                                </div>

                                <label for="ordercomment" class="col-sm-2 control-label">订单留言<span class="warningtext"> &nbsp&nbsp&nbsp </span></label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="ordercomment" name="ordercomment" placeholder="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="searchillustrate" class="col-sm-2 control-label">搜索说明<span class="warningtext"> &nbsp&nbsp&nbsp </span></label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="searchillustrate" name="commentSearch" placeholder="">
                                </div>

                                <label for="payillustrate" class="col-sm-2 control-label">付款说明<span class="warningtext"> &nbsp&nbsp&nbsp </span></label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="payillustrate" name="commentPay" placeholder="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="page-header">
                            <h1>聊天机制 <small>Chat Setting</small></h1>
                        </div>

                        <div id="chatsetting">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="chattime" class="col-sm-2 control-label">聊天时长</label>
                                        <div class="col-sm-6">
                                            <input class="form-control" type="text" id="chattime" placeholder="系统根据宝贝价格及类目自行设置" readonly>
                                        </div>

                                        <label for="collectsetting" class="col-sm-2 control-label">收藏设置</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="collectsetting" placeholder="默认双收藏" readonly>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="productscantime" class="col-sm-2 control-label">宝贝浏览时间</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="productscantime" placeholder="同聊天时长" readonly>
                                        </div>

                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="firstpageofshop" value="firstpageofshop" > 店铺首页
                                        </label>
                                    </div>

                                    <div class="form-group">
                                        <label for="visittimeinshop" class="col-sm-2 control-label">店内浏览</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="visittimeinshop" placeholder="默认2-5分钟" readonly>
                                        </div>

                                        <label for="visitnumbers" class="col-sm-2 control-label">浏览个数</label>
                                        <div class="col-sm-1">
                                            <input type="text" class="form-control" id="visitnumbers" placeholder="1" readonly>
                                        </div>

                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="ranklist" value="ranklist" name="ranklist"> 排行榜
                                        </label>

                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="randomvisiting" value="randomvisiting" name="randomvisiting"> 随即浏览
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="page-header">
                            <h1>任务设置 <small>Task Setting</small></h1>
                        </div>

                        <div id="tasksetting">
                            <div class="row">
                                <div class="col-md-12">
                                    <fieldset>
                                        <div class="form-group">
                                            <label for="dtp_input1" class="col-md-2 control-label" for="publishtime">定时发布（默认立即发布）</label>
                                            <div class="input-group date form_datetime col-md-5" id="publishtime"  data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                                <input class="form-control" size="16" type="text" value="" readonly="" name="startTime">
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <input type="hidden" id="dtp_input1" value="1979-09-20 14:45:07"><br>

                                        </div>
                                    </fieldset>
                                    <script type="text/javascript">
                                        $('.form_datetime').datetimepicker({
                                            //language:  'fr',
                                            weekStart: 1,
                                            todayBtn:  1,
                                            autoclose: 1,
                                            todayHighlight: 1,
                                            startView: 2,
                                            forceParse: 0,
                                            showMeridian: 1
                                        });
                                    </script>

                                    <div class="form-group">
                                        <label for="acceptorcredit" class="col-sm-2 control-label">接手所需信用度</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" id="acceptorcredit" name="buyerRank">
                                                <option value="0">1❤️到2❤️</option>
                                                <option value="1">3-5❤</option>
                                                <option value="2">1-2钻</option>
                                                <option value="3">3钻及以上</option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="gaptime" class="col-sm-2 control-label">每个任务间隔时间<span class="warningtext">&nbsp * &nbsp </span></label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" name="gapDuration" id="gaptime" placeholder="分钟" >
                                        </div>

                                        <label for="tasknumber" class="col-sm-2 control-label">发布数量<span class="warningtext">&nbsp * &nbsp </span></label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="tasknumber" placeholder="个" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="expense" class="col-sm-2 control-label">计算花费</label>
                                        <div class="col-sm-4">
                                            <p type="text" id="money" placeholder="">本金<span id="cost">2.00</span>元,佣金<span id="commission">2.00</span>元,共计<span id="addup">4.00</span>元。
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <hr />

                    <button class="btn btn-bg btn-primary img-center" type="submit">发布任务</button>、

                    <br />

                </form>
                <script>
                    $("#registerForm").validate();
                </script>
            </div>
        </div>
    </div>
</div>