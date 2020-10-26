package 单例模式4类实现方法.非线程安全;

import java.util.Random;

/**
 * @author wangxi created on 2020/9/12 21:29
 * @version v1.0
 * 可能存在的问题：
 * 我们初始化一个类，会产生多条汇编指令，然而总结下来，是执行下面三个事情：
 *
 * 1.给LazySingleton 的实例分配内存。
 * 2.初始化LazySingleton 的构造器
 * 3.将instance对象指向分配的内存空间（注意到这步instance就非null了）
 *
 * Java编译器允许处理器乱序执行（out-of-order），我们有可能是1->2->3也有可能是1->3->2。即我们有可能在先返回instance实例，然后执行构造方法。
 *
 *
 * 可能存在的问题举例：
 *
 * 线程A、B执行getInstance().getId()
 *
 * 在某一时刻，线程A执行到(5)，并且初始化顺序为：1->3->2，当执行完将instance对象指向分配空间时。此时线程B执行(1)，
 * 发现instance!=null，继续执行，最后调用getId()返回0。此时切换到线程B对构造方法初始化。

 *
 *
 */
public class DCLUnThreadSafe {
    private int id;
    private static DCLUnThreadSafe instance;

    private DCLUnThreadSafe() {
        this.id = new Random().nextInt(200) + 1;                 // (1)
    }

    public static DCLUnThreadSafe getInstance() {
        if (instance == null) {                               // (2)
            synchronized (DCLUnThreadSafe.class) {               // (3)
                if (instance == null) {                       // (4)
                    instance = new DCLUnThreadSafe();           // (5)
                }
            }
        }
        return instance;                                      // (6)
    }

    public int getId() {
        return id;                                            // (7)
    }
}
