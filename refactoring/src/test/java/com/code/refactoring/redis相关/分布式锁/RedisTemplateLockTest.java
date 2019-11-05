package com.code.refactoring.redis相关.分布式锁;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author wangxi
 * @Time 2019/11/5 23:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateLockTest {

    @Resource
    private RedisTemplateLock redisTemplateLock;

    /**
     * 测试第一种情况，过期时间到了，锁被释放，后来程序从阻塞中恢复，又释放锁(此时相当于没加锁就释放锁)
     * 就会返回释放锁失败，返回false
     */
    @Test
    public void testLockError01() {
        String lockKey = "lock_redis";
        String requestId = UUID.randomUUID() + Thread.currentThread().getName();
        redisTemplateLock.tryGet(lockKey, requestId, 1000);

        // 休眠5s(利用断点停止模拟)
        boolean result = redisTemplateLock.release(lockKey, requestId);
        System.out.println(result);
    }

    /**
     * 有两个线程Thread1,Thread2.
     * 1
     */
    @Test
    public void testLockError02() throws InterruptedException {
        String lockKey = "lock_redis";
        String requestId = UUID.randomUUID() + Thread.currentThread().getName();
        new Thread(() -> {
            tryGet(lockKey, requestId);
            // 阻塞3s
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            tryGet(lockKey, requestId);

        }).start();

        Thread.currentThread().join();
    }

    private void tryGet(String lockKey, String requestId) {
        try {
            redisTemplateLock.tryGet(lockKey, requestId, 10000);
        } finally {
            boolean result = redisTemplateLock.release(lockKey, requestId);
            System.out.println(result + Thread.currentThread().getName());
        }
    }

    @Test
    public void testCorrectLock() throws InterruptedException {
        String lockKey = "lock_redis";
        new Thread(() -> {
            String requestId = UUID.randomUUID() + Thread.currentThread().getName();
            tryGet(lockKey, requestId);
            // 阻塞3s
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            String requestId = UUID.randomUUID() + Thread.currentThread().getName();
            tryGet(lockKey, requestId);

        }).start();

        Thread.currentThread().join();
    }
}