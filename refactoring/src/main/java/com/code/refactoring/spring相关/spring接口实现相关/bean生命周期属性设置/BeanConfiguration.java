package com.code.refactoring.spring相关.spring接口实现相关.bean生命周期属性设置;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangxi
 * @Time 2019/11/9 22:31
 */
@Configuration
public class BeanConfiguration {

    @Bean(initMethod = "init01", destroyMethod = "destroy")
    public MyBean myBean() {
        return new MyBean();
    }
}
