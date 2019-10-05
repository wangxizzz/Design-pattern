package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.事件监听;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * NodeCache 用于监听指定zookeeper数据节点本身的变化
 */
public class NodeCache_Sample {

    static String path = "/zk-book/nodecache";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath(path, "init".getBytes());
        final NodeCache cache = new NodeCache(client, path, false);
        // 设置为true,表示第一次启动时，就把节点数据存在NodeCache
        cache.start(true);
        // 监听指定数据节点的变化
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("Node data update, new data: " +
                        new String(cache.getCurrentData().getData()));
            }
        });
        client.setData().forPath(path, "u".getBytes());
        Thread.sleep(1000);
        //client.delete().deletingChildrenIfNeeded().forPath(path);
        Thread.sleep(Integer.MAX_VALUE);
    }
}