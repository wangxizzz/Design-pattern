package com.code.refactoring.spring相关.spring接口实现相关.beanFactoryPostProcessor接口相关;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * @Author wangxi
 * @Time 2019/11/10 16:01
 * 方便不与其他测试类冲突，先把@Component注释掉
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("******调用BeanFactoryPostProcessor开始");
        //获取到Spring中所有的beanName
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        //循环bean做出自定义的操作
        for (String beanName : beanStr) {
            //System.out.println("bean name:"+beanName);
            if ("myJavaBean".equals(beanName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                System.out.println("修改myJavaBean的remark值");
                // 可以为其添加属性
                beanDefinition.getPropertyValues().add("remark", "修改备注信息");
            }
        }
        System.out.println("******调用BeanFactoryPostProcessor结束");
    }
}
