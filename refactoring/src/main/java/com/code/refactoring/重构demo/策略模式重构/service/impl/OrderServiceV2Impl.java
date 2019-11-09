package com.code.refactoring.重构demo.策略模式重构.service.impl;

import com.code.refactoring.重构demo.策略模式重构.handler.AbstractOrderHandler;
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

    @Override
    public String handle(Order order) {
        String orderType = order.getType();
        AbstractOrderHandler handler = orderHandlerContext.getOrderHandlerInstance(orderType);

        return handler.handleOrder(order);
    }
}
