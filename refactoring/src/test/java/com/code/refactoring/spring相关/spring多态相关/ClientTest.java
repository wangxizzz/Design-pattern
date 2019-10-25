package com.code.refactoring.spring相关.spring多态相关;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

    @Resource
    private Client client;

    @Test
    public void test01() {
        client.fun01(true);
    }

}