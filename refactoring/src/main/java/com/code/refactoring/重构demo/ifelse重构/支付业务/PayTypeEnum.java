package com.code.refactoring.重构demo.ifelse重构.支付业务;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wangxi created on 2020/7/5 10:38
 * @version v1.0
 */
public enum PayTypeEnum {

    ALIPAY(1, "阿里支付"),
    WEIXIN(2, "微信支付"),
    LIANLIAN(3, "其他"),

    ;
    private final Integer code;
    private final String name;

    PayTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Optional<PayTypeEnum> valueOfCode(Integer code) {
        return EnumSet.allOf(PayTypeEnum.class).stream()
                .filter(v -> Objects.equals(v.getCode(), code))
                .findFirst();
    }
}