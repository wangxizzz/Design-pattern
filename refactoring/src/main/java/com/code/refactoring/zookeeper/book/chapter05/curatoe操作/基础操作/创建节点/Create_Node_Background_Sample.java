package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.基础操作.创建节点;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//使用Curator的异步接口
public class Create_Node_Background_Sample {

    static String path = "/zk-book";

    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();
    static CountDownLatch semaphore = new CountDownLatch(2);
    static ExecutorService tp = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception {
        client.start();
        System.out.println("Main thread: " + Thread.currentThread().getName());
        // 此处传入了自定义的Executor
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    // client 当前客户端实例
                    // event  服务端事件
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        System.out.println("event[code: " + event.getResultCode() + ", type: " + event.getType() + "]");
                        System.out.println("Thread of processResult: " + Thread.currentThread().getName());
                        semaphore.countDown();
                    }
                }, tp).forPath(path, "init".getBytes());
        // 此处没有传入自定义的Executor
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        System.out.println("event[code: " + event.getResultCode() + ", type: " + event.getType() + "]");
                        System.out.println("Thread of processResult: " + Thread.currentThread().getName());
                        semaphore.countDown();
                    }
                }).forPath(path, "init".getBytes());

        semaphore.await();
        tp.shutdown();
    }
}