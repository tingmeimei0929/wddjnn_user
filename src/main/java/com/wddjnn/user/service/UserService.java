package com.wddjnn.user.service;


import com.wddjnn.user.domain.dto.UserInfoDto;

public interface UserService {

    /**
     * 判断登录
     *
     * @param userName
     * @param password
     * @return
     */
    boolean checkUserLogin(String userName, String password);

    /**
     * 注册用户
     *
     * @param userInfoDto
     * @return
     */
    boolean register(UserInfoDto userInfoDto);
}
