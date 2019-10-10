package com.hungkuei.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserEntity {

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private String avatar;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
