package com.water.reset.dto;

import lombok.Data;

import java.util.Date;
@Data
public class GoodView {
    private Long id;

    private Long goodId;

    private String title;

    private String content;

    private String url;

    private Long views;

    private Date createTime;

}