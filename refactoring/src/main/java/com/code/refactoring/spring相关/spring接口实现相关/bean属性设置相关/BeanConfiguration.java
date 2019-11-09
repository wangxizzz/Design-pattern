package com.code.refactoring.spring相关.spring接口实现相关.bean属性设置相关;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangxi
 * @Time 2019/11/9 22:31
 */
@Configuration
public class BeanConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean() {
        return new MyBean();
    }
}
