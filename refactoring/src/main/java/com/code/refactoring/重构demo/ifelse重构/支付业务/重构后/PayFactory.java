package com.code.refactoring.重构demo.ifelse重构.支付业务.重构后;

import com.code.refactoring.重构demo.ifelse重构.支付业务.PayTypeEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangxi created on 2020/7/5 11:00
 * @version v1.0
 */
public final class PayFactory {
    private PayFactory(){}

    public static Map<PayTypeEnum, Pay> payTypeEnumMap = new ConcurrentHashMap<>();

    static {
        Map<String, Pay> beansOfType = ApplicationContextHelper.getBeansOfType(Pay.class);
        beansOfType.forEach((beanName, payObject) -> {
            payTypeEnumMap.put(payObject.getPayTypeEnum(), payObject);
        });
    }

    public static Pay getPay(PayTypeEnum payTypeEnum) {
        return payTypeEnumMap.get(payTypeEnum);
    }
}
