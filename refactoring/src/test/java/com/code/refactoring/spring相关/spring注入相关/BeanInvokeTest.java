package com.code.refactoring.spring相关.spring注入相关;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanInvokeTest {

    @Resource
    private BeanInvoke beanInvoke;

    @Test
    public void test01() {
        beanInvoke.say();
    }
}