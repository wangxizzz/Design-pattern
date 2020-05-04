package com.code.refactoring.redis相关.redisTemplate操作;

import com.code.refactoring.common.JsonUtil;
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

    // 测试普通的存储、获取值
    @Test
    public void test01() {
        /**
         * 下面两种方式都可以把对象放入redis，但是推荐使用stringRedisTemplate，先格式化为json，然后再放到redis
         */
        RedisBean bean = new RedisBean("wangxiuqwe", 1);
        redisTemplateUtil.setObject("object1", bean);
        System.out.println(((RedisBean)redisTemplateUtil.getObject("object1")).getAge());

        // 把对象先格式化为String,然后利用stringRedisTemplate设置到redis
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