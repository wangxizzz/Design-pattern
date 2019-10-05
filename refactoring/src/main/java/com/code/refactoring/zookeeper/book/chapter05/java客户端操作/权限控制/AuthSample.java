package com.code.refactoring.zookeeper.book.chapter05.java客户端操作.权限控制;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
//使用含权限信息的ZooKeeper会话创建数据节点
public class AuthSample {

    final static String PATH = "/zk-book-auth_test";
    public static void main(String[] args) throws Exception {

        ZooKeeper zookeeper = new ZooKeeper("localhost:2181",50000,null);
        // 采用digest方式做控制，foo:true 类似于 username : password
        zookeeper.addAuthInfo("digest", "foo:true".getBytes());
        // 用已经有权限控制的客户端来创建节点，那么节点就会有权限信息
        zookeeper.create( PATH, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL );
        Thread.sleep( Integer.MAX_VALUE );
    }
}