package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.分布式应用;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Recipes_MasterSelect {
    /**
     * 多客户端选举
     */
	static String master_path = "/curator_recipes_master_path";
	
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("localhost:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
    public static void main( String[] args ) throws Exception {
    	client.start();
        LeaderSelector selector = new LeaderSelector(client, 
        		master_path, 
        		new LeaderSelectorListenerAdapter() {
        	        @Override
		            public void takeLeadership(CuratorFramework client) throws Exception {
		                System.out.println("成为Master角色");
		                // 处理业务逻辑
		                Thread.sleep( 3000 );
		                System.out.println( "完成Master操作，释放Master权利" );
		            }
		        });
        selector.autoRequeue();
        selector.start();
        Thread.sleep( Integer.MAX_VALUE );
	}
}