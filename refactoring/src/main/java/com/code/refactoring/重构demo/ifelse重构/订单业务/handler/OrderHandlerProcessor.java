package com.code.refactoring.重构demo.ifelse重构.订单业务.handler;

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

    /**
     *
     * @param beanFactory bean工厂
     * @see OrderHandlerContext
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // orderType -> OrderHandler
        Map<String, OrderHandler> orderHandlerMap = new HashMap<>(3);
        // beanName->OrderHandler
        Map<String, OrderHandler> beansOfType = beanFactory.getBeansOfType(OrderHandler.class);
        beansOfType.forEach((beanName, orderHandler) -> {
            orderHandlerMap.put(orderHandler.getOrderType(), orderHandler);
        });
        OrderHandlerContext orderHandlerContext = new OrderHandlerContext(orderHandlerMap);
        // 把orderContext注册到Spring容器中
        beanFactory.registerSingleton(OrderHandlerContext.class.getName(), orderHandlerContext);
    }
}
