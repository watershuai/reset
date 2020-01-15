package com.water.reset.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class CartItem {
    private Integer id;

    private Long memberId;

    private Long cartItemId;

    private Long skuId;

    private Integer quantity;

    private Long goodsId;

    private BigDecimal cartPrice;

    private Long activityId;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;

    private Boolean isDel;


}