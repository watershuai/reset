package com.water.reset.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodInfo {
    private Long id;

    private Long shopId;

    private String shopName;

    private Long goodsId;

    private Long supplierId;

    private String supplierName;

    private Byte goodsType;

    private Integer brandId;

    private String goodsName;

    private String goodsSubheading;

    private String goodsFeatures;

    private Byte returnRules;

    private String defaultImg;

    private Long freightTemplateId;

    private String descAttrInfo;

    private String goodsSaleName;

    private BigDecimal sellPrice;

    private BigDecimal supplyPrice;

    private Byte delStatus;

    private Integer countView;

    private Integer goodSource;

    private Byte upLowStatus;

    private String faqImg;

    private Date createTime;

    private String createUser;

    private Byte createUserType;

    private Date updateTime;

    private String updateUser;

}