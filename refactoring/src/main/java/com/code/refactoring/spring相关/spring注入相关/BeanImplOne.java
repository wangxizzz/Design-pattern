package com.code.refactoring.spring相关.spring注入相关;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:13
 */
@Component
@Order(1)    // 值越小，优先级越高
public class BeanImplOne implements BeanInterface{
}
