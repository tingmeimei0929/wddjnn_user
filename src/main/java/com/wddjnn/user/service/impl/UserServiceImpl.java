package com.wddjnn.user.service.impl;

import com.wddjnn.user.dao.UserMapper;
import com.wddjnn.user.domain.dto.UserInfoDto;
import com.wddjnn.user.enums.YesNoEnum;
import com.wddjnn.user.model.User;
import com.wddjnn.user.model.UserExample;
import com.wddjnn.user.service.UserService;
import com.wddjnn.user.util.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 用户接口
 *
 * @author wyc
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkUserLogin(String userName, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName).andUserPasswordEqualTo(password).andYnEqualTo((byte) YesNoEnum.YES.getCode());
        List<User> user = userMapper.selectByExample(example);

        boolean result = !CollectionUtils.isEmpty(user);

        if (result) {
            try {
                User loginUser = new User();
                loginUser.setLastLoginTime(new Date());
                loginUser.setId(user.get(0).getId());
                loginUser.setUpdateTime(new Date());
                userMapper.updateByPrimaryKeySelective(loginUser);
            } catch (Exception e) {
                log.error("更新用户登录时间失败", e);
            }
        }

        return result;
    }

    @Override
    public boolean register(UserInfoDto userInfoDto) {
        boolean result;
        User user = new User();
        BeanUtils.copyProperties(userInfoDto, user);
        user.setYn((byte) YesNoEnum.YES.getCode());
        user.setCreateTime(new Date());
        user.setStatus((byte) YesNoEnum.YES.getCode());
        try {
            result = userMapper.insert(user) > 0;
        } catch (DuplicateKeyException dle) {
            throw new BizException(500001, "该用户名已存在～");
        }
        return result;
    }


}
