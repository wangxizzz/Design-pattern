package com.code.refactoring.spring相关.spring接口实现相关.bean属性设置相关;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author wangxi
 * @Time 2019/11/9 22:36
 */
public class MyBean02 {

    /**
     * 这种方式与bean在xml配置init-method、在@Bean(initMethod = "init") 方式一致
     * 只不过这是用jdk自带的注解。类似于@Resource与@Autowire
     */
    @PostConstruct
    public void init() {
        System.out.println("jdk自带的注解 init() 调用");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jdk自带的注解 destroy() 调用");
    }
}
