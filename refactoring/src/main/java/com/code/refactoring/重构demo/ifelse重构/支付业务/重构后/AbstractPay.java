package com.code.refactoring.重构demo.ifelse重构.支付业务.重构后;

import com.code.refactoring.重构demo.ifelse重构.支付业务.PayRequestType;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayResponse;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayTypeEnum;

/**
 * @author wangxi created on 2020/7/5 15:39
 * @version v1.0
 */
public abstract class AbstractPay implements Pay {
    @Override
    public PayResponse pay(PayRequestType payRequestType) {
        return null;
    }

    @Override
    public PayTypeEnum getPayTypeEnum() {
        return null;
    }
}
