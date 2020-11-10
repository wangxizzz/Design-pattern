package com.code.refactoring.spring相关.事件驱动相关.jdk事件驱动;

/**
 * @author wangxi created on 2020/11/1 17:45
 * @version v1.0
 */
public interface Observer {
    // 当被观察的对象发生变化时候，这个方法会被调用
    //Observable o：被观察的对象
    // Object arg：传入的参数
    void update(Observable o, Object arg);
}
