package com.code.refactoring.重构demo.策略模式重构.handler;

import com.code.refactoring.重构demo.策略模式重构.model.Order;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:08
 */
public abstract class AbstractOrderHandler {
    public abstract String handleOrder(Order order);
}
