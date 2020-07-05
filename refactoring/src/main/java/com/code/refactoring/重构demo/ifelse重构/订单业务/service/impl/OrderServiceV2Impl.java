package com.code.refactoring.重构demo.ifelse重构.订单业务.service.impl;

import com.code.refactoring.重构demo.策略模式重构.handler.OrderHandler;
import com.code.refactoring.重构demo.策略模式重构.handler.OrderHandlerContext;
import com.code.refactoring.重构demo.策略模式重构.model.Order;
import com.code.refactoring.重构demo.策略模式重构.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:06
 */
@Service("orderServiceV2")
public class OrderServiceV2Impl implements OrderService {

    @Autowired
    private OrderHandlerContext orderHandlerContext;

    /**
     * 利用策略模式，具体的订单类型有看具体的策略来执行
     * @param order 订单实体
     * @return
     */
    @Override
    public String handle(Order order) {
        String orderType = order.getType();
        OrderHandler handler = orderHandlerContext.getOrderHandlerInstance(orderType);

        return handler.handleOrder(order);
    }
}
