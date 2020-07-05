package com.code.refactoring.重构demo.ifelse重构.支付业务.重构后;

import com.code.refactoring.BaseTest;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayRequestType;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayResponse;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayTypeEnum;
import org.junit.Test;

import javax.annotation.Resource;


/**
 * @author wangxi created on 2020/7/5 11:26
 * @version v1.0
 */

public class PayService2Test extends BaseTest {

    @Resource
    private PayService2 payService2;

    @Test
    public void payTest() {
        PayRequestType payRequestType = new PayRequestType();
        payRequestType.setPayType(PayTypeEnum.WEIXIN.getCode());

        PayResponse payResponse = payService2.pay(payRequestType);

        System.out.println(payResponse);
    }
}