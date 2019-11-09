package com.code.refactoring.spring相关.spring接口实现相关.bean属性设置相关;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Author wangxi
 * @Time 2019/11/9 22:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBeanTest {

    @Resource
    private MyBean myBean;

    @Test
    public void test01() {
        System.out.println(myBean.hashCode());
    }
}