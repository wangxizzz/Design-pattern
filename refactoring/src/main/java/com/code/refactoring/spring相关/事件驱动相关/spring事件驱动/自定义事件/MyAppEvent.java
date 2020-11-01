package com.code.refactoring.spring相关.事件驱动相关.spring事件驱动.自定义事件;

import org.springframework.context.ApplicationEvent;

/**
 * @author wangxi created on 2020/11/1 18:48
 * @version v1.0
 */
public class MyAppEvent extends ApplicationEvent {
    public MyAppEvent(String source) {
        super(source);
    }
}
