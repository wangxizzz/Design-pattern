package com.code.refactoring.spring相关.spring注入相关;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:14
 */
@Component
@Order(2)
public class BeanImplTwo implements BeanInterface{
}
