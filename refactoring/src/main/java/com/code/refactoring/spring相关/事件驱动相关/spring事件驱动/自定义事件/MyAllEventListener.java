package com.code.refactoring.spring相关.事件驱动相关.spring事件驱动.自定义事件;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author wangxi created on 2020/11/1 20:34
 * @version v1.0
 * <p>
 * 基于注解 这种方式更被推崇，因为它是方法级别的
 */
@Component
public class MyAllEventListener {
    //value必须给值,但可以不用是ApplicationEvent的子类  任意事件都ok
    // 也可以给一个入参，代表事件的Event
    @EventListener(value = {ContextRefreshedEvent.class, MyAppEvent.class}
            // condition的使用，若同一个事件进行区分同步异步 等等条件的可以使用此condition 支持spel表达式  非常强大
            /*,condition = "#event.isAsync == false"*/)
    // 可以利用 Order注解实现监听顺序
    public void handle(Object source) {
        System.out.println(source);
        System.out.println("事件来了~");
    }
}
