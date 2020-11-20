package com.wddjnn.user.service.impl;

import com.wddjnn.user.dao.UserMapper;
import com.wddjnn.user.domain.dto.UserInfoDto;
import com.wddjnn.user.enums.YesNoEnum;
import com.wddjnn.user.model.User;
import com.wddjnn.user.model.UserExample;
import com.wddjnn.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户接口
 *
 * @author wyc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkUserLogin(String userName, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName).andUserPasswordEqualTo(password).andYnEqualTo((byte) YesNoEnum.YES.getCode());
        userMapper.countByExample(example);
        return userMapper.countByExample(example) > 0;
    }

    @Override
    public boolean register(UserInfoDto userInfoDto) {
        User user = new User();
        BeanUtils.copyProperties(userInfoDto, user);
        user.setYn((byte) YesNoEnum.YES.getCode());
        user.setCreateTime(new Date());
        return userMapper.insert(user) > 0;
    }
}
