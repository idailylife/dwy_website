package com.dianwuyou.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by hebowei on 16/6/19.
 */
@Entity
@Table(name = "task")
public class Task {
    public final static int TYPE_SEARCH = 0;
    public final static int TYPE_TAOKOULING = 1;
    public final static int TYPE_ZHITONGCHE = 2;
    public final static int TYPE_SHOPPING_CART = 3;
    public final static int TYPE_FOOTPRINT = 4;
    public final static int TYPE_ACTIVITY = 5;

    public final static int ENTRANCE_TAOBAO_APP = 0;
    public final static int ENTRANCE_TAOBAO_SEARCH = 1;
    public final static int ENTRANCE_TMALL_APP = 2;
    public final static int ENTRANCE_TMALL_SEARCH = 3;
    public final static int ENTRANCE_MOBILE = 4;
    public final static int ENTRANCE_PC = 5;

    public final static int RANK_BY_COMPREHENSIVE = 0; //综合
    public final static int RANK_BY_POPULATION = 1; //人气
    public final static int RANK_BY_SALES = 2; //销量
    public final static int RANK_BY_CREDIT = 3; //信用
    public final static int RANK_BY_PRICE = 4;  //价格
    public final static int RANK_BY_TMALL = 5;  //天猫

    public final static int PAGE_RANGE_TOP10 = 0; //前十页


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "owner_id")
    private Integer ownerId;    //任务发布者

    @Column(name = "start_time", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date startTime;

    @Column(name = "img_href")
    private String imgHref; //内部图片存储文件名,文件会存储在以task id 命名的目录底下

    @Column(name = "gap_duration")
    @NotNull
    @Min(0)
    private Integer gapDuration;    //每个任务间隔时长(分钟)

    @Column(name = "type")
    @NotNull
    private Integer type;   //类型

    @Column(name = "entrance_type")
    private Integer entranceType; //入口

    @Column(name = "keyword")
    @Length(min = 1, max = 256)
    private String keyword; //关键词(in:自然搜索、直通车、购物车、足迹)

    @Column(name = "taokouling")
    //@Length(min = 1, max = 256)
    private String taokouling; //淘口令

    @Column(name = "act_name")
    //@Length(min = 1, max = 128)
    private String actName;     //活动名称

    @Column(name = "act_type")
    //@Length(min = 1, max = 128) //活动细分
    private String actType;

    @Column(name = "rank_by")
    private Integer rankBy; //排序方式

    @Column(name = "buyer_gender")
    private String buyerGender;

    @Column(name = "buyer_age_low")
    @Min(0)
    @Max(150)
    private Integer buyerAgeLow;

    @Column(name = "buyer_age_high")
    @Min(0)
    @Max(150)
    private Integer buyerAgeHigh;

    @Column(name = "buyer_location")
    private String buyerLocation;

    @Column(name = "buyer_rank")
    @NotNull
    private Integer buyerRank;  //买家等级,在User中定义了

    @Column(name = "payment_amount")
    @NotNull
    private Double paymentAmount; //付款金额(底价)

    @Column(name = "sku")
    private String sku;

    @Column(name = "qty_to_buy")
    @Min(1)
    private Integer qtyToBuy;   //买家需要购买的商品数量

    @Column(name = "published_count", nullable = false)
    @Min(1)
    private Integer publishedCount; //任务发布数量

    @Column(name = "claimed_count")
    private Integer claimedCount;   //已经申领任务的用户数量

    @Column(name = "finished_count")
    private Integer finishedCount;  //实际完成的用户数量

    @Column(name = "require_chat")
    @Type(type = "numeric_boolean")
    private Boolean requireChat; //聊天设置 0 or 1

    @Column(name = "page_range")
    private Integer pageRange;  //搜索页码范围

    @Column(name = "price")
    @NotNull
    private Double price;   //商品价格

    @Column(name = "shipment_covered")
    @NotNull
    @Type(type = "numeric_boolean")
    private Boolean shipmentCovered;

    @Column(name = "coupon")
    @Min(0)
    private Double coupon;  //优惠券面值

    @Column(name = "coupon_link")
    private String couponLink;  //优惠券领取链接

    @Column(name = "sec_msg")
    private String secretMessage;   //聊天暗语

    @Column(name = "comment_order")
    @Length(max = 100)
    private String commentOrder;     //订单留言

    @Column(name = "comment_search")
    @Length(max = 100)
    private String commentSearch;   //搜索说明

    @Column(name = "comment_pay")
    @Length(max = 100)
    private String commentPay;      //付款说明

    @Transient
    private MultipartFile image;

    public Task(){
        claimedCount = 0;
        finishedCount = 0;
    }

    /**
     * 计算佣金单价
     * @return
     */
    public Double getCommission(){
        double baseUnitPrice = User.getUnitPrice(buyerRank);
        //淘口令、活动方式的佣金底价减少1元
        //购物车方式佣金底价增加1元
        if(type == TYPE_TAOKOULING || type == TYPE_ACTIVITY)
            baseUnitPrice -= 1.0;
        else if(type == TYPE_SHOPPING_CART)
            baseUnitPrice += 1.0;
        return paymentAmount * qtyToBuy * 0.01 + baseUnitPrice; //佣金 = 底价+付款金额*0.01
    }

    /**
     * 计算商家全部花费
     * @return
     */
    public Double getTotalCost(){
        return publishedCount * (paymentAmount * qtyToBuy + getCommission());   //总费用 = (本金 + 佣金)*发布数量
    }

    public String getEntranceTypeName(){
        switch (entranceType){
            case ENTRANCE_TAOBAO_APP:
                return "淘宝APP";
            case ENTRANCE_TAOBAO_SEARCH:
                return "淘宝搜索";
            case ENTRANCE_TMALL_APP:
                return "天猫APP";
            case ENTRANCE_TMALL_SEARCH:
                return "天猫搜索";
            case ENTRANCE_MOBILE:
                return "移动端";
            case ENTRANCE_PC:
                return "PC端";
            default:
                return "未定义";
        }
    }

    /**
     * 获取入口设备类型
     * @return 0-手机,1-电脑
     */
    public Integer getDeviceType(){
        switch (entranceType){
            case ENTRANCE_MOBILE:
            case ENTRANCE_TAOBAO_APP:
            case ENTRANCE_TMALL_APP:
                return 0;
            case ENTRANCE_PC:
            case ENTRANCE_TAOBAO_SEARCH:
            case ENTRANCE_TMALL_SEARCH:
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("keyword", keyword);
        jsonObject.append("id", id);
        jsonObject.append("commission", getCommission());
        jsonObject.append("price", price);
        return jsonObject.toString();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getGapDuration() {
        return gapDuration;
    }

    public void setGapDuration(Integer gapDuration) {
        this.gapDuration = gapDuration;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEntranceType() {
        return entranceType;
    }

    public void setEntranceType(Integer entranceType) {
        this.entranceType = entranceType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTaokouling() {
        return taokouling;
    }

    public void setTaokouling(String taokouling) {
        this.taokouling = taokouling;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public Integer getRankBy() {
        return rankBy;
    }

    public void setRankBy(Integer rankBy) {
        this.rankBy = rankBy;
    }

    public String getBuyerGender() {
        return buyerGender;
    }

    public void setBuyerGender(String buyerGender) {
        this.buyerGender = buyerGender;
    }

    public Integer getBuyerAgeLow() {
        return buyerAgeLow;
    }

    public void setBuyerAgeLow(Integer buyerAgeLow) {
        this.buyerAgeLow = buyerAgeLow;
    }

    public Integer getBuyerAgeHigh() {
        return buyerAgeHigh;
    }

    public void setBuyerAgeHigh(Integer buyerAgeHigh) {
        this.buyerAgeHigh = buyerAgeHigh;
    }

    public String getBuyerLocation() {
        return buyerLocation;
    }

    public void setBuyerLocation(String buyerLocation) {
        this.buyerLocation = buyerLocation;
    }

    public Integer getBuyerRank() {
        return buyerRank;
    }

    public void setBuyerRank(Integer buyerRank) {
        this.buyerRank = buyerRank;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQtyToBuy() {
        return qtyToBuy;
    }

    public void setQtyToBuy(Integer qtyToBuy) {
        this.qtyToBuy = qtyToBuy;
    }

    public Integer getClaimedCount() {
        return claimedCount;
    }

    public void setClaimedCount(Integer claimedCount) {
        this.claimedCount = claimedCount;
    }

    public Boolean getRequireChat() {
        return requireChat;
    }

    public void setRequireChat(Boolean requireChat) {
        this.requireChat = requireChat;
    }

    public Integer getPageRange() {
        return pageRange;
    }

    public void setPageRange(Integer pageRange) {
        this.pageRange = pageRange;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getShipmentCovered() {
        return shipmentCovered;
    }

    public void setShipmentCovered(Boolean shipmentCovered) {
        this.shipmentCovered = shipmentCovered;
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public String getCouponLink() {
        return couponLink;
    }

    public void setCouponLink(String couponLink) {
        this.couponLink = couponLink;
    }

    public String getSecretMessage() {
        return secretMessage;
    }

    public void setSecretMessage(String secretMessage) {
        this.secretMessage = secretMessage;
    }

    public String getCommentOrder() {
        return commentOrder;
    }

    public void setCommentOrder(String commentOrder) {
        this.commentOrder = commentOrder;
    }

    public String getCommentSearch() {
        return commentSearch;
    }

    public void setCommentSearch(String commentSearch) {
        this.commentSearch = commentSearch;
    }

    public String getCommentPay() {
        return commentPay;
    }

    public void setCommentPay(String commentPay) {
        this.commentPay = commentPay;
    }

    public String getImgHref() {
        return imgHref;
    }

    public void setImgHref(String imgHref) {
        this.imgHref = imgHref;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Integer getPublishedCount() {
        return publishedCount;
    }

    public void setPublishedCount(Integer publishedCount) {
        this.publishedCount = publishedCount;
    }

    public Integer getFinishedCount() {
        return finishedCount;
    }

    public void setFinishedCount(Integer finishedCount) {
        this.finishedCount = finishedCount;
    }
}
