package com.code.refactoring.spring相关.spring接口实现相关.bean属性设置相关;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/11/9 21:18
 * 用做测试Bean，观察该Bean初始化过程中上面4个方法执行的先后顺序和内容
 */
public class MyBean implements InitializingBean {

    @Resource
    private Component01 component01;

    /**
     * 初始化一个对象（bean）后立即初始化（加载）一些数据
     */
    public void init() {
        // 先填充MyBean的属性
        System.out.println(component01);
        System.out.println("init() is called");
    }

    /**
     * 销毁一个对象之前进行垃圾回收
     */
    public void destroy() {
        System.out.println("destroy() is called");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet is called");
    }
}
