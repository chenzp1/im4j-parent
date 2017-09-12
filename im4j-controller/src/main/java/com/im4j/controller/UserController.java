package com.im4j.controller;

import com.im4j.cmmon.Result;
import com.im4j.exception.ClientException;
import com.im4j.pojo.User;
import com.im4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by chenzp on 2017/7/27 0027.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /** 
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public Result register(@RequestBody  User user){
        return  Result.getInstance(userService.register(user));
    }



}
