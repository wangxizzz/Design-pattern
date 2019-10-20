package com.code.refactoring.redis相关.restTemplate操作;

import com.code.refactoring.redis相关.RedisBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Author wangxi
 * @Time 2019/10/20 13:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateUtilTest {

    @Resource
    private RedisTemplateUtil redisTemplateUtil;

    @Test
    public void test01() {
        redisTemplateUtil.set("aa", );
        Object o = redisTemplateUtil.get("aa");
        System.out.println(o);
    }
}