package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.基础操作.创建节点;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

//使用Curator创建节点
public class Create_Node_Sample {
    static String path = "/zk-book";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();
    public static void main(String[] args) throws Exception {
        client.start();
        client.create()
              .creatingParentsIfNeeded()
                .withProtection()   // 节点存在仍然可以创建成功
              .withMode(CreateMode.PERSISTENT)
              .forPath(path, "init".getBytes());
    }
}