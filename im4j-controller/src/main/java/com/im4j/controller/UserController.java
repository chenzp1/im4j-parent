package com.im4j.controller;

import com.im4j.cmmon.Result;
import com.im4j.exception.ClientException;
import com.im4j.pojo.User;
import com.im4j.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;


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

    /**
     * 用户登陆
     * @param request
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Result login(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password"));
            subject.login(token);//会跳到我们自定义的realm中
            request.getSession().setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.getInstance("");
    }



}
