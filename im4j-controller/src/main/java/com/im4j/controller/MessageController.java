package com.im4j.controller;

import com.im4j.service.activemq.ConsumerService;
import com.im4j.service.activemq.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * Created by chenzp on 2017/9/12 0012.
 */
public class MessageController {
//    private Logger logger = LoggerFactory.getLogger(MessageController.class);
//    @Autowired
//    private Destination destination;
//
//    //队列消息生产者
//    @Autowired
//    private ProducerService producer;
//
//    //队列消息消费者
//    @Autowired
//    private ConsumerService consumer;
//
//    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
//    @ResponseBody
//    public void send(String msg) {
//        logger.info(Thread.currentThread().getName()+"------------send to jms Start");
//        producer.sendMessage(msg);
//        logger.info(Thread.currentThread().getName()+"------------send to jms End");
//    }
//
//    @RequestMapping(value= "receiveMessage",method = RequestMethod.GET)
//    @ResponseBody
//    public Object receive(){
//        logger.info(Thread.currentThread().getName()+"------------receive from jms Start");
//        TextMessage tm = consumer.receive(destination);
//        logger.info(Thread.currentThread().getName()+"------------receive from jms End");
//        return tm;
//    }
}
