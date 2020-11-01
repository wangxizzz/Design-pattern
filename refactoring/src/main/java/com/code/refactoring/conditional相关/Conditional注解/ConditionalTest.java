package com.code.refactoring.conditional相关.Conditional注解;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author wangxi03 created on 2020/10/27 2:41 PM
 * @version v1.0
 */
public class ConditionalTest {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(ConditionalBeanConfig.class);

    // 不加任何条件 两个Person实例被注入进容器
    @Test
    public void test1(){
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }


    // 根据当前操作系统来注入Person实例，windows下注入bill，linux下注入linus
    @Test
    public void test2() {
        String osName = applicationContext.getEnvironment().getProperty("os.name");
        System.out.println("当前系统为：" + osName);
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }
}
