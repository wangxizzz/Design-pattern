package com.code.refactoring.spring相关.spring接口实现相关.beanFactoryPostProcessor接口相关.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangxi
 * @Time 2019/11/10 16:02
 */
@Configuration
public class BeanConfig {

    @Bean
    public MyJavaBean myJavaBean() {
        return new MyJavaBean();
    }
}
