package com.code.refactoring.spring相关.spring注入相关;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:14
 */
@Component
public class BeanInvoke {
    @Autowired
    private List<BeanInterface> list;

    @Autowired
    private Map<String, BeanInterface> map;

    /**
     * @Autowired默认为byType的 所以有两个相同类型的bean
     * 如果不使用 @Qualifier指定具体的bean就会抛出异常
     * private BeanInterface beaninterface;
     */
    @Autowired
    @Qualifier("beanImplOne")
    private BeanInterface beaninterface;

    public void say() {
        System.out.println("list...");
        if (null != list && 0 != list.size()) {
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }

        } else {
            System.out.println("List<BeanInterface> list is null !!!!");
        }
        System.out.println();
        System.out.println("map...");
        if (null != map && 0 != map.size()) {
            for (Map.Entry<String, BeanInterface> m : map.entrySet()) {
                System.out.println(m.getKey() + "    " + m.getValue().getClass().getName());
            }
        } else {
            System.out.println("Map<String,BeanInterface> map is null !!!!");

        }
        System.out.println("-------------------------");
        if (null != beaninterface) {
            System.out.println(beaninterface.getClass().getName());
        } else {
            System.out.println("beaninterface is null !!!");
        }
    }
}
