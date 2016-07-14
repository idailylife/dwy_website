package com.dianwuyou.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hebowei on 16/7/13.
 */
@Entity
@Table(name="usertask")
public class UserTask {
    private static final int STATE_CLAIMED = 0;   //任务已申领
    private static final int STATE_FINISHED = 1;  //任务已被用户标注为完成
    private static final int STATE_CONFIRMED = 2; //任务已被商家确认完成

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "task_id", nullable = false)
    private Integer taskId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;   //领取个数

    @Column(name = "claim_date", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date claimDate; //领取时间

    @Column(name = "finish_time_limit")
    private Integer finishTimeLimit;    //限制多少分钟后才能结束任务

    @Column(name = "finish_img")
    private String finishImageHref;           //任务完成截图

    @Column(name = "state", nullable = false)
    private Integer state;

    public UserTask(){
        state = STATE_CLAIMED;
        claimDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Integer getFinishTimeLimit() {
        return finishTimeLimit;
    }

    public void setFinishTimeLimit(Integer finishTimeLimit) {
        this.finishTimeLimit = finishTimeLimit;
    }

    public String getFinishImageHref() {
        return finishImageHref;
    }

    public void setFinishImageHref(String finishImageHref) {
        this.finishImageHref = finishImageHref;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
