package com.im4j.service.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by chenzp on 2017/9/12 0012.
 */
public class QueueMessageListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());
            throw new RuntimeException();
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
