package com.code.refactoring.zookeeper.book.chapter05.java客户端操作.节点exist;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

// ZooKeeper API 检测节点是否存在，使用同步(sync)接口。
public class Exist_API_Sync_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static void main(String[] args) throws Exception {

        String path = "/zk-book";
        zk = new ZooKeeper("localhost:2181",
                5000, //
                new Exist_API_Sync_Usage());
        connectedSemaphore.await();
        /**
         * exists()为了检测节点是否存在，返回一个stat对象。另外，如果在调用此方法时，注册了watcher监听，
         * 还可以对节点是否存在进行监听---一旦节点被创建、被删除、或者被更新
         * 都会通知客户端。
         */
        zk.exists(path, true);

        zk.create( path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );

        zk.setData(path, "123".getBytes(), -1);

        zk.create(path + "/c1", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zk.delete(path + "/c1", -1);

        zk.delete(path, -1);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        try {
            if (KeeperState.SyncConnected == event.getState()) {
                if (EventType.None == event.getType() && null == event.getPath()) {
                    connectedSemaphore.countDown();
                } else if (EventType.NodeCreated == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")Created");
                    // 需要重新注册watcher
                    zk.exists(event.getPath(), true);
                } else if (EventType.NodeDeleted == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")Deleted");
                    zk.exists(event.getPath(), true);
                } else if (EventType.NodeDataChanged == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")DataChanged");
                    zk.exists(event.getPath(), true);
                }
                // 子节点的变化不会通知客户端
                else if (EventType.NodeChildrenChanged == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")NodeChildrenChanged");
                    zk.exists(event.getPath(), true);
                }
            }
        } catch (Exception e) {
        }
    }
}