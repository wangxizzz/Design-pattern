package com.code.refactoring.spring相关.spring接口实现相关.bean生命周期属性设置;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/9 21:20
 * 定义Bean初始化前后的动作
 */
@Component
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("postProcessBeforeInitialization() is called. beanName = " + beanName + "开始实例化");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("postProcessAfterInitialization() is called .beanName = " + beanName + "开始实例化");
        }
        return bean;
    }
}
