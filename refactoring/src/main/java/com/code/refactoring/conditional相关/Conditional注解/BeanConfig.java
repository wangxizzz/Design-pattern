package com.code.refactoring.conditional相关.Conditional注解;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxi03 created on 2020/10/27 2:40 PM
 * @version v1.0
 */
@Configuration
public class BeanConfig {
//    @Bean(name = "bill")
//    public Person person1(){
//        return new Person("Bill Gates",62);
//    }
//
//    @Bean("linus")
//    public Person person2(){
//        return new Person("Linus",48);
//    }


    /** 增加conditional的条件来注入对应的 bean  **/

    //只有一个类时，大括号可以省略
    //如果WindowsCondition的实现方法返回true，则注入这个bean
    @Conditional({WindowsCondition.class})
    @Bean(name = "bill")
    public Person person1(){
        return new Person("Bill Gates",62);
    }

    //如果LinuxCondition的实现方法返回true，则注入这个bean
    @Conditional({MacOSCondition.class})
    @Bean("macOS")
    public Person person2(){
        return new Person("MaxOS",48);
    }
}
