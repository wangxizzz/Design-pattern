package com.code.refactoring.rocketmq.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxi created on 2020/6/26 18:09
 * @version v1.0
 */
@RestController
@RequestMapping("/mq")
@Slf4j
public class ProducerController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @RequestMapping("/sync/send1")
    public String syncSendString(){
        //发送一个同步 消息，会返回值 ---发送到 stringTopic主题
        SendResult sendResult = rocketMQTemplate.syncSend("topicTest", "Hello, World!");
        System.out.printf("syncSend1 to  sendResult=%s %n", sendResult);
        //consumer result:------- StringConsumerNewNS received: Hello, World!
        return sendResult.toString();
    }


}
