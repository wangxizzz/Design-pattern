package com.code.refactoring.限流相关.分布式限流;

/**
 *
 */
public interface RateLimit {
    /**
     * 限流  时间单位 1s
     * @param key  限流key
     * @param limitCount 最大qps
     * @return true:ok false:超过qps
     * @throws RateLimitException 限流异常
     */
    boolean checkLimit(String key, int limitCount) throws RateLimitException;
}
