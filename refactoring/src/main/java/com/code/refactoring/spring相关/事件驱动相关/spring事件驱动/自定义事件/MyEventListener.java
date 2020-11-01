package com.code.refactoring.spring相关.事件驱动相关.spring事件驱动.自定义事件;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wangxi created on 2020/11/1 18:49
 * @version v1.0
 */

// 写个监听器，然后交给容器管理即可
@Slf4j
@Component
public class MyEventListener implements ApplicationListener<MyAppEvent> {
    @Override
    public void onApplicationEvent(MyAppEvent event) {
        Object source = event.getSource();
        long timestamp = event.getTimestamp();

        System.out.println("==========" + source);
        System.out.println(timestamp);
        //doSomething

    }
}
