package com.code.refactoring.redis相关.redisson操作;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangxi03 created on 2020/12/28 2:08 下午
 * @version v1.0
 */
@Service
public class RedisDelayedQueue {
    /**
     * 任务回调监听
     *
     * @param <T>
     */
    public abstract static class TaskEventListener<T> {
        /**
         * 执行方法
         *
         * @param t
         */
        public abstract void invoke(T t);
    }

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 添加队列
     *
     * @param t        DTO传输类
     * @param delay    时间数量
     * @param timeUnit 时间单位
     * @param <T>      泛型
     */
    public <T> void addQueue(T t, long delay, TimeUnit timeUnit) {
        // 这里使用了两个queue，对delayedQueue的offer操作是直接进入delayedQueue，
        // 但是delay是作用在目标队列上，这里就是RBlockingQueue
        RBlockingQueue<T> destinationQueue = redissonClient.getBlockingQueue(t.getClass().getName());
        RDelayedQueue<T> delayedQueue = redissonClient.getDelayedQueue(destinationQueue);
        delayedQueue.offer(t, delay, timeUnit);
        delayedQueue.destroy();
    }

    /**
     * 获取队列
     *
     * @param zClass            DTO泛型
     * @param taskEventListener 任务回调监听
     * @param <T>               泛型
     * @return
     */
    public <T> void getQueue(Class zClass, TaskEventListener taskEventListener) {
        RBlockingQueue<T> blockingFairQueue = redissonClient.getBlockingQueue(zClass.getName());
        //由于此线程需要常驻，可以新建线程，不用交给线程池管理
        ((Runnable) () -> {
            while (true) {
                try {
                    T t = blockingFairQueue.take();
                    taskEventListener.invoke(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }
}
