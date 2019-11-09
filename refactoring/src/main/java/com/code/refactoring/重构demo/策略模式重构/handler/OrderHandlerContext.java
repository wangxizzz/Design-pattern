package com.code.refactoring.重构demo.策略模式重构.handler;


import com.code.refactoring.重构demo.策略模式重构.util.BeanTools;

import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:08
 * 由OrderHandlerProcessor负责初始化orderHandlerMap，并注册OrderHandlerContext
 */
public class OrderHandlerContext {
    private Map<String, Class> orderHandlerMap;

    public OrderHandlerContext(Map<String, Class> orderHandlerMap) {
        this.orderHandlerMap = orderHandlerMap;
    }

    public AbstractOrderHandler getOrderHandlerInstance(String orderType) {
        Class clazz = orderHandlerMap.get(orderType);
        if (clazz == null) {
            throw new IllegalArgumentException("输入的orderType找不到" + orderType);
        }
        return (AbstractOrderHandler) BeanTools.getBean(clazz);
    }
}
