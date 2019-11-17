package com.code.refactoring.spring相关.prime注解相关;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @Author wangxi
 * @Time 2019/11/17 14:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ColorServiceTest {
    @Resource
    private ExecutorService personPool;
    @Resource
    private ExecutorService animalPool;
    @Resource
    private ExecutorService unKnowPool;

    @Test
    public void test() {
        System.out.println(((ThreadPoolExecutor)personPool).getCorePoolSize());
        System.out.println(((ThreadPoolExecutor)animalPool).getCorePoolSize());
        System.out.println(((ThreadPoolExecutor)animalPool).getQueue().getClass());


        System.out.println(((ThreadPoolExecutor)unKnowPool).getQueue().getClass());


    }

}