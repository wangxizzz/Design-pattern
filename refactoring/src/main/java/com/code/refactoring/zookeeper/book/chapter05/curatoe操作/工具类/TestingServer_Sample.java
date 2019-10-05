package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.工具类;

import java.io.File;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

public class TestingServer_Sample {
    /**
     * TestingServer工具类提供了 允许开发人员非常方便的启动一个标准的zk服务器，用于测试
     */
    static String path = "/zookeeper";

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer(2181,
                new File("/home/admin/zk-book-data"));  // 定义zk存储数据路径

        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(server.getConnectString())
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        client.start();
        System.out.println(client.getChildren().forPath(path));
        server.close();
    }
}