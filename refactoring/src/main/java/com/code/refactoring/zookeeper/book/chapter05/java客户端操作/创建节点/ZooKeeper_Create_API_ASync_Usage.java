package com.code.refactoring.zookeeper.book.chapter05.java客户端操作.创建节点;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

// ZooKeeper API创建节点，使用异步(async)接口。
public class ZooKeeper_Create_API_ASync_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {

        ZooKeeper zookeeper = new ZooKeeper("localhost:2181",
                5000, //
                new ZooKeeper_Create_API_ASync_Usage());
        ZooKeeper zookeeper2 = new ZooKeeper("localhost:2181",
                5000, //
                new ZooKeeper_Create_API_ASync_Usage());
        connectedSemaphore.await();

        zookeeper.create("/zk-test-ephemeral-", "".getBytes(),
                Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                new IStringCallback(), "I am context.");

        zookeeper.create("/zk-test-ephemeral-", "".getBytes(),
                Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                new IStringCallback(), "I am context.");

        zookeeper.create("/zk-test-ephemeral-", "".getBytes(),
                Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,
                new IStringCallback(), "I am context.");

        zookeeper2.create("/zk-test-ephemeral-", "".getBytes(),
                Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,
                new IStringCallback(), "I am context.");
        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent event) {
        if (KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}

class IStringCallback implements AsyncCallback.StringCallback {
    // 异步创建，create本身并不会抛异常，但是会在resultCode体现，也就是rc
    /**
     * resultCode如下：
     *  0 响应成功
     *  -4 客户端与服务端连接已断开
     *  -110 节点已存在
     *  -112 会话已过期
     */
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("Create path result: [" + rc + ", " + path + ", "
                + ctx + ", real path name: " + name);
    }
}