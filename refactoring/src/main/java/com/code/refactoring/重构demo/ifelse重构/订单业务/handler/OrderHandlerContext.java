package com.code.refactoring.重构demo.ifelse重构.订单业务.handler;


import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:08
 * 由OrderHandlerProcessor负责初始化orderHandlerMap，并注册OrderHandlerContext
 */
public class OrderHandlerContext {
    private Map<String, OrderHandler> orderHandlerMap;

    public OrderHandlerContext(Map<String, OrderHandler> orderHandlerMap) {
        this.orderHandlerMap = orderHandlerMap;
    }

    public OrderHandler getOrderHandlerInstance(String orderType) {
        return orderHandlerMap.get(orderType);
    }
}
