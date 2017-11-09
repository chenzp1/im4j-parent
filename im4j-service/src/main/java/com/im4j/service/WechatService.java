package com.im4j.service;

import com.alibaba.fastjson.JSONObject;
import com.im4j.pojo.wx.Article;
import com.im4j.pojo.wx.NewMessage;
import com.im4j.pojo.wx.TextMessage;
import com.im4j.utils.HttpclientUtil;
import com.im4j.utils.StringUtils;
import com.im4j.utils.WechatMessageUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            Map tulingMap = new HashMap();
            tulingMap.put("key","27629555be9b4ebf86fc3b1bc9452441");
            tulingMap.put("info",map.get("Content"));
            tulingMap.put("userid",fromUserName);
            String result = HttpclientUtil.doGet("http://www.tuling123.com/openapi/api",tulingMap);
            JSONObject jsonResult = JSONObject.parseObject(result);
            if(StringUtils.isEmpty(jsonResult.getString("url"))){ //返回文本消息
                TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(jsonResult.getString("text"));
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
            }else{  //返回图文消息
                NewMessage newMessage = new NewMessage();
                newMessage.setMsgType(WechatMessageUtil.MESSAGE_NEWS);
                newMessage.setToUserName(fromUserName);
                newMessage.setFromUserName(toUserName);
                newMessage.setCreateTime(System.currentTimeMillis());
                newMessage.setArticleCount("1");
                Article article = new Article();
                article.setTitle("链接");
                article.setDescription("点击进入");
                article.setPicUrl("https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=f50cf73fd843ad4ba62e41c6ba393d92/0df431adcbef76096709930527dda3cc7cd99e2d.jpg");
                article.setUrl(jsonResult.getString("url"));
                List<Article> articles = new ArrayList<Article>();
                articles.add(article);
                newMessage.setArticles(articles);
                responseMessage = WechatMessageUtil.newMessageToXml(newMessage);
                responseMessage = responseMessage.replace("com.im4j.pojo.wx.Article","item");
            }

        }
        log.info(responseMessage);
        return responseMessage;

    }
}
