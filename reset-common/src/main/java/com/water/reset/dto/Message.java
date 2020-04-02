package com.water.reset.dto;

import lombok.Data;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
@Data
public class Message {
    private String  id;    //id
    private String token;
    private String msg; //消息
    private String sendTime;  //时间戳
    private String site;
}
