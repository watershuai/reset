package com.water.reset.dto;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class Message {
    private String  id;    //id
    private String token;
    private String msg; //消息
    private String sendTime;  //时间戳

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

}
