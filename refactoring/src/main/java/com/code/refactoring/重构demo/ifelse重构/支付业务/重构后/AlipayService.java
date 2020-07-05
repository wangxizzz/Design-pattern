package com.code.refactoring.重构demo.ifelse重构.支付业务.重构后;

import com.code.refactoring.重构demo.ifelse重构.支付业务.PayRequestType;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayResponse;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayTypeEnum;
import org.springframework.stereotype.Service;

/**
 * @author wangxi created on 2020/7/5 10:47
 * @version v1.0
 */
@Service
public class AlipayService extends AbstractPay {
    @Override
    public PayResponse pay(PayRequestType payRequestType) {
        return new PayResponse("ali支付");
    }

    @Override
    public PayTypeEnum getPayTypeEnum() {
        return PayTypeEnum.ALIPAY;
    }
}
