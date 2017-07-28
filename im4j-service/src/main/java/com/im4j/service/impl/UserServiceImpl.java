package com.im4j.service.impl;

import com.im4j.dao.UserMapper;
import com.im4j.example.UserExample;
import com.im4j.exception.ClientException;
import com.im4j.pojo.User;
import com.im4j.pojo.ex.UserEx;
import com.im4j.service.UserService;
import com.im4j.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by chenzp on 2017/7/27 0027.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user
     * @return
     */
    public User register(User user) {
        if(true){throw new ClientException("123");}
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> users = userMapper.selectByExample(userExample);
        if(!CollectionUtils.isEmpty(users)){
            throw new ClientException("用户名已存在");
        }
        user.setStatus(UserEx.statusType.activating.name());
        user.setCreateTime(new Date());
        user.setId(StringUtils.getUuid());
        userMapper.insert(user);
        return user;
    }
}
