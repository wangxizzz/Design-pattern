package com.code.refactoring.spring相关.spring接口实现相关.beanFactoryPostProcessor接口相关;

import com.code.refactoring.spring相关.spring接口实现相关.beanFactoryPostProcessor接口相关.bean.MyJavaBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Author wangxi
 * @Time 2019/11/10 16:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBeanFactoryPostProcessorTest {

    @Resource
    private MyJavaBean myJavaBean;

    @Test
    public void test01() {
        System.out.println(myJavaBean);
    }
}