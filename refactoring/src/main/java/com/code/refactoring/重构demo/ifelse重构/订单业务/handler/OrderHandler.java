package com.code.refactoring.重构demo.ifelse重构.订单业务.handler;

import com.code.refactoring.重构demo.策略模式重构.model.Order;

/**
 * @author wangxi created on 2020/7/5 15:53
 * @version v1.0
 */
public interface OrderHandler {
    String handleOrder(Order order);

    String getOrderType();
}
