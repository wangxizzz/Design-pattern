package 单例模式4类实现方法;

/**  
 * @ClassName: 
 * @Description: 基础饱汉模式  -----具体参见QQ浏览器收藏
 * @author 王喜 
 * @date 2018年3月12日 下午8:20:04  
*/
public class Singleton1 {
	//饱汉模式，即已经吃饱，不着急再吃，饿的时候在吃。故先不初始化对象。
	private static Singleton1 singleton1 = null;
	private Singleton1(){
		
	}
	public static Singleton1 getInstance() {
		if (singleton1 == null) {
			singleton1 = new Singleton1();
		}
		return singleton1;
	}
}
