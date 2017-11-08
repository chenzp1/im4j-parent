package com.im4j.controller;

import com.im4j.cmmon.Result;
import com.im4j.pojo.User;
import com.im4j.service.UserService;
import com.im4j.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;



/**
 * Created by chenzp on 2017/7/27 0027.
 */
@Controller
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private WechatService wechatService;


    /** 
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public Result register(@RequestBody User user){
        return  Result.getInstance(userService.register(user));
    }


    /**
     * token验证
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "acceptMsg", method = RequestMethod.GET)
    public void token( HttpServletRequest request,HttpServletResponse response) throws IOException {
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter print;
        if (isGet) {
            // 微信加密签名111
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *
     * @param out
     * @param request
     * @param response
     */
    @RequestMapping(value = "acceptMsg", method = RequestMethod.POST)
    @ResponseBody
    public void acceptMsg(PrintWriter out, HttpServletRequest request, HttpServletResponse response){
        String responseMessage = wechatService.processRequest(request);
        logger.info("返回消息:"+responseMessage);
        out.print(responseMessage);
        out.flush();
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "123";
    }
}
