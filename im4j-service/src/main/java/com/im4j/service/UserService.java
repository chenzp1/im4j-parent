package com.im4j.service;

import com.im4j.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by chenzp on 2017/7/27 0027.
 */

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    User register(User user);
}
