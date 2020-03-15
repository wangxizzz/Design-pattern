package com.code.refactoring.spring相关.抽象类相关;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2020/3/15 21:46
 *
 * 明确一点：抽象方法是没有构造函数的，因此在Spring容器启动时，是不能实例化抽象类对象的,因为底层仍然调用的是构造函数。
 * 因此，如果在抽象类上 打上@Component 注解，在真正使用时，就会报错。
 *
 * 如果抽象类实现了Spring的扩展接口，那么肯定会有子类继承了 这个抽象类，并且这个子类是Spring容器的Bean.并且真正的处理逻辑都在子类
 */
public abstract class AbstractClass01 implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;
    private String beanName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("=====================加载抽象类的applicationContext，真正的实现子类是" + this.getClass().getSimpleName());
        this.applicationContext = applicationContext;
    }

    public TestAbstractClassBean getTestAbstractClassBean() {
        return applicationContext.getBean("testAbstractClassBean", TestAbstractClassBean.class);
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("当前beanName = " + beanName);
        this.beanName = beanName;
    }
}
