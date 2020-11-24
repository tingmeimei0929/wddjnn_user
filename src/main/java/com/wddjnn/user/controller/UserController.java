package com.wddjnn.user.controller;

import com.wddjnn.user.domain.dto.UserInfoDto;
import com.wddjnn.user.domain.dto.UserLoginDto;
import com.wddjnn.user.service.UserService;
import com.wddjnn.user.util.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author wyc
 */
@RestController
@RequestMapping("wddjnn/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 登录接口
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Wrapper<Boolean> login(@RequestBody UserLoginDto dto) {
        try {
            return new Wrapper<Boolean>().result(userService.checkUserLogin(dto.getUserName(), dto.getPassword()));
        } catch (Exception e) {
            log.error("登录失败", e);
            return new Wrapper(500, "登录失败");
        }
    }

    /**
     * 注册接口
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Wrapper<Boolean> register(@RequestBody UserInfoDto dto) {
        try {
            return new Wrapper<Boolean>().result(userService.register(dto));
        } catch (Exception e) {
            log.error("注册失败", e);
            return new Wrapper(500, "注册失败");
        }
    }
}
