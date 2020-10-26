package 单例模式4类实现方法;

import 单例模式4类实现方法.非线程安全.DCLUnThreadSafe;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wangxi
 * @Time 2019/10/13 21:16
 */
public class TestSingleton {
    public static void main(String[] args) throws InterruptedException {
        //Set<Singleton1> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
//        Set<Singleton3> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
        Set<Integer> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
        AtomicInteger sameInstanceCount = new AtomicInteger(0);
        AtomicInteger notSameInstanceCount = new AtomicInteger(0);
        int threadNum = 100000;
        CountDownLatch latch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                //Singleton1 singleton = Singleton1.getInstance();
//                Singleton3 singleton = Singleton3.getInstance();
                Integer singleton = DCLUnThreadSafe.getInstance().getId();
                // 成功的添加，说明set中没有重复的
                if (set.add(singleton)) {
                    notSameInstanceCount.getAndIncrement();
                } else {
                    sameInstanceCount.getAndIncrement();
                    //System.out.println("存在相同的单实例===" + singleton);
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("相同的实例个数: " + sameInstanceCount.get());
        System.out.println("不同的实例个数： " + notSameInstanceCount.get());
        System.out.println("set的 size= " + set.size());
    }

}
