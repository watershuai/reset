package com.water.reset.dto;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class HttpInfo {
    //请求返回字符串
    private String resultString;
    //请求返回字节流
    private byte[] resultbyte;
    //请求返回状态
    private int statusCode;

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public byte[] getResultbyte() {
        return resultbyte;
    }

    public void setResultbyte(byte[] resultbyte) {
        this.resultbyte = resultbyte;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
