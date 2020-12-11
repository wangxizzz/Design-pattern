package com.code.refactoring.spring相关.spring接口实现相关.smartInitializingSingleton接口;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * Author wangxi03
 * Date 2020/12/11 11:44 上午
 * Version 1.0
 */
@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {
    private ListableBeanFactory beanFactory;

    public MySmartInitializingSingleton(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("aaaaaaaa");
    }
}
