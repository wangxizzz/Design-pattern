package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.分布式应用;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;


public class Recipes_Barrier {

    //使用Curator实现分布式Barrier, 主线程参与释放barrier

    static String barrier_path = "/curator_recipes_barrier_path";
    static DistributedBarrier barrier;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        CuratorFramework client = CuratorFrameworkFactory.builder()
                                .connectString("localhost:2181")
                                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
                        client.start();
                        barrier = new DistributedBarrier(client, barrier_path);
                        System.out.println(Thread.currentThread().getName() + "号barrier设置");
                        // 设置barrier
                        barrier.setBarrier();
                        // 等待barrier释放，然后向下执行
                        barrier.waitOnBarrier();
                        System.err.println("启动...");
                    } catch (Exception e) {
                    }
                }
            }).start();
        }
        Thread.sleep(3000);
        // 释放barrier，使阻塞的线程可以向下执行。由主线程触发释放Barrier
        barrier.removeBarrier();
    }
}