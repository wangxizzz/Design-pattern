package 单例模式4类实现方法;

/**  
 * @ClassName: Singleton3  
 * @Description: DCL 双重加锁
 * @author 王喜 
 * @date 2018年3月12日 下午8:27:13  
*/
public class Singleton3 {
	private static Singleton3 singleton3 = null;
	private Singleton3(){
		
	}
	public synchronized static Singleton3 getInstance() {
		//可能得到一半的实例
		if (singleton3 == null) {
			synchronized (Singleton3.class) {
				//得到完整的实例
				if (singleton3 == null) {
					singleton3 = new Singleton3();
				}
			}
		}
		return singleton3;
	}
}
