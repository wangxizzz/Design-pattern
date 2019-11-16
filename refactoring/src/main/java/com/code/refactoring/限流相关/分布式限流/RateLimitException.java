package com.code.refactoring.限流相关.分布式限流;

/**
 * 限流异常
 */
public class RateLimitException extends Exception{
    public RateLimitException(String message) {
        super(message);
    }

    public RateLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
