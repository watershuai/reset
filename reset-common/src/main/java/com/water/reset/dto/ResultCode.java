package com.water.reset.dto;

import lombok.Getter;
import lombok.Setter;

public enum ResultCode {
    NO_LOGIN(201,"请先登录");
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String message;
    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
