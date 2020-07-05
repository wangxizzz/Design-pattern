package com.code.refactoring.重构demo.策略模式重构.service.impl;

import com.code.refactoring.BaseTest;
import com.code.refactoring.重构demo.策略模式重构.model.Order;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author wangxi created on 2020/7/5 16:00
 * @version v1.0
 */
public class OrderServiceV2ImplTest extends BaseTest {

    @Resource
    private OrderServiceV2Impl orderServiceV2;

    @Test
    public void handleTest() {
        Order order = new Order("2");

        String handle = orderServiceV2.handle(order);

        System.out.println(handle);
    }
}