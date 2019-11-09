package com.code.refactoring.spring相关.spring接口实现相关.bean生命周期属性设置;


import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author wangxi
 * @Time 2019/11/9 22:36
 * 防止测试MYBean混淆结果，因此注释掉这个Bean
 */
//@Component
public class MyBean02 implements InitializingBean {

    /**
     * javaEE5引入了@PostConstruct和@PreDestroy两个作用于Servlet生命周期的注解，
     * 实现Bean初始化之前和销毁之前的自定义操作
     *
     *  在项目中主要是在Servlet初始化之前加载一些缓存数据等
     */
    @PostConstruct
    public void init() {
        System.out.println("jdk自带的注解 init() 调用");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jdk自带的注解 destroy() 调用");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet() is called");
    }
}
