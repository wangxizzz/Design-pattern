package com.code.refactoring.重构demo.策略模式重构.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author wangxi
 * @Time 2019/11/9 15:01
 * 订单类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 订单类型
     * 1：普通订单；
     * 2：团购订单；
     * 3：促销订单；
     */
    private String type;
}
