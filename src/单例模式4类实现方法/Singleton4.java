package 单例模式4类实现方法;

/**  
 * @ClassName: Singleton4  
 * @Description: 采用volatile关键字，线程安全
 * @author 王喜 
 * @date 2018年3月12日 下午8:29:37  
*/
public class Singleton4 {
	private volatile static Singleton4 singleton4 = null;
	private Singleton4(){
		
	}
	public static Singleton4 getInstance() {
		if (singleton4 == null) {
			synchronized (Singleton4.class) {
				//得到完整的实例
				if (singleton4 == null) {
					singleton4 = new Singleton4();
				}
			}
		}
		return singleton4;
	}
}
