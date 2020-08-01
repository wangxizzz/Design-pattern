//package com.code.refactoring.rocketmq.demo;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
///**
// * @author wangxi created on 2020/6/26 18:16
// * @version v1.0
// */
//@Service
//@RocketMQMessageListener(nameServer = "${rocketmq.nameserver}", topic = "topicTest", consumerGroup = "string_consumer")
//public class StringConsumerNewNS implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String message) {
//        System.out.printf("------- StringConsumerNewNS received: %s \n", message);
//    }
//}
