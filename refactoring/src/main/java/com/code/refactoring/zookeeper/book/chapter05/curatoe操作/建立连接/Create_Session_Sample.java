package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.建立连接;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

//使用curator来创建一个ZooKeeper客户端
public class Create_Session_Sample {
    public static void main(String[] args) throws Exception{
        // 休眠一会再重试
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,
                3);
        CuratorFramework client =
        CuratorFrameworkFactory.newClient("localhost:2181",
        		5000,
        		3000,
        		retryPolicy);
        client.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}