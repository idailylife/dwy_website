package com.dianwuyou.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created by hebowei on 16/7/5.
 */
public class ShopValidation {
    @NotNull
    String taobaoId;

    @NotNull
    String qq;

    @NotNull
    MultipartFile screenshotImg;

    public String getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(String taobaoId) {
        this.taobaoId = taobaoId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public MultipartFile getScreenshotImg() {
        return screenshotImg;
    }

    public void setScreenshotImg(MultipartFile screenshotImg) {
        this.screenshotImg = screenshotImg;
    }
}
