package com.code.refactoring.spring相关.spring单例多例相关;

import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/10 10:41
 */
@Component
public class SingletonBean implements CommonBean{

    private String name;

    public SingletonBean(){}

    public SingletonBean(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("SingletonBean name = " + name);
    }
}
