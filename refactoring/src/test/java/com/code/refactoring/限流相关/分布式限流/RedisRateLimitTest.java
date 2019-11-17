package com.code.refactoring.限流相关.分布式限流;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;


/**
 * @Author wangxi
 * @Time 2019/11/16 21:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRateLimitTest {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss.SSS");
    // 为了保证系统启动不报错，因为redis不会每次单测都会启动。所以先注释掉
//    @Resource
//    private RedisRateLimit redisRateLimit;
//
//
//    @Test
//    public void testRateLimiter() {
//        System.out.println(checkLimit("aaa", 100, 20));
//    }
//
//    public Object checkLimit(String key, int count, int maxCount) {
//        List<Map<String, Object>> result = Lists.newArrayList();
//        for (int i = 0; i < count; i++) {
//            Map<String, Object> temp = Maps.newHashMap();
//            temp.put("i", i);
//            try {
//                boolean b = redisRateLimit.checkLimit(key, maxCount);
//                temp.put("result", b);
//                temp.put("time", TIME_FORMATTER.print(System.currentTimeMillis()));
//            } catch (Exception e) {
//                temp.put("i", i);
//                temp.put("e", e.getMessage());
//                e.printStackTrace();
//            }
//            result.add(temp);
//        }
//        return result;
//    }
}