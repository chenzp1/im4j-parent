package com.im4j.service.activemq;

import com.alibaba.fastjson.JSONObject;
import com.im4j.dao.SystemConfigMapper;
import com.im4j.example.SystemConfigExample;
import com.im4j.pojo.SystemConfig;
import com.im4j.pojo.User;
import com.im4j.pojo.ex.SystemConfigEx;
import com.im4j.utils.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.List;

/**
 * Created by chenzp on 2017/9/12 0012.
 */
public class MailMessageListener implements MessageListener {

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            logger.info("MailMessageListener消息监听到了文本消息"+tm.getText());
            User user = JSONObject.parseObject(tm.getText(),User.class);
            SystemConfigExample systemConfigExample = new SystemConfigExample();
            systemConfigExample.createCriteria().andTypeEqualTo(SystemConfigEx.statusType.email.toString());
            List<SystemConfig> systemConfigs = systemConfigMapper.selectByExample(systemConfigExample);
            if (CollectionUtils.isEmpty(systemConfigs)){
                logger.error("没有配置邮件");
                return;
            }
            SystemConfig systemconfig = systemConfigs.get(0);
            String content = systemconfig.getContent();
            MailUtil.sendHtml(user.getEmail(),"javacore注册激活",content);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
