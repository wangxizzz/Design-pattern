package com.code.refactoring.redis相关.分布式锁;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @Author wangxi
 * @Time 2019/10/20 23:33
 * 由redisTemplate实现的分布式锁
 */
@Slf4j
@Component
public class RedisTemplateLock {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 尝试获取分布式锁,在外面调用此方法是，需要在循环中重试
     *
     * @param lockKey    加锁标识
     * @param requestId  代表加锁的客户端请求标识，那么在客户端在解锁的时候就可以进行校验是否是同一个客户端
     * @param expireTime 毫秒,锁过期时间，需要根据业务判断具体的过期时间
     * @return 获取锁结果
     */
    public boolean tryGet(String lockKey, String requestId, int expireTime) {
        try {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            Boolean setResult = operations.setIfAbsent(lockKey, requestId, Duration.ofMillis(expireTime));
            log.info("【redis distributed lock try get】尝试获取Redis分布式锁，lockKey:{},requestId:{},expireTime:{},尝试加锁结果:{}", lockKey, requestId, expireTime, setResult);
            return BooleanUtils.isTrue(setResult);
        } catch (Exception e) {
            log.error("【redis distributed lock try get】尝试获取Redis分布式锁异常，lockKey:{},requestId:{},expireTime:{},异常：", lockKey, requestId, expireTime, e);
            return false;
        }
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey   加锁标识
     * @param requestId 代表加锁的客户端请求标识
     * @return 释放锁结果
     */
    public boolean release(String lockKey, String requestId) {
        try {
            String releaseLockScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Long executeRes = stringRedisTemplate.execute((RedisCallback<Long>) redisConnection ->
                    redisConnection.eval(releaseLockScript.getBytes(), ReturnType.INTEGER, 1,
                            lockKey.getBytes(), requestId.getBytes()));
            boolean releaseRes = executeRes != null && executeRes == 1L;
            log.info("【redis distributed lock release】释放Redis分布式锁，lockKey:{},requestId:{},释放结果:{}", lockKey, requestId, releaseRes);
            return releaseRes;
        } catch (Exception e) {
            log.error("【redis distributed lock release】释放Redis分布式锁，lockKey:{},requestId:{},异常：", lockKey, requestId, e);
            return false;
        }
    }
}
