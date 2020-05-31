package com.code.refactoring.spring相关.cache;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/10/20 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {
    @Resource
    private CityService cityService;

    @Test
    public void test01() throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(cityService.getProvince("北京"));
        System.out.println("查库时间为：" + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        System.out.println(cityService.getProvince("北京"));

        System.out.println("走缓存时间为：" + (System.currentTimeMillis() - start2));

        Thread.sleep(3000);

        System.out.println(cityService.getProvince("北京"));
    }
}