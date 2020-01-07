package com.water.reset.dto;

public class ResultInfo {
    private boolean success;
    private String msg;
    private Integer resultCode;
    private Object data;
    public ResultInfo(){
    }
    public ResultInfo(Integer resultCode, String msg){
        this.success=true;
        this.resultCode=resultCode;
        this.msg=msg;
    }
    public ResultInfo(boolean success, Integer resultCode, String msg){
        this.success=success;
        this.resultCode=resultCode;
        this.msg=msg;
    }
    public ResultInfo(boolean success, Integer resultCode, String msg,Object data){
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

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
