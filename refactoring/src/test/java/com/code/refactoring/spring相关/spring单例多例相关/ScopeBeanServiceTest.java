package com.code.refactoring.spring相关.spring单例多例相关;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/11/10 10:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScopeBeanServiceTest {
    @Resource
    private ScopeBeanService beanService;

    @Test
    public void sayTest() {
        boolean flag = true;
        beanService.say(flag);
        beanService.say(flag);
    }
}