package com.code.refactoring.限流相关.分布式限流;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
//            // 固定限流，过了时间周期后会导致 流量重置。
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
