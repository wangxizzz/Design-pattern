package com.code.refactoring.redis相关.分布式锁;

import redis.clients.jedis.Jedis;

/**
 * @Author wangxi
 * @Time 2019/10/20 23:27
 *
 * 错误的加锁与解锁方式，会有并发的问题
 * 为什么会有并发的问题？
 * -- 因为锁的key,value存储在 共享缓存redis中。多个线程可以同时操作他们。
 */
public class ErrorLock {
    /**
     * setnx()方法作用就是SET IF NOT EXIST，expire()方法就是给锁加一个过期时间。
     *
     * 乍一看好像和前面的set()方法结果一样，然而由于这是两条Redis命令，不具有原子性，
     * 如果程序在执行完setnx()之后突然崩溃，导致锁没有设置过期时间。那么将会发生死锁。
     *
     * 网上之所以有人这样实现，是因为低版本的jedis并不支持多参数的set()方法。
     */
    public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {

        Long result = jedis.setnx(lockKey, requestId);
        if (result == 1) {
            // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
            jedis.expire(lockKey, expireTime);
        }

    }

    /**
     * 最常见的解锁代码就是直接使用jedis.del()方法删除锁，
     * 这种不先判断锁的拥有者而直接解锁的方式，会导致任何客户端都可以随时进行解锁，即使这把锁不是它的。
     * 场景如下：
     * 这时又出现一个问题，问题出现的步骤如下
     *
     * 1、客户端A获取锁成功，过期时间30秒。
     * 2、客户端A在某个操作上阻塞了50秒(设置锁成功返回给Client出现网络延迟、系统GC、系统内存发生缺页中断等)。
     * 3、30秒时间到了，锁自动释放了。
     * 4、客户端B获取到了对应同一个资源的锁。
     * 5、客户端A从阻塞中恢复过来，释放掉了客户端B持有的锁。
     */
    public static void wrongReleaseLock1(Jedis jedis, String lockKey) {
        jedis.del(lockKey);
    }

    /**
     *
     * 这种解锁代码乍一看也是没问题，甚至我之前也差点这样实现，与正确姿势差不多，唯一区别的是分成两条命令去执行
     * 场景如下：比如客户端A加锁，一段时间之后客户端A解锁，在执行jedis.del()之前，
     * 锁突然过期了(可能阻塞在设置锁成功返回给Client出现网络延迟或GC或缺页中断)，
     * 此时客户端B尝试加锁成功，
     * 然后客户端A再执行del()方法，则将客户端B的锁给解除了
     */
    public static void wrongReleaseLock2(Jedis jedis, String lockKey, String requestId) {

        // 判断加锁与解锁是不是同一个客户端
        if (requestId.equals(jedis.get(lockKey))) {
            // 若在此时，这把锁突然不是这个客户端的，则会误解锁
            jedis.del(lockKey);
        }

    }
}
