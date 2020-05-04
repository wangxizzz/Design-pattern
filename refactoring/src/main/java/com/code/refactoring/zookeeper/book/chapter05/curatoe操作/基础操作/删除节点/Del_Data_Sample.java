package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.基础操作.删除节点;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

//使用Curator删除节点
public class Del_Data_Sample {

    static String path = "/zk-book/aa";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();
    public static void main(String[] args) throws Exception {
    	client.start();
//        client.create()
//              .creatingParentsIfNeeded()
//              .withMode(CreateMode.PERSISTENT)
//              .forPath(path, "init".getBytes());
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath(path);
        client.delete().deletingChildrenIfNeeded()
                       .withVersion(stat.getVersion()).forPath(path);
    }
}