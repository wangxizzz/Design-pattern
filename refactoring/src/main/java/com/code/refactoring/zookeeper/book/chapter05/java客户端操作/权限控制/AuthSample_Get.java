package com.code.refactoring.zookeeper.book.chapter05.java客户端操作.权限控制;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

//使用无权限信息的ZooKeeper会话访问含权限信息的数据节点
public class AuthSample_Get {

    final static String PATH = "/zk-book-auth_test";

    public static void main(String[] args) throws Exception {

        ZooKeeper zookeeper1 = new ZooKeeper("localhost:2181",
                5000, null);
        // 在创建客户端时，增加权限的控制
        zookeeper1.addAuthInfo("digest", "foo:true".getBytes());
        zookeeper1.create(PATH, "init".getBytes(),
                Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);

        // zookeeper2没有zookeeper1的权限信息
        ZooKeeper zookeeper2 = new ZooKeeper("localhost:2181",
                50000, null);
        zookeeper2.getData(PATH, false, null);
    }
}