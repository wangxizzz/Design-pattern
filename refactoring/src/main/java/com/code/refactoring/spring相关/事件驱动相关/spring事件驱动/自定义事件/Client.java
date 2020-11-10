package com.code.refactoring.spring相关.事件驱动相关.spring事件驱动.自定义事件;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangxi created on 2020/11/1 18:50
 * @version v1.0
 */
public class Client {
    public static void main(String[] args) {
        // 只会加载指定的Bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAllEventListener.class);
        // 发布自己的事件
        applicationContext.publishEvent(new MyAppEvent("this is my event"));
    }
}
