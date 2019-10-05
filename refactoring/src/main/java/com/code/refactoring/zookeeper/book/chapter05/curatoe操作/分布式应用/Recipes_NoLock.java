package com.code.refactoring.zookeeper.book.chapter05.curatoe操作.分布式应用;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Recipes_NoLock {
    /**
     * 分布式情况下，无锁并发场景下会生成重复订单号
     */
    // 主线程等待10个线程完成
    public static void main(String[] args) throws Exception {
        final CountDownLatch down = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.err.println("生成的订单号是 : " + orderNo);
                down.countDown();
            }).start();
        }
        down.await();
    }
}