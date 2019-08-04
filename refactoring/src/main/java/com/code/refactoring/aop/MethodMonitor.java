package com.code.refactoring.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wxi.wang
 * <p> 统计方法的运行时间
 * 2019/8/3 22:07
 * Decription:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodMonitor {
    String value() default "";    // 用于区分方法监控的名字
}
