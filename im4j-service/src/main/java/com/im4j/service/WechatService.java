package com.im4j.service;

import com.alibaba.fastjson.JSONObject;
import com.im4j.pojo.TextMessage;
import com.im4j.utils.HttpclientUtil;
import com.im4j.utils.WechatMessageUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzp on 2017/11/8 0008.
 */
@Service
public class WechatService {
    private static Logger log = Logger.getLogger(WechatService.class);

    public String processRequest(HttpServletRequest request) {
        Map<String, String> map = WechatMessageUtil.xmlToMap(request);
        log.info(map);
        // 发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        // 消息类型
        String msgType = map.get("MsgType");
        // 默认回复一个"success"
        String responseMessage = "success";
        // 对消息进行处理
        if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(System.currentTimeMillis());
            Map tulingMap = new HashMap();
            tulingMap.put("key","27629555be9b4ebf86fc3b1bc9452441");
            tulingMap.put("info",map.get("Content"));
            tulingMap.put("userid",fromUserName);
            String result = HttpclientUtil.doGet("http://www.tuling123.com/openapi/api",tulingMap);
            textMessage.setContent(JSONObject.parseObject(result).getString("text"));
            responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        }
        log.info(responseMessage);
        return responseMessage;

    }
}
