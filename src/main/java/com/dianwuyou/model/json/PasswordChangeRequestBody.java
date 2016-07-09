package com.dianwuyou.model.json;

import javax.validation.constraints.NotNull;

/**
 * Created by hebowei on 16/7/9.
 */
public class PasswordChangeRequestBody {
    @NotNull
    String oldPasswordMd5;

    @NotNull
    String newPasswordMd5;

    @NotNull
    String phoneVerifyCode;

    public String getOldPasswordMd5() {
        return oldPasswordMd5;
    }

    public void setOldPasswordMd5(String oldPasswordMd5) {
        this.oldPasswordMd5 = oldPasswordMd5;
    }

    public String getNewPasswordMd5() {
        return newPasswordMd5;
    }

    public void setNewPasswordMd5(String newPasswordMd5) {
        this.newPasswordMd5 = newPasswordMd5;
    }

    public String getPhoneVerifyCode() {
        return phoneVerifyCode;
    }

    public void setPhoneVerifyCode(String phoneVerifyCode) {
        this.phoneVerifyCode = phoneVerifyCode;
    }
}
