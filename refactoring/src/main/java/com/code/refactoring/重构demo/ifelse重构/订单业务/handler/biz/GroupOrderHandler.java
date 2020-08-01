package com.code.refactoring.重构demo.ifelse重构.订单业务.handler.biz;

import com.code.refactoring.重构demo.ifelse重构.订单业务.handler.AbstractOrderHandler;
import com.code.refactoring.重构demo.ifelse重构.订单业务.model.Order;
import com.code.refactoring.重构demo.ifelse重构.订单业务.model.OrderEnum;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:16
 * 团购订单处理器
 */
@Component
public class GroupOrderHandler extends AbstractOrderHandler {
    @Override
    public String handleOrder(Order order) {
        return "处理团购订单";
    }

    @Override
    public String getOrderType() {
        return OrderEnum.GROUP_ORDER.getOrderType();
    }
}
