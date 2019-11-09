package com.code.refactoring.重构demo.策略模式重构.handler.biz;

import com.code.refactoring.重构demo.策略模式重构.handler.AbstractOrderHandler;
import com.code.refactoring.重构demo.策略模式重构.handler.HandlerType;
import com.code.refactoring.重构demo.策略模式重构.model.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:16
 */
@Component
@HandlerType("3")
public class PromoteOrderHandler extends AbstractOrderHandler {
    @Override
    public String handleOrder(Order order) {
        return "处理促销订单";
    }
}
