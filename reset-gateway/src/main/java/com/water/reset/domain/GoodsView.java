package com.water.reset.domain;

import lombok.Data;

@Data
public class GoodsView {
    private Long goodId;
    private String title;
    private String content;
    private String url;
    private Long views;
}
