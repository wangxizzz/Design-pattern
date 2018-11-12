package 单例模式;
/**
 * 
 * @ClassName: Singleton  
 * @Description:单例模式通用代码 
 * @author 王喜 
 * @date 2018年3月3日 下午3:44:00
 */
public class Singleton {
	//自行实例一个对象
	private static final Singleton SINGLETON = new Singleton();
	//限制在其他地方产生对象
	private Singleton () {
		
	}
	//在其他地方通过该方法获得这个实例对象
	public static Singleton getSingleton() {
		//注意：在静态方法中只能访问静态方法       , 在非静态方法中可以访问静态变量
		return SINGLETON;
	}
	//类中其他方法，尽量是static的
	public static void doSomeThing() {
		// TODO 
	}
}
