package com.code.refactoring.zookeeper.book.chapter05.$5_4_1;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

// ZkClient获取子节点列表。
public class Get_Children_Sample {

    public static void main(String[] args) throws Exception {

    	String path = "/zk-book";
        ZkClient zkClient = new ZkClient("10.11.130.240:2181,10.11.79.217:2181,10.11.79.218:2181", 5000);
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath + " 's child changed, currentChilds:" + currentChilds);
            }
        });
        
        zkClient.createPersistent(path);
        Thread.sleep( 1000 );
        System.out.println(zkClient.getChildren(path));
        Thread.sleep( 1000 );
        zkClient.createPersistent(path+"/c1");
        Thread.sleep( 1000 );
        zkClient.delete(path+"/c1");
        Thread.sleep( 1000 );
        zkClient.delete(path);
        Thread.sleep( Integer.MAX_VALUE );
    }
}