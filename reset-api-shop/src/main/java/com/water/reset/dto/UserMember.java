package com.water.reset.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserMember {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String icon;

    private String email;

    private String nickName;

    private String note;

    private Date createTime;

    private Date loginTime;

    private Integer status;
}