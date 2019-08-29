package com.tiger.formbean;

import javax.validation.constraints.NotBlank;

public class SendSmsCodeParam {
    @NotBlank
    private String phone;
    @NotBlank(message = "图片验证码不能为空")
    private String verifyCode;

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
