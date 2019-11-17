package com.code.refactoring.限流相关.分布式限流;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.IntegerCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 利用redisson的限流
 * 本质是1s 来了请求数
 */
@Component
@Slf4j
public class RedisRateLimit implements RateLimit {
    // 为了保证系统启动不报错，因为redis不会每次单测都会启动。所以先注释掉
//    @Autowired
//    private RedissonClient redissonClient;

    @Override
    public boolean checkLimit(String key, int limitCount) throws RateLimitException {
//        try {
//            RMapCache<String, Integer> msgRateLimit = redissonClient.getMapCache(key, IntegerCodec.INSTANCE);
//            msgRateLimit.putIfAbsent(key, 0, 1L, TimeUnit.SECONDS);
//            // 原子相加
//            Integer count = msgRateLimit.addAndGet(key, 1);
//            if (count == null) {
//                throw new RateLimitException("限流检查异常 获取count为null ,key:" + key + " limitCount:" + limitCount);
//            }
//            return count <= limitCount;
//        } catch (Exception e) {
//            throw new RateLimitException("限流检查异常,key:" + key + " limitCount:" + limitCount, e);
//        }
        return false;
    }
}
