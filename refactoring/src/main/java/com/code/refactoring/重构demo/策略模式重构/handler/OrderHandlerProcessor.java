package com.code.refactoring.重构demo.策略模式重构.handler;

import com.code.refactoring.重构demo.策略模式重构.util.HandlerScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/11/9 15:20
 * 实现BeanFactoryPostProcessor，在spring处理bean前，将自定义的bean注册到容器中。
 */
@Component
public class OrderHandlerProcessor implements BeanFactoryPostProcessor {
    public static final String HANDLER_PACKAGE = "com.code.refactoring.重构demo.策略模式重构.handler.biz";

    /**
     * 扫描@HandlerType，初始化HandlerContext，将其注册到spring容器
     *
     * @param beanFactory bean工厂
     * @see HandlerType
     * @see OrderHandlerContext
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> orderHandlerMap = new HashMap<>(3);
        HandlerScanner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            String orderType = clazz.getAnnotation(HandlerType.class).value();
            orderHandlerMap.put(orderType, clazz);
        });
        OrderHandlerContext orderHandlerContext = new OrderHandlerContext(orderHandlerMap);
        // 把orderContext注册到Spring容器中
        beanFactory.registerSingleton(OrderHandlerContext.class.getName(), orderHandlerContext);
    }
}
