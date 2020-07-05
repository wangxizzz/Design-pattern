package com.code.refactoring.重构demo.ifelse重构.支付业务;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangxi created on 2020/7/5 10:33
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayResponse {
    private String result;

    @Override
    public String toString() {
        return result;
    }
}
