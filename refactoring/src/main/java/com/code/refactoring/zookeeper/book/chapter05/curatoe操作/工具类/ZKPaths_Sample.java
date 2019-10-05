package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.工具类;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.curator.utils.ZKPaths.PathAndNode;
import org.apache.zookeeper.ZooKeeper;

public class ZKPaths_Sample {
    /**
     * ZKPaths 提供了简单的API操作Znode的路径
     */
    static String path = "/curator_zkpath_sample";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        ZooKeeper zookeeper = client.getZookeeperClient().getZooKeeper();

        System.out.println(ZKPaths.fixForNamespace(path, "sub"));
        System.out.println(ZKPaths.makePath(path, "sub"));
        System.out.println(ZKPaths.getNodeFromPath("/curator_zkpath_sample/sub1"));

        PathAndNode pn = ZKPaths.getPathAndNode("/curator_zkpath_sample/sub1");
        System.out.println(pn.getPath());
        System.out.println(pn.getNode());

        String dir1 = path + "/child1";
        String dir2 = path + "/child2";
        ZKPaths.mkdirs(zookeeper, dir1);
        ZKPaths.mkdirs(zookeeper, dir2);
        System.out.println(ZKPaths.getSortedChildren(zookeeper, path));

        ZKPaths.deleteChildren(client.getZookeeperClient().getZooKeeper(), path, true);
    }
}