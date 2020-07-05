package com.code.refactoring.重构demo.ifelse重构.订单业务.model;

/**
 * @Author wangxi
 * @Time 2019/11/9 20:11
 */
public enum  OrderEnum {
    NORMAL_ORDER("1", "普通订单"),
    GROUP_ORDER("2", "团购订单"),
    PROMOTE_ORDER("3", "促销订单");


    private String orderType;
    private String desc;

    OrderEnum(String orderType, String desc) {
        this.orderType = orderType;
        this.desc = desc;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
