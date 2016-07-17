package com.dianwuyou.model.json;

import javax.validation.constraints.NotNull;

/**
 * Created by hebowei on 16/7/17.
 */
public class TaskClaimRequestBody {
    @NotNull
    Integer taskId;

    @NotNull
    Integer messageId;

    @NotNull
    Integer quantity;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
