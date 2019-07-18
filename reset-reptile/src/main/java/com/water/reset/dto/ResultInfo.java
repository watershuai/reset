package com.water.reset.dto;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private boolean success;
    private String msg;
    private String resultCode;
    private Object data;
    public ResultInfo(boolean success, String resultCode, String msg){
        this.success=success;
        this.resultCode=resultCode;
        this.msg=msg;
    }
    public ResultInfo(boolean success, String resultCode, String msg,Object data){
        this.success=success;
        this.resultCode=resultCode;
        this.msg=msg;
        this.data=data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
