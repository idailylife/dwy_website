package com.dianwuyou.model.json;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by hebowei on 16/6/10.
 */
public class AjaxResponseBody {
    @JsonView(JsonDummyView.Public.class)
    Integer state;

    @JsonView(JsonDummyView.Public.class)
    String message;

    @JsonView(JsonDummyView.Public.class)
    String content;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
