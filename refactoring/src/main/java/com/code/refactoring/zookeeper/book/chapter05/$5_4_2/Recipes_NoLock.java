package com.code.refactoring.zookeeper.book.chapter05.$5_4_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Recipes_NoLock {

    public static void main(String[] args) throws Exception {
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        down.await();
                    } catch (Exception e) {
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = sdf.format(new Date());
                    System.err.println("生成的订单号是 : " + orderNo);
                }
            }).start();
        }
        // 10个线程等待主线程的结束。本意就是不让10个现成都产生相同的id
        down.countDown();
    }

//    public static void main(String[] args) throws Exception {
//        final CountDownLatch down = new CountDownLatch(10);
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    try {
//                        Thread.sleep(new Random().nextInt(2000));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
//                    String orderNo = sdf.format(new Date());
//                    System.err.println("生成的订单号是 : " + orderNo);
//                    down.countDown();
//                }
//            }).start();
//        }
//        down.await();
//    }
}