package com.code.refactoring.spring相关.spring单例多例相关;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/10 10:41
 */
@Component
@Scope("prototype")
public class PrototypeBean implements CommonBean{

    private String name;

    public PrototypeBean(){}

    public PrototypeBean(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("PrototypeBean name = " + name);
    }
}
