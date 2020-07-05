package com.code.refactoring.重构demo.ifelse重构.订单业务.service.impl;

import com.code.refactoring.重构demo.策略模式重构.model.Order;
import com.code.refactoring.重构demo.策略模式重构.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:03
 * 重构前的版本
 */
@Service("orderServiceV1")
public class OrderServiceV1Impl implements OrderService {
    /**
     * 存在大量的if - else
     * @param order 订单实体
     * @return
     */
    @Override
    public String handle(Order order) {
        String orderType = order.getType();
        if ("1".equals(orderType)) {
            return "处理普通订单---V1";
        }
        if ("2".equals(orderType)) {
            return "处理团购订单--V1";
        }
        if ("3".equals(orderType)) {
            return "处理促销订单--V1";
        }
        return "";
    }
}
