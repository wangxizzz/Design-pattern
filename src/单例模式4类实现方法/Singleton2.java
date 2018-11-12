package 单例模式4类实现方法;

/**  
 * @ClassName: Singleton2  
 * @Description: 饱汉模式-变种1 -- 并发性差
 * @author 王喜 
 * @date 2018年3月12日 下午8:24:19  
*/
public class Singleton2 {
	private static Singleton2 singleton2 = null;
	private Singleton2(){
		
	}
	public synchronized static Singleton2 getInstance() {
		if (singleton2 == null) {
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}
