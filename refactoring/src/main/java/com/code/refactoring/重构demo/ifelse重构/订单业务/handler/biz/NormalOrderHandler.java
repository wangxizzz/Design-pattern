package com.code.refactoring.重构demo.ifelse重构.订单业务.handler.biz;

import com.code.refactoring.重构demo.策略模式重构.handler.AbstractOrderHandler;
import com.code.refactoring.重构demo.策略模式重构.model.Order;
import com.code.refactoring.重构demo.策略模式重构.model.OrderEnum;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:15
 * 普通订单handler
 */
@Component
public class NormalOrderHandler extends AbstractOrderHandler {
    @Override
    public String handleOrder(Order order) {
        // 可以添加其他逻辑
        return "处理普通订单";
    }

    @Override
    public String getOrderType() {
        return OrderEnum.NORMAL_ORDER.getOrderType();
    }
}
