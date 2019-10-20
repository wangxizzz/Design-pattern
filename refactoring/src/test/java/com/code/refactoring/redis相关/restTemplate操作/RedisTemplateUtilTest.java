package com.code.refactoring.redis相关.restTemplate操作;

import com.code.refactoring.common.JsonUtil;
import com.code.refactoring.redis相关.RedisBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @Author wangxi
 * @Time 2019/10/20 13:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateUtilTest {

    @Resource
    private RedisTemplateUtil redisTemplateUtil;

    // 测试普通的存储、获取值
    @Test
    public void test01() {
        RedisBean bean = new RedisBean("wangxiuqwe", 1);
        redisTemplateUtil.set("aabb", JsonUtil.toJson(bean));
        String val = redisTemplateUtil.get("aabb");
        System.out.println(val);
        System.out.println(JsonUtil.fromJson(val, RedisBean.class));
    }

    // 测试 hash
    @Test
    public void test02() {

    }
}