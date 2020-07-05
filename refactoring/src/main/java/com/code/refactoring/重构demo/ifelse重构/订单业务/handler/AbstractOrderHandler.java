package com.code.refactoring.重构demo.ifelse重构.订单业务.handler;

import com.code.refactoring.重构demo.策略模式重构.model.Order;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:08
 *
 * 抽象的订单处理类
 */
public abstract class AbstractOrderHandler implements OrderHandler{
    @Override
    public String handleOrder(Order order) {
        return null;
    }

    @Override
    public String getOrderType() {
        return null;
    }
}
