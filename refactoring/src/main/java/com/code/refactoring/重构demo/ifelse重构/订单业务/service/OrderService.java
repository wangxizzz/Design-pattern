package com.code.refactoring.重构demo.ifelse重构.订单业务.service;

import com.code.refactoring.重构demo.策略模式重构.model.Order;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:02
 */

public interface OrderService {
    /**
     * 根据订单的不同类型作出不同的处理
     *
     * @param order 订单实体
     * @return 为了简单，返回字符串
     */
    String handle(Order order);
}
