package 单例模式4类实现方法;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: 
 * @Description: 基础饱汉模式 ，线程不安全
 * @author 王喜 
 * @date 2018年3月12日 下午8:20:04  
*/
public class Singleton1 {
	//饱汉模式，即已经吃饱，不着急再吃，饿的时候在吃。故先不初始化对象。
	private static Singleton1 singleton1 = null;
	private Singleton1(){
		// 模拟创建对象很耗时间
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	/**
	 * 错误的写法，在并发量很大时，会出现多个地址不同实例
     * 在TestSingleton 类进行了验证
	 */
	public static Singleton1 getInstance() {
		if (singleton1 == null) {
			singleton1 = new Singleton1();
		}
		return singleton1;
	}

}
