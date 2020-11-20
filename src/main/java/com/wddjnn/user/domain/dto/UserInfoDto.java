package com.wddjnn.user.domain.dto;

import lombok.Data;

/**
 * 用户信息
 * @author wyc
 */
@Data
public class UserInfoDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户昵称
     */
    private String userNickName;
}
