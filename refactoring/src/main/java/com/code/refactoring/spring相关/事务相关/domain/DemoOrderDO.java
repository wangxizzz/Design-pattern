package com.code.refactoring.spring相关.事务相关.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DemoOrderDO
 * @author: wangxi03
 * @date: 2020/08/02 10:44:23 
 */
@Getter
@Setter
@ToString
@Builder
public class DemoOrderDO implements Serializable {
    /**
     * 自增id
     */
    private Long id;

    private BigDecimal price;

    private String orderNo;

    private Long bookId;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 订单下单人名称
     */
    private String orderUserName;

    private Date createTime;

    private Date updateTime;
}
