package 单例模式4类实现方法;

/**  
 * @ClassName: Singleton5  
 * @Description:  饿汉模式
 * @author 王喜 
 * @date 2018年3月12日 下午8:36:22  
*/

//饿汉模式线程安全，就是加载类后一直不使用，造成资源的浪费  多线程--使用饿汉模式性能更优
public class Singleton5 {
	/**
	 * 静态初始化器，本质由JVM来保证线程安全
	 */
	private static Singleton5 singleton5 = new Singleton5();
	private Singleton5(){
		
	}
	public static Singleton5 getInstance() {
		return singleton5;
	}
}
