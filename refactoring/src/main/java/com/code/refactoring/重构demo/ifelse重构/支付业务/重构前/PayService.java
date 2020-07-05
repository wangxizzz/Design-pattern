package com.code.refactoring.重构demo.ifelse重构.支付业务.重构前;

import com.code.refactoring.重构demo.ifelse重构.支付业务.PayRequestType;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayResponse;
import com.code.refactoring.重构demo.ifelse重构.支付业务.PayTypeEnum;

/**
 * @author wangxi created on 2020/7/5 10:34
 * @version v1.0
 */
public class PayService {
    // 注入Bean

    AlipayService alipayService = new AlipayService();
    WeixinPayService weixinPayService = new WeixinPayService();
    LianlianPayService lianlianPayService = new LianlianPayService();

    /**
     * if else 中有相同的行为，并且是通过一个变量为区分时，则可以抽象
     */
    public PayResponse pay(PayRequestType payRequestType) {
        PayTypeEnum payType = PayTypeEnum.valueOfCode(payRequestType.getPayType()).orElseThrow(IllegalArgumentException::new);
        if (payType == PayTypeEnum.ALIPAY) {
            return alipayService.pay(payRequestType);
        } else if (payType == PayTypeEnum.WEIXIN) {
            return weixinPayService.pay(payRequestType);
        } else if (payType == PayTypeEnum.LIANLIAN) {
            return lianlianPayService.pay(payRequestType);
        }
        // 其他支付方式
        return null;
    }

    public class AlipayService {
        PayResponse pay(PayRequestType payRequestType) {
            return null;
        }
    }

    public class WeixinPayService {
        PayResponse pay(PayRequestType payRequestType) {
            return null;
        }
    }

    public class LianlianPayService {
        PayResponse pay(PayRequestType payRequestType) {
            return null;
        }
    }
}
