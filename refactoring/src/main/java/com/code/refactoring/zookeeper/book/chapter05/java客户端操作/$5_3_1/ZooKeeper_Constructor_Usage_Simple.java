package com.code.refactoring.zookeeper.book.chapter05.java客户端操作.$5_3_1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

//Chapter: 5.3.1 Java API -> 创建连接 -> 创建一个最基本的ZooKeeper对象实例
public class ZooKeeper_Constructor_Usage_Simple implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    
    public static void main(String[] args) throws Exception{
        
        ZooKeeper zookeeper = new ZooKeeper("localhost:2181",
        									5000, // 客户端与服务端是基于心跳检测的(回话时间)
        									new ZooKeeper_Constructor_Usage_Simple());
        System.out.println(zookeeper.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {

        }
        System.out.println("ZooKeeper session established.");
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event：" + event);
        if (KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}