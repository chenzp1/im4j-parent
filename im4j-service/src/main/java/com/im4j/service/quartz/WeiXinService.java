package com.im4j.service.quartz;


import com.alibaba.fastjson.JSONObject;
import com.im4j.pojo.Constants;
import com.im4j.service.redis.RedisService;
import com.im4j.utils.HttpclientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by chenzp on 2017/11/9 0009.
 */
@Component
public class WeiXinService {

    Logger logger = LoggerFactory.getLogger(WeiXinService.class);

    @Autowired
    private RedisService redisService;

    @Scheduled(cron="0/5 * *  * * ? ")   //每一个半小时获取一次token
    public void getToken(){
        String res = HttpclientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxcb7ec3dde373f854&secret=844346396777e28aae830fcb4a2f8fe4");
        redisService.add(Constants.ACCESS_TOKEN, JSONObject.parseObject(res).getString("access_token"));
    }
}
