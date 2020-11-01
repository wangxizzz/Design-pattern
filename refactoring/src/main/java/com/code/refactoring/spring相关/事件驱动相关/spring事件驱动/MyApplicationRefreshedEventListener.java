package com.code.refactoring.spring相关.事件驱动相关.spring事件驱动;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author wangxi created on 2020/11/1 18:19
 * @version v1.0
 */
@Slf4j
@Component
public class MyApplicationRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Object source = event.getSource();
        ApplicationContext applicationContext = event.getApplicationContext();
        // 此处的source就是ApplicationContext这个对象
        System.out.println(source); //WebApplicationContext for namespace 'dispatcher-servlet': startup date [Tue Mar 26 14:26:27 CST 2019]; parent: Root WebApplicationContext

        //容器此时已经准备好了，可以做你该做的事了~......（请注意：若存在父子容器或者多个容器情况，此方法会被执行多次，请务必注意是否幂等）

    }
}
