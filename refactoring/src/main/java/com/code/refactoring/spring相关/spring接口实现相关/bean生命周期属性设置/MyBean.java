package com.code.refactoring.spring相关.spring接口实现相关.bean生命周期属性设置;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/11/9 21:18
 * 用做测试Bean，观察该Bean初始化过程中上面4个方法执行的先后顺序和内容
 *
 * Spring总是先处理bean定义的InitializingBean，然后才处理init-method。
 * 如果在Spring处理InitializingBean时出错，那么Spring将直接抛出异常，不会再继续处理init-method。
 *
 * 如果一个bean被定义为非单例的，每创建一次就会被初始化一次
 * 那么afterPropertiesSet和init-method在bean的每一个实例被创建时都会执行。
 * 单例 bean的afterPropertiesSet和init-method只在bean第一次被实例时调用一次。
 * 大多数情况下 afterPropertiesSet和init-method都应用在单例的bean上。
 */
public class MyBean implements InitializingBean {

    @Resource
    private Component01 component01;

    /**
     * 初始化一个对象（bean）后立即初始化（加载）一些数据
     * Spring要求init-method是一个无参数的方法，如果init-method指定的方法中有参数，
     * 那么Spring将会抛出java.lang.NoSuchMethodException
     *  
     * init-method指定的方法可以是public、protected以及private的，并且方法也可以是final的。
     * init-method 消除了对Spring的依赖，但是执行此方法是利用反射进行的
     */
    public void init01() {
        // 先填充MyBean的属性
        System.out.println(component01);
        System.out.println("MyBean init01() is called");
    }

    @PostConstruct
    public void init02() {
        System.out.println(component01);
        System.out.println("MyBean init02() is called");
    }

    /**
     * 销毁一个Bean对象之前进行垃圾回收
     */
    public void destroy() {
        System.out.println("MyBean destroy() is called");
    }

    /**
     * 此方法对Spring的依赖比较重，但是性能比init-method好
     */
    @Override
    public void afterPropertiesSet() {
        System.out.println("MyBean afterPropertiesSet is called");
    }
}
