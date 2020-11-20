package com.wddjnn.user.domain.dto;

import lombok.Data;

@Data
public class UserLoginDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;
}
