package com.code.refactoring.spring相关.spring单例多例相关;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/11/10 10:45
 * 测试见测试类
 */
@Component
public class ScopeBeanService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void say(boolean flag) {
        CommonBean commonBean;
        if (flag) {
            commonBean = applicationContext.getBean(SingletonBean.class, "单例");
            System.out.println(commonBean);
        } else {
            commonBean = applicationContext.getBean(PrototypeBean.class, "多例");
            System.out.println(commonBean);
        }
        commonBean.say();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
