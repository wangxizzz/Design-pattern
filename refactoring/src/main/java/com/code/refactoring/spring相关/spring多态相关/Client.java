package com.code.refactoring.spring相关.spring多态相关;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:25
 * 测试执行的类
 */
@Component
public class Client implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void fun01(boolean flag) {
        Person person;
        if (flag) {
            person = applicationContext.getBean(WhitePerson.class);
        } else {
            person = applicationContext.getBean(BlackPerson.class);
        }
        person.say();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
