package com.code.refactoring.zookeeper.book.chapter05.java客户端操作.$5_3_4;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

// ZooKeeper API 获取节点数据内容，使用同步(sync)接口。
public class GetData_API_Sync_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {

        String path = "/zk-book";
        zk = new ZooKeeper("localhost:2181",
                5000, //
                new GetData_API_Sync_Usage());
        connectedSemaphore.await();
        zk.create(path, "452353".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        // 获取节点数据并且注册一个默认的监听(由类实现的监听process)
        System.out.println(new String(zk.getData(path, true, stat)));
        System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());

        zk.setData(path, "123".getBytes(), stat.getVersion());

        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent event) {
        if (KeeperState.SyncConnected == event.getState()) {
            if (EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (event.getType() == EventType.NodeDataChanged) {
                try {
                    System.out.println(new String(zk.getData(event.getPath(), true, stat)));
                    System.out.println(stat.getCzxid() + "," +
                            stat.getMzxid() + "," +
                            stat.getVersion());
                } catch (Exception e) {
                }
            }
        }
    }
}