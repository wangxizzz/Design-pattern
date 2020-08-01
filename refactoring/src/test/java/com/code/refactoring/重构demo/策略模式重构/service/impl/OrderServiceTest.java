package com.code.refactoring.重构demo.策略模式重构.service.impl;


import com.code.refactoring.重构demo.ifelse重构.订单业务.model.Order;
import com.code.refactoring.重构demo.ifelse重构.订单业务.model.OrderEnum;
import com.code.refactoring.重构demo.ifelse重构.订单业务.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/11/9 20:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    /**
     * 按名称注入
     */
    @Resource(name = "orderServiceV1")
    private OrderService orderServiceV1;
    @Resource(name = "orderServiceV2")
    private OrderService orderServiceV2;

    @Test
    public void orderHandlerTest() {
        Order order = new Order(OrderEnum.NORMAL_ORDER.getOrderType());

        String resultV1 = orderServiceV1.handle(order);
        System.out.println(resultV1);

        String resultV2 = orderServiceV2.handle(order);
        System.out.println(resultV2);
    }
}