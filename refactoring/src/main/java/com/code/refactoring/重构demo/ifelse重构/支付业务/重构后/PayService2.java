package com.code.refactoring.重构demo.ifelse重构.支付业务.重构后;

import com.code.refactoring.重构demo.ifelse重构.支付业务.PayRequestType;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayResponse;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author wangxi created on 2020/7/5 10:56
 * @version v1.0
 */
@Component
public class PayService2 {
    // 注入Bean

    /**
     * if else 中有相同的行为，并且是通过一个变量为区分时，则可以抽象
     */
    public PayResponse pay(PayRequestType payRequestType) {
        PayTypeEnum payType = PayTypeEnum.valueOfCode(payRequestType.getPayType()).orElseThrow(IllegalArgumentException::new);
        return PayFactory.getPay(payType).pay(payRequestType);
    }
}
